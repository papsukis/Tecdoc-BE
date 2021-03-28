package com.adMaroc.Tecdoc.BackOffice.Services;

import com.adMaroc.Tecdoc.BackOffice.Configurations.FilesConfig;
import com.adMaroc.Tecdoc.BackOffice.DTO.tecdoc.ArticleImageDTO;
import com.adMaroc.Tecdoc.BackOffice.Utils.JsonReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

}
