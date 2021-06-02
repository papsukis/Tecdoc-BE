package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Configurations.FilesConfig;
import com.adMaroc.Tecdoc.BackOffice.DTO.Linkage.LinkageResponse;
import com.adMaroc.Tecdoc.BackOffice.DTO.Linkage.LinkedManufacturer;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.*;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdocComplete.LinkedArticlesCDTO;
import com.adMaroc.Tecdoc.BackOffice.Models.ExcelCell;
import com.adMaroc.Tecdoc.BackOffice.Models.ExcelSheet;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.CustomTecdocGetRepository;
import com.adMaroc.Tecdoc.BackOffice.Repository.custom.TecdocCustomRepository;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ExcelConverter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ArticleImageDTO> listUsers;
    @Autowired
    JsonReader json;
    @Autowired
    FilesConfig config;
    @Autowired
    TecdocBuilder tecdocBuilder;
    @Autowired
    TecdocCustomRepository tecdocCustomRepository;

    @Autowired
    CustomTecdocGetRepository tecdocGetRepository;
    public void contactListToExcelFile(List<ArticleImageDTO> articles) {
        log.info("creating excel file");
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Articles");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // Creating header
            Cell cell = row.createCell(0);
            cell.setCellValue("Article Nr");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Full path");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Brand Number");
            cell.setCellStyle(headerCellStyle);
            cell = row.createCell(3);
            cell.setCellValue("Brand Name");
            cell.setCellStyle(headerCellStyle);
            // Creating data rows for each customer
            for(int i = 0; i < articles.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(articles.get(i).getArtNr());
                dataRow.createCell(1).setCellValue(articles.get(i).getFullPath());
                dataRow.createCell(2).setCellValue(articles.get(i).getDlnr());
                dataRow.createCell(3).setCellValue(articles.get(i).getBrandName());
            }

            // Making size of column auto resize to fit with data
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            ByteArrayOutputStream fos = outputStream;
            outputStream.close();
            FileOutputStream f = new FileOutputStream(config.getExcelFullPath()+"articles.xlsx");
            f.write(outputStream.toByteArray());
            f.close();
            fos.close();
            log.info("excel file created");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ByteArrayInputStream convertToExcel(List<ArticleDTO> articles) throws ParseException {
        log.info("creating excel file");
        try(Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Articles");

            Row row = sheet.createRow(0);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Cell cell = row.createCell(0);
            cell.setCellValue("Nr Article");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Equipementier");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Designation");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Description");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Status");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(5);
            cell.setCellValue("Donnees techniques");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(6);
            cell.setCellValue("EAN");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(7);
            cell.setCellValue("Num utilisation");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(8);
            cell.setCellValue("Liaisons");
            cell.setCellStyle(headerCellStyle);

            Sheet sheet2 = workbook.createSheet("Affectations");

            Row row2 = sheet2.createRow(0);

            Cell cell2 = row2.createCell(0);
            cell.setCellValue("Nr Article");
            cell.setCellStyle(headerCellStyle);

            cell = row2.createCell(1);
            cell.setCellValue("Equipementier");
            cell.setCellStyle(headerCellStyle);

            cell = row2.createCell(2);
            cell.setCellValue("Marque");
            cell.setCellStyle(headerCellStyle);

            cell = row2.createCell(3);
            cell.setCellValue("Vehicule");
            cell.setCellStyle(headerCellStyle);

            cell = row2.createCell(4);
            cell.setCellValue("Type");
            cell.setCellStyle(headerCellStyle);

            long rowCount=1;
            for(int i = 0; i < articles.size(); i++) {
                ArticleDTO tmp = tecdocBuilder.buildArticleforXlsx(articles.get(i));
                Row dataRow = sheet.createRow(i + 1);
                //ref
                dataRow.createCell(0).setCellValue(tmp.getArtNr());
                //equipementier
                dataRow.createCell(1).setCellValue(tmp.getManufacturer().getLongCode().getDescription());
                //equipementier
                //gen art
                String gen="";
                for(GenericArticleDTO genArt:tmp.getGenericArticle()){
                    gen+=genArt.getDescription().getDescription()+";";
                }
                dataRow.createCell(2).setCellValue(gen);
                //article description
                dataRow.createCell(3).setCellValue(tmp.getArticleDescription()!=null?tmp.getArticleDescription().getDescription():"null");
                //article status
                dataRow.createCell(4).setCellValue(tmp.getArticleData().size()>0?tmp.getArticleData().get(0).getArticleStatus().getValue().getDescription():"Normal");

                //donnees technique
                String criteria="";
                for(CriteriaDTO crit:tmp.getCriterias()){
                    if(crit.getType().contains("A")){
                        criteria+=crit.getDescription().getDescription()+" : "+crit.getValue()+";";
                    }
                    if(crit.getType().contains("N")){
                        criteria+=crit.getDescription().getDescription()+" : "+crit.getValue()+";";

                    }
                    if(crit.getType().contains("D")){
                        criteria+=crit.getDescription().getDescription()+" : "+new SimpleDateFormat("YYYYmm").parse(crit.getValue())+";";

                    }
                    if(crit.getType().contains("K")){
                        criteria+=crit.getKeyTable().getLabel().getDescription()+" : "+crit.getKeyTable().getValue().getDescription()+";";

                    }
                    if(crit.getType().contains("V")){
                        criteria+=crit.getValue()+";";
                    }
                }
                for(ArticleInformationDTO artInfo:tmp.getArticleInformations()){
                    criteria+=artInfo.getInformationType().getValue()+" : "+artInfo.getText()+";";
                }
                dataRow.createCell(5).setCellValue(criteria);
                //ean
                String ean="";
                for(EANDTO e:tmp.getEans()){
                    ean+=""+e.getEanNr();
                }
                dataRow.createCell(6).setCellValue(ean);
                //trade numbers
                String tradenumber="";
                for(TradeNumberDTO trade:tmp.getTradeNumbers()){
                    tradenumber+=trade.getTradeNumber()+";";
                }
                dataRow.createCell(7).setCellValue(tradenumber);
                //linkage TODO

                String links="";
                List<LinkedArticlesCDTO> linked =tecdocGetRepository.findArticleLinkage(tmp.getArtNr()).stream().map(tecdocBuilder::buildLinkedArticles).collect(Collectors.toList());

                for(int j = 0; j < linked.size(); j++ ){
//                    art=tecdocBuilder.buildLinkedArticles(art);
                    LinkedArticlesCDTO art=linked.get(j);
                    Row dataRow2 = sheet2.createRow((int) rowCount++);
                    dataRow2.createCell(0).setCellValue(tmp.getArtNr());

                    dataRow2.createCell(1).setCellValue(
                            new DescriptionDTO(
                            tecdocCustomRepository.findCountryAndLanguageDependentDescriptionsByLbeznr(
                                    Long.valueOf(tmp.getManufacturer().getLongCode().getBezNr())
                            )).getDescription()
                        );
                    switch ((int)linked.get(j).getTypeNr()) {
                        case 2:

                            dataRow2.createCell(2).setCellValue(
                                    art.getVehicleType().getVehicleModelSerie().getManufacturer().getLongCode().getDescription()
                            );
                            dataRow2.createCell(3).setCellValue(
                                    art.getVehicleType().getVehicleModelSerie().getDescription().getDescription().replaceAll("\\(.*?\\)","")
                                            + " - "
                                            + new SimpleDateFormat("YYYY-mm").format(art.getVehicleType().getVehicleModelSerie().getFrom())
                                            + (art.getVehicleType().getVehicleModelSerie().getTo() != null ? " a " + new SimpleDateFormat("YYYY-mm").format(art.getVehicleType().getVehicleModelSerie().getTo()) : "")
                            );
                            dataRow2.createCell(4).setCellValue(
                                    art.getVehicleType().getDescription().getDescription().replaceAll("\\(.*?\\)","")
                                            + " - "
                                            + art.getVehicleType().getEngineOutputHP() + " HP"
                                            + "(" + art.getVehicleType().getEngineOutputKW() + " KW)"
                                            + " - "
                                            + new SimpleDateFormat("YYYY-mm").format(art.getVehicleType().getFrom())
                                            + (art.getVehicleType().getVehicleModelSerie().getTo() != null ? " a " + new SimpleDateFormat("YYYY-mm").format(art.getVehicleType().getTo()) : "")

                            );

                            break;
                        case 16:
                            dataRow2.createCell(2).setCellValue(
                                    art.getCvTypes().getVehicleModelSerie().getManufacturer().getLongCode().getDescription()
                            );
                            dataRow2.createCell(3).setCellValue(
                                    art.getCvTypes().getVehicleModelSerie().getDescription().getDescription().replaceAll("\\(.*?\\)","")
                                            + " - "
                                            + (art.getCvTypes().getVehicleModelSerie().getTo() != null ?new SimpleDateFormat("YYYY-mm").format(art.getCvTypes().getVehicleModelSerie().getFrom()): "")
                                            + (art.getCvTypes().getVehicleModelSerie().getTo() != null ? " a " + new SimpleDateFormat("YYYY-mm").format(art.getCvTypes().getVehicleModelSerie().getTo()) : "")

                            );
                            dataRow2.createCell(4).setCellValue(
                                    art.getCvTypes().getDescription().getDescription().replaceAll("\\(.*?\\)","")
                                            + " - "
                                            + art.getCvTypes().getEngineOutputFromKW() + " HP"
                                            + "(" + art.getCvTypes().getEngineOutputFromHP() + " KW)"
                                            + " - "
                                            + (art.getCvTypes().getTo() != null ? new SimpleDateFormat("YYYY-mm").format(art.getCvTypes().getFrom()):"")
                                            + (art.getCvTypes().getTo() != null ? " a " + new SimpleDateFormat("YYYY-mm").format(art.getCvTypes().getTo()) : "")

                            );

                            break;

                    }
                }

            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);
            sheet.autoSizeColumn(5);
            sheet.autoSizeColumn(6);
            sheet.autoSizeColumn(7);

            sheet2.autoSizeColumn(0);
            sheet2.autoSizeColumn(1);
            sheet2.autoSizeColumn(2);
            sheet2.autoSizeColumn(3);
            sheet2.autoSizeColumn(4);




            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            log.info("excel file created");
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}
