package com.adMaroc.Tecdoc.BackOffice.Utils;

import com.adMaroc.Tecdoc.BackOffice.Configurations.FilesConfig;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.impl.VolumedArchiveInStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.*;

@Slf4j
public class OpenMultipartArchive7z {


    /**
     * In this example we use VolumedArchiveInStream class only.
     * It means, we doesn't pass instances of this class directly
     * to 7-Zip, so not complete implementation
     * of {@link IArchiveOpenVolumeCallback} is required.
     * See VolumedArchiveInStream JavaDoc for more information
     */

    private static class ArchiveOpenVolumeCallback
            implements IArchiveOpenVolumeCallback {

        /**
         * Cache for opened file streams
         */
        private Map<String, RandomAccessFile> openedRandomAccessFileList =
                new HashMap<String, RandomAccessFile>();

        /**
         * This method doesn't needed, if using with VolumedArchiveInStream
         * and pass the name of the first archive in constructor.
         * (Use two argument constructor)
         *
         * @see IArchiveOpenVolumeCallback#getProperty(PropID)
         */
        public Object getProperty(PropID propID) throws SevenZipException {
            return null;
        }

        /**
         *
         * The name of the required volume will be calculated out of the
         * name of the first volume and volume index. If you need
         * need volume index (integer) you will have to parse filename
         * and extract index.
         *
         * <pre>
         * int index = filename.substring(filename.length() - 3,
         *         filename.length());
         * </pre>
         *
         */
        public IInStream getStream(String filename) throws SevenZipException {
            try {
                // We use caching of opened streams, so check cache first
                RandomAccessFile randomAccessFile = openedRandomAccessFileList
                        .get(filename);
                if (randomAccessFile != null) { // Cache hit.
                    // Move the file pointer back to the beginning
                    // in order to emulating new stream
                    randomAccessFile.seek(0);
                    return new RandomAccessFileInStream(randomAccessFile);
                }

                // Nothing useful in cache. Open required volume.
                randomAccessFile = new RandomAccessFile(filename, "r");

                // Put new stream in the cache
                openedRandomAccessFileList.put(filename, randomAccessFile);

                return new RandomAccessFileInStream(randomAccessFile);
            } catch (FileNotFoundException fileNotFoundException) {
                // Required volume doesn't exist. This happens if the volume:
                // 1. never exists. 7-Zip doesn't know how many volumes should
                //    exist, so it have to try each volume.
                // 2. should be there, but doesn't. This is an error case.

                // Since normal and error cases are possible,
                // we can't throw an error message
                return null; // We return always null in this case
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Close all opened streams
         */
        void close() throws IOException {
            for (RandomAccessFile file : openedRandomAccessFileList.values()) {
                file.close();
            }
        }
    }


    private static class MyExtractCallback implements IArchiveExtractCallback {
        private final IInArchive inArchive;
        private final String extractPath;
        public MyExtractCallback(IInArchive inArchive,  String extractPath) {
            this.inArchive = inArchive;
            this.extractPath = extractPath;
        }
        @Override
        public ISequentialOutStream getStream(final int index, ExtractAskMode extractAskMode) throws SevenZipException {
            return new ISequentialOutStream() {
                @Override
                public int write(byte[] data) throws SevenZipException {
                    String filePath = inArchive.getStringProperty(index, PropID.PATH);
                    FileOutputStream fos = null;
                    try {
                        File path = new File(extractPath+"/"+ filePath);

                        if (!path.getParentFile().exists()) {
                            path.getParentFile().mkdirs();
                        }

                        if (!path.exists()) {
                            path.createNewFile();
                        }
                        fos = new FileOutputStream(path, true);
                        fos.write(data);
                    } catch (IOException e) {
                        log.error("IOException while extracting "+filePath, e);
                    } finally {
                        try {
                            if (fos != null) {
                                fos.flush();
                                fos.close();
                            }
                        } catch (IOException e) {
                            log.error("Could not close FileOutputStream", e);
                        }
                    }
                    return data.length;
                }
            };
        }
        @Override
        public void prepareOperation(ExtractAskMode extractAskMode) throws SevenZipException {}
        @Override
        public void setOperationResult(ExtractOperationResult extractOperationResult) throws SevenZipException {}
        @Override
        public void setCompleted(long completeValue) throws SevenZipException {}
        @Override
        public void setTotal(long total) throws SevenZipException {}
    }

    public static void extract(String file, String extractPath) throws SevenZipException, IOException  {
        ArchiveOpenVolumeCallback archiveOpenVolumeCallback = null;
        IInArchive inArchive = null;

        RandomAccessFile randomAccessFile = null;
        try {
            archiveOpenVolumeCallback = new ArchiveOpenVolumeCallback();
            inArchive = SevenZip.openInArchive(ArchiveFormat.SEVEN_ZIP,
                    new VolumedArchiveInStream(file,
                            archiveOpenVolumeCallback));
            inArchive.extract(null, false, new MyExtractCallback(inArchive, extractPath));
        }
        catch(Exception e){
            throw new InternalServerException(e.getMessage());
        }
        finally {
            if (inArchive != null) {
                try {
                    inArchive.close();
                } catch (SevenZipException e) {
                    throw new InternalServerException("Error closing archive: " + e);
                }
            }
            if (archiveOpenVolumeCallback != null) {
                try {
                    archiveOpenVolumeCallback.close();
                } catch (IOException e) {
                    throw new InternalServerException("Error closing file: " + e);
                }
            }
        }
    }
//    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println(
//                    "Usage: java OpenMultipartArchive7z <first-volume>");
//            return;
//        }
//        try {
//
//
//
//            System.out.println("   Size   | Compr.Sz. | Filename");
//            System.out.println("----------+-----------+---------");
//            int itemCount = inArchive.getNumberOfItems();
//            for (int i = 0; i < itemCount; i++) {
//                System.out.println(String.format("%9s | %9s | %s", //
//                        inArchive.getProperty(i, PropID.SIZE),
//                        inArchive.getProperty(i, PropID.PACKED_SIZE),
//                        inArchive.getProperty(i, PropID.PATH)));
//            }
//        } catch (Exception e) {
//            System.err.println("Error occurs: " + e);
//        } finally {
//            if (inArchive != null) {
//                try {
//                    inArchive.close();
//                } catch (SevenZipException e) {
//                    System.err.println("Error closing archive: " + e);
//                }
//            }
//            if (archiveOpenVolumeCallback != null) {
//                try {
//                    archiveOpenVolumeCallback.close();
//                } catch (IOException e) {
//                    System.err.println("Error closing file: " + e);
//                }
//            }
//        }
//    }
}