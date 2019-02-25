/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPHeaderCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import process.SelectProcess;

/**
 *
 * @author Nas
 */
public class GlasswareInventoryReport {

    private String FILE_DIRECTORY = System.getProperty("user.home") + "\\Documents\\Inventory Reports\\Glassware";
    private String FILENAME = "GReport_";

    private final Font FONT_BOLD_11 = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
    private final Font FONT_BOLD_10 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private final Font FONT_BOLD_10_UNDERLINE = new Font(Font.FontFamily.HELVETICA, 10, Font.UNDERLINE);
    private final Font FONT_NORMAL_09_ITALIC = new Font(Font.FontFamily.HELVETICA, 9, Font.ITALIC);

    private BaseFont bf;
    private ResultSet RESULT;
    private static int iCount;
    private final SelectProcess selectProcess = new SelectProcess();

    public GlasswareInventoryReport(String filename) {
        createFont();
        createDirectory();

        FILENAME += filename + ".pdf";

        File file = new File(FILE_DIRECTORY);
        if (file.mkdirs()) {
        }
    }

    private void addHeader(Document document) throws DocumentException {
        Paragraph vsu = new Paragraph("VISAYAS STATE UNIVERSITY", FONT_BOLD_11);
        Paragraph dopac = new Paragraph("DEPARTMENT OF PURE AND APPLIED CHEMISTRY", FONT_BOLD_11);
        Paragraph chemicalPara = new Paragraph("Inventory of Glasswares", FONT_BOLD_10);
        Paragraph datePara = new Paragraph("Date: " + DateFormat.getDateInstance().format(new java.util.Date()), FONT_BOLD_10);
        chemicalPara.setAlignment(Element.ALIGN_CENTER);

        vsu.setAlignment(Element.ALIGN_CENTER);
        dopac.setAlignment(Element.ALIGN_CENTER);
        datePara.setAlignment(Element.ALIGN_CENTER);

        dopac.setSpacingAfter(20);
        datePara.setSpacingAfter(20);

        document.add(vsu);
        document.add(dopac);
        document.add(chemicalPara);
        document.add(datePara);

        PdfPTable header;
        header = new PdfPTable(new float[]{10,35,15,20,20});
        PdfPCell cellHead = new PdfPHeaderCell();
        cellHead.setVerticalAlignment(Element.ALIGN_CENTER);

        PdfPCell cell = new PdfPCell(new Phrase("EntryNo", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        //cell.set
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("Glassware Name", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("Quantity", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("Size", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);
        
        cell = new PdfPCell(new Phrase("Remarks", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        header.setWidthPercentage(100);

        addTableContent(document, header);
    }

    private void addTableContent(Document document, PdfPTable table) throws DocumentException {
        try {
            iCount = 1;
            RESULT = selectProcess.exportGlasswareInventory();
            //b.name 'Glassware', SUM(a.Quantity), a.Size
            while (RESULT.next()) {

                // entry no.
                PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(iCount++), FONT_BOLD_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
                //cell.set
                table.addCell(cell);

                //glass name
                cell = new PdfPCell(new Phrase(RESULT.getString(1), FONT_BOLD_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                //size
                cell = new PdfPCell(new Phrase(RESULT.getString(2), FONT_BOLD_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
                table.addCell(cell);

                // qty
                cell = new PdfPCell(new Phrase(RESULT.getString(3), FONT_BOLD_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
                table.addCell(cell);

                // date added
                cell = new PdfPCell(new Phrase("", FONT_BOLD_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
                table.addCell(cell);
            }
            document.add(table);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void exportData() {
        try {
            Document document = new Document(PageSize.A4.rotate(), 50, 40, 40, 30);
            PdfWriter.getInstance(document, new FileOutputStream(FILE_DIRECTORY + "\\" + FILENAME));
            document.open();
            addMetaData(document);

            addHeader(document);
            
            //addFooter(document);
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    public String getFilePath(){
        return FILE_DIRECTORY + "\\" + FILENAME;
    }
    private void addMetaData(Document document) {
        document.addTitle("Glassware Reports");
        document.addAuthor("Department of Pure and Applied Sciences");
    }

    private void addFooter(Document document, String userName[]) throws DocumentException {
        Paragraph pSpace = new Paragraph("");
        Paragraph footer = new Paragraph("Prepared by: ", FONT_BOLD_10);
        Paragraph name = new Paragraph(userName[0], FONT_BOLD_10_UNDERLINE);
        Paragraph desc = new Paragraph(setDesignation(userName), FONT_NORMAL_09_ITALIC);

        pSpace.setSpacingAfter(40);
        footer.setAlignment(Element.ALIGN_LEFT);
        footer.setSpacingAfter(10);
        name.setAlignment(Element.ALIGN_LEFT);
        desc.setAlignment(Element.ALIGN_LEFT);

        document.add(pSpace);
        document.add(footer);
        document.add(name);
        document.add(desc);
    }

    private String setDesignation(String obj[]) {
        String space = "";

        //System.out.println(obj[0] + " " + obj[1]);
        int x = (obj[0].length() + 1) - (obj[1].length() + 1);

        for (int i = 0; i < x; i++) {
            space += " ";
        }

        return space + obj[1];
    }

    private void createDirectory() {
        String mo[] = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String date[] = DateFormat.getDateInstance(3).format(new java.util.Date()).split("/");

        int month = Integer.valueOf(date[0]);
        int year = 2000 + Integer.valueOf(date[2]);

        FILE_DIRECTORY += "\\" + year + "\\" + mo[month];

    }

    private void createFont() {
        try {
            this.bf = BaseFont.createFont("c:/windows/fonts/arialbd.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }

}
