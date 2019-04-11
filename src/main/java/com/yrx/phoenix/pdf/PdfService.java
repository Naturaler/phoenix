package com.yrx.phoenix.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by r.x on 2019/4/12.
 */
public class PdfService {

    private PdfService() {

    }

    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        // createPdf();
        chinese();
    }

    public static void createPdf() throws DocumentException, FileNotFoundException {
        final String DEST = "E:\\tmp\\target\\HelloWorld.pdf";
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        document.add(new Paragraph("hello world, 李宁"));
        document.close();
        writer.close();
    }

    public static void chinese() throws FileNotFoundException, DocumentException {
        final String DEST = "target/HelloWorld_CN.pdf";
        final String FONT = "fonts/SimHei.ttf";
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(DEST));
        document.open();
        Font f1 = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        document.add(new Paragraph("hello world,我是鲁家宁", f1));
        document.close();
        writer.close();
    }

}
