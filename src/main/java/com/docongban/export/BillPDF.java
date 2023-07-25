package com.docongban.export;

import com.docongban.entity.Discount;
import com.docongban.entity.OrderAccount;
import com.docongban.entity.OrderDetail;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillPDF {

    private final String fontPath = "src/main/resources/static/font/arial-unicode-ms.ttf";

    public BillPDF() {
    }

    private void writeTableHeader(PdfPTable table) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);

        PdfPCell cellCenter = new PdfPCell();
        cellCenter.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cellCenter.setPadding(5);

        BaseFont unicodeFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(unicodeFont, 12);

        cell.setPhrase(new Phrase("Sản phẩm", font));
        table.addCell(cell);

        cellCenter.setPhrase(new Phrase("Số lượng", font));
        table.addCell(cellCenter);

        cell.setPhrase(new Phrase("Giá", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table, List<OrderDetail> orderDetailList) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setPaddingLeft(5);

        PdfPCell cellCenter = new PdfPCell();
        cellCenter.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        BaseFont unicodeFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(unicodeFont, 12);
        for (OrderDetail orderDetail : orderDetailList) {
            cell.setPhrase(new Phrase(orderDetail.getProductTitle(), font));
            table.addCell(cell);

            cellCenter.setPhrase(new Phrase(String.valueOf(orderDetail.getOrderQuantity()), font));
            table.addCell(cellCenter);

            cell.setPhrase(new Phrase(String.valueOf(orderDetail.getProductPrice()), font));
            table.addCell(cell);
        }
    }

    private void tableNoBorderTopBottom(PdfPTable table, String name, Double value) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setPaddingLeft(5);

        PdfPCell cellRight = new PdfPCell();
        cellRight.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        BaseFont unicodeFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(unicodeFont, 12);

        cellRight.setPhrase(new Phrase(name, font));
        table.addCell(cellRight);
        cellRight.setBorderColorBottom(Color.WHITE);
        cellRight.setBorderColorTop(Color.WHITE);

        cell.setPhrase(new Phrase(String.valueOf(value), font));
        cell.setBorderColorBottom(Color.WHITE);
        cell.setBorderColorTop(Color.WHITE);
        table.addCell(cell);
    }

    private void tableNoBorderBottom(PdfPTable table, String name, Double value) throws IOException {
        PdfPCell cell = new PdfPCell();
        cell.setPaddingLeft(5);

        PdfPCell cellRight = new PdfPCell();
        cellRight.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        BaseFont unicodeFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(unicodeFont, 12);

        cellRight.setPhrase(new Phrase(name, font));
        table.addCell(cellRight);
        cellRight.setBorderColorBottom(Color.WHITE);

        cell.setPhrase(new Phrase(String.valueOf(value), font));
        cell.setBorderColorBottom(Color.WHITE);
        table.addCell(cell);
    }

    List<Double> total(List<Discount> discounts,List<OrderDetail> orderDetails){
        List<Double> list=new ArrayList<>();
        Double total = 0D;
        Double t = 0D;
        Double totalPriceOrigin=0D;
        Double totalPrice=0D;
        Double disountValue=0D;
        for (OrderDetail od : orderDetails) {
            total += (od.getProductPrice() * od.getOrderQuantity());
            t = total;
        }
        totalPriceOrigin = total;
        for(int i = 0 ; i < discounts.size() ; i++) {
            Double nextValue = discounts.get(i).getValue();
            if( total < nextValue ) {
                if( i > 0 ) {
                    total -= (total * discounts.get(i-1).getDiscount()/100);
                    break;
                }
                else {
                    break;
                }
            }
        }
        totalPrice = total;
        disountValue = t-total;

        list.add(totalPriceOrigin);
        list.add(disountValue);
        list.add(totalPrice);

        return list;
    }

    public void export(HttpServletResponse response, List<OrderDetail> orderDetailList, OrderAccount orderAccount, List<Discount> discounts) throws DocumentException, IOException {
        Document document = new Document(PageSize.A5);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        BaseFont unicodeFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(unicodeFont, 18);

        Paragraph p = new Paragraph("Thông tin hóa đơn", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);

        Font fontInfo = new Font(unicodeFont, 10);
        Paragraph fullname = new Paragraph("Khách hàng: "+orderAccount.getAccountFullname(), fontInfo);
        Paragraph phone = new Paragraph("SĐT: "+orderAccount.getAccountPhone(), fontInfo);
        Paragraph address = new Paragraph("Địa chỉ: "+orderAccount.getAccountAddress(), fontInfo);
        Paragraph time = new Paragraph("Thời gian đặt hàng: "+String.valueOf(orderAccount.getOrderDate()), fontInfo);
        document.add(fullname);
        document.add(phone);
        document.add(address);
        document.add(time);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {5.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table, orderDetailList);

        PdfPTable tableTotal = new PdfPTable(2);
        tableTotal.setWidthPercentage(100f);
        tableTotal.setWidths(new float[] {7.0f, 2.0f});
        tableNoBorderTopBottom(tableTotal,"Tổng",total(discounts,orderDetailList).get(0));
        tableNoBorderTopBottom(tableTotal,"Khuyến mãi",total(discounts, orderDetailList).get(1));
        tableNoBorderBottom(tableTotal,"Thành tiền",total(discounts, orderDetailList).get(2));

        document.add(table);
        document.add(tableTotal);

        document.close();

    }
}
