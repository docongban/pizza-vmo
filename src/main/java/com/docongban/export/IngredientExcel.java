package com.docongban.export;

import com.docongban.entity.Ingredient;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class IngredientExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private String month;

    private List<Ingredient> ingredientList;

    public IngredientExcel(List<Ingredient> ingredientList,String month) {
        this.ingredientList = ingredientList;
        this.month = month;
        workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell=row.createCell(columnCount);
        if(value instanceof Long) {
            cell.setCellValue((Long) value);
        }else if(value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }else if(value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if(value instanceof Instant) {
            Date myDate = Date.from((Instant)value);
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String formattedDate = formatter.format(myDate);
            cell.setCellValue(formattedDate);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeTitleLine(String month) {
        sheet=workbook.createSheet("Tháng "+month);

        Row row = sheet.createRow(0);
        row.setHeight(Short.parseShort("500"));
        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints(Short.parseShort("16"));
        font.setBold(true);
        style.setFont(font);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row,0,"Quản lý chi tiêu tháng "+month,style);
        createCell(row,1,"Quản lý chi tiêu tháng "+month,style);
        createCell(row,2,"Quản lý chi tiêu tháng "+month,style);
        createCell(row,3,"Quản lý chi tiêu tháng "+month,style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
    }
    private void writeHeaderLine() {
        Row row = sheet.createRow(1);
        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints(Short.parseShort("12"));
        font.setBold(true);
        style.setFont(font);
        style.setWrapText(true);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);

        createCell(row, 0, "STT", style);
        createCell(row, 1, "Nội dung", style);
        createCell(row, 2, "Giá", style);
        createCell(row, 3, "Thời gian", style);

    }

    private void writeDataLines(Long total) {
        int rowCount=2;

        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints(Short.parseShort("12"));
        style.setFont(font);
        style.setWrapText(true);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        for(int i=0;i<ingredientList.size();i++) {
            Row row=sheet.createRow(rowCount++);
            int columnCount=0;
            createCell(row, columnCount++, i+1, style);
            createCell(row, columnCount++, ingredientList.get(i).getContent(), style);
            createCell(row, columnCount++, String.format("%,d", ingredientList.get(i).getPrice()), style);
            createCell(row, columnCount++, ingredientList.get(i).getImportTime(), style);
        }
        CellStyle style2=workbook.createCellStyle();
        XSSFFont font2=workbook.createFont();
        font2.setColor(Font.COLOR_RED);
        font2.setBold(true);
        font2.setFontName("Times New Roman");
        font2.setFontHeightInPoints(Short.parseShort("13"));
        style2.setFont(font2);
        style2.setBorderTop(BorderStyle.THIN);
        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setBorderRight(BorderStyle.THIN);
        style2.setAlignment(HorizontalAlignment.RIGHT);
        CellStyle style3=workbook.createCellStyle();
        XSSFFont font3=workbook.createFont();
        font3.setColor(Font.COLOR_RED);
        font3.setBold(true);
        font3.setFontName("Times New Roman");
        font3.setFontHeightInPoints(Short.parseShort("13"));
        style3.setFont(font3);
        style3.setBorderTop(BorderStyle.THIN);
        style3.setBorderBottom(BorderStyle.THIN);
        style3.setBorderLeft(BorderStyle.THIN);
        style3.setBorderRight(BorderStyle.THIN);
        style3.setAlignment(HorizontalAlignment.LEFT);
        int rowLast= rowCount++;
        Row row=sheet.createRow(rowLast);
        createCell(row, 0, "Tổng chi", style2);
        createCell(row, 1, "Tổng chi", style2);
        createCell(row, 2, String.format("%,d", total), style3);
        createCell(row, 3, String.format("%,d", total), style3);
        sheet.addMergedRegion(new CellRangeAddress(rowLast,rowLast,0,1));
        sheet.addMergedRegion(new CellRangeAddress(rowLast,rowLast,2,3));
        sheet.setColumnWidth(0,1500);
        sheet.setColumnWidth(1,30000);
        sheet.setColumnWidth(2,4500);
        sheet.setColumnWidth(3,6000);
    }

    public void export(HttpServletResponse response,String month,Long total) throws IOException {
        writeTitleLine(month);
        writeHeaderLine();
        writeDataLines(total);

        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
