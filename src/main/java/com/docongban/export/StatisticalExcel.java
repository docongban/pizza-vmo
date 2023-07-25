package com.docongban.export;

import com.docongban.payload.StatisticalDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class StatisticalExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public StatisticalExcel() {
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

    private void writeTitleLine(Double tangTruong,String preMonth,String month) {
        sheet=workbook.createSheet("Tháng "+month);

        Row row = sheet.createRow(0);
        row.setHeight(Short.parseShort("500"));
        CellStyle style=workbook.createCellStyle();
        XSSFFont font=workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints(Short.parseShort("16"));
        font.setBold(true);
        style.setFont(font);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        createCell(row,0,"Thống kê doanh thu tháng "+month,style);
        createCell(row,1,"Thống kê doanh thu tháng "+month,style);
        createCell(row,2,"Thống kê doanh thu tháng "+month,style);
        createCell(row,3,"Thống kê doanh thu tháng "+month,style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

        Row rowTang = sheet.createRow(1);
        CellStyle style2=workbook.createCellStyle();
        XSSFFont font2=workbook.createFont();
        font2.setFontName("Times New Roman");
        font2.setColor(Font.COLOR_RED);
        font2.setFontHeightInPoints(Short.parseShort("12"));
        font2.setItalic(true);
        style2.setFont(font2);
        style2.setBorderTop(BorderStyle.THIN);
        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setBorderRight(BorderStyle.THIN);
        createCell(rowTang,0,"Tốc độ tăng trưởng so với tháng "+preMonth +": "+tangTruong+"%",style2);
        createCell(rowTang,1,"Tốc độ tăng trưởng so với tháng "+preMonth +": "+tangTruong+"%",style2);
        createCell(rowTang,2,"Tốc độ tăng trưởng so với tháng "+preMonth +": "+tangTruong+"%",style2);
        createCell(rowTang,3,"Tốc độ tăng trưởng so với tháng "+preMonth +": "+tangTruong+"%",style2);
        sheet.addMergedRegion(new CellRangeAddress(1,1,0,3));
    }
    private void writeHeaderLine() {
        Row row = sheet.createRow(2);
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
        createCell(row, 1, "Ngày", style);
        createCell(row, 2, "Doanh thu trước khuyến mãi", style);
        createCell(row, 3, "Doanh thu sau khuyến mãi", style);

    }

    private void writeDataLines(List<StatisticalDTO> statisticalDTOList,Long total,Long totalAfterDiscount,
                                Long totalIngredients, Long totalSalary,Long lai) {
        int rowCount=3;

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

        // doanh thu theo ngày
        for(int i=0;i<statisticalDTOList.size();i++) {
            Row row=sheet.createRow(rowCount++);
            int columnCount=0;
            createCell(row, columnCount++, i+1, style);
            createCell(row, columnCount++, statisticalDTOList.get(i).getDate(), style);
            createCell(row, columnCount++, String.format("%,d", statisticalDTOList.get(i).getTotal()), style);
            createCell(row, columnCount++, String.format("%,d", statisticalDTOList.get(i).getTotalAfterDiscount()), style);
        }
        // tong doanh thu
        int rowTong= rowCount;
        Row rowT=sheet.createRow(rowTong);
        createCell(rowT, 0, null, style);
        createCell(rowT, 1, null, style);
        createCell(rowT, 2, String.format("%,d", total), style);
        createCell(rowT, 3, String.format("%,d", totalAfterDiscount), style);
        sheet.addMergedRegion(new CellRangeAddress(rowTong,rowTong,0,1));

        CellStyle style2=workbook.createCellStyle();
        XSSFFont font2=workbook.createFont();
        font2.setColor(Font.COLOR_RED);
        font2.setFontName("Times New Roman");
        font2.setFontHeightInPoints(Short.parseShort("13"));
        style2.setFont(font2);
        style2.setBorderRight(BorderStyle.THIN);
        style2.setAlignment(HorizontalAlignment.RIGHT);
        // tong chi
        int rowChi= rowTong+1;
        Row rowC=sheet.createRow(rowChi);
        createCell(rowC, 0, "Tổng chi", style2);
        createCell(rowC, 1, "Tổng chi", style2);
        createCell(rowC, 2, "Tổng chi", style2);
        createCell(rowC, 3, String.format("%,d", totalIngredients), style2);
        sheet.addMergedRegion(new CellRangeAddress(rowChi,rowChi,0,2));
        // tong lương
        int rowLuong= rowChi+1;
        Row rowL=sheet.createRow(rowLuong);
        createCell(rowL, 0, "Tổng lương nhân viên", style2);
        createCell(rowL, 1, "Tổng lương nhân viên", style2);
        createCell(rowL, 2, "Tổng lương nhân viên", style2);
        createCell(rowL, 3, String.format("%,d", totalSalary), style2);
        sheet.addMergedRegion(new CellRangeAddress(rowLuong,rowLuong,0,2));

        // lãi
        CellStyle style3=workbook.createCellStyle();
        XSSFFont font3=workbook.createFont();
        font3.setBold(true);
        font3.setFontName("Times New Roman");
        font3.setFontHeightInPoints(Short.parseShort("13"));
        style3.setFont(font3);
        style3.setBorderBottom(BorderStyle.THIN);
        style3.setBorderTop(BorderStyle.THIN);
        style3.setBorderRight(BorderStyle.THIN);
        style3.setAlignment(HorizontalAlignment.RIGHT);
        int rowLai= rowLuong+1;
        Row rowLa=sheet.createRow(rowLai);
        createCell(rowLa, 0, "Tổng lãi thu", style3);
        createCell(rowLa, 1, "Tổng lãi thu", style3);
        createCell(rowLa, 2, "Tổng lãi thu", style3);
        createCell(rowLa, 3, String.format("%,d", lai), style3);
        sheet.addMergedRegion(new CellRangeAddress(rowLai,rowLai,0,2));
        sheet.setColumnWidth(0,1500);
        sheet.setColumnWidth(1,4500);
        sheet.setColumnWidth(2,10000);
        sheet.setColumnWidth(3,10000);
    }

    public void export(HttpServletResponse response,List<StatisticalDTO> statisticalDTOList,Long total,Long totalAfterDiscount,Long totalIngredients,
                       Long totalSalary,Long lai,Double tangTruong,String preMonth,String month) throws IOException {
        writeTitleLine(tangTruong,preMonth,month);
        writeHeaderLine();
        writeDataLines(statisticalDTOList,total,totalAfterDiscount,totalIngredients,totalSalary,lai);

        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
