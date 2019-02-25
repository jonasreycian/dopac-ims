/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.io.FileOutputStream;
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
import gui.Login;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import process.SelectProcess;

/**
 *
 * @author Nas
 */
public class InventoryReport {

    private String FILE_DIRECTORY = System.getProperty("user.home") + "\\Documents\\Inventory Reports\\Chemicals";
    private String FILENAME = "IReport_";

    private final Font FONT_BOLD_11 = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
    private final Font FONT_BOLD_10 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private final Font FONT_NORMAL_10 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
    private final Font FONT_BOLD_10_UNDERLINE = new Font(Font.FontFamily.HELVETICA, 10, Font.UNDERLINE);
    private final Font FONT_NORMAL_09_ITALIC = new Font(Font.FontFamily.HELVETICA, 9, Font.ITALIC);
    //private final String USER_NAME[];

    private BaseFont bf;
    private ResultSet RESULT;
    private static int iCount;
    
    private final SelectProcess selectProcess = new SelectProcess();

    public InventoryReport(String filename) {
        createFont();
        createDirectory();
        
        FILENAME += filename + ".pdf";

        File file = new File(FILE_DIRECTORY);
        if (file.mkdirs()){}
    }
    
    public String getFilePath(){
        return FILE_DIRECTORY + "\\" + FILENAME;
    }
    
    public void exportData() {
        try {
            //Document document = new Document(PageSize.A4.rotate(), 50, 40, 40, 30);
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(FILE_DIRECTORY + "\\" + FILENAME));
            document.open();
            addMetaData(document);

            ResultSet resultSetRoom = selectProcess.getAllRooms();
            try {
                while(resultSetRoom.next()){
                    makeInventory(document, resultSetRoom.getString("name"));
                }
                resultSetRoom.close();
            } catch (SQLException ex) {
                Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            // Inventory of Liquid Chemicals on AC-207
//            //liquidAC207Inventory(document);
//
//            document.newPage();
//            // Inventory of Liquid Chemicals on AC-107
//            liquidAC107Inventory(document);
//            
//            document.newPage();
//            // Inventory of Solid Chemicals on AC-207
//            solidAC207Inventory(document);
//
//            document.newPage();
//            // Inventory of Solid Chemicals on AC-207
//            solidAC107Inventory(document);

            //addFooter(document);
            document.close();

            } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private void createDirectory(){
        String MONTH[] = {"January","February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String date[] = DateFormat.getDateInstance(3).format(new java.util.Date()).split("/");

        Calendar calendar = Calendar.getInstance();
        
        int m = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        
        FILE_DIRECTORY += "\\" + year + "\\" + MONTH[m];
        
    }
    private void createFont(){
        try {
            this.bf = BaseFont.createFont("c:/windows/fonts/arialbd.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException | IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void makeInventory(Document document, String room) {
        iCount = 1;
        try {
            RESULT = selectProcess.exportInventory(room, "Liquid");
            addHeader(document, "Liquid", room);
            document.newPage();
            RESULT.close();
            
            RESULT = selectProcess.exportInventory(room, "Solid");
            addHeader(document, "Solid", room);
            document.newPage();
            RESULT.close();
        } catch (DocumentException | SQLException ex) {
            Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void liquidAC107Inventory(Document doc) {
//        ReadProcess rp = new ReadProcess();
//        try {
//            RESULT = rp.exportData("AC-107", "LIQUID");
//            addHeader(doc, "Liquid", "AC-107");
//        } catch (DocumentException ex) {
//            Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void solidAC207Inventory(Document doc) {
//        ReadProcess rp = new ReadProcess();
//        iCount = 1;
//        try {
//            RESULT = rp.exportData("AC-207", "SOLID");
//            addHeader(doc, "Solid", "AC-207");
//        } catch (DocumentException ex) {
//            Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void solidAC107Inventory(Document doc) {
//        ReadProcess rp = new ReadProcess();
//        try {
//            RESULT = rp.exportData("AC-107", "SOLID");
//            addHeader(doc, "Solid", "AC-107");
//        } catch (DocumentException ex) {
//            Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private void addMetaData(Document document) {
        document.addTitle("Inventory Reports");
        document.addAuthor("Department of Pure and Applied Sciences");
    }

    private void addHeader(Document document, String chemicalType, String room) throws DocumentException {
        Paragraph vsu = new Paragraph("VISAYAS STATE UNIVERSITY", FONT_BOLD_11);
        Paragraph dopac = new Paragraph("DEPARTMENT OF PURE AND APPLIED CHEMISTRY", FONT_BOLD_11);
        Paragraph chemicalPara = new Paragraph("Inventory of: " + chemicalType + " Chemicals", FONT_BOLD_10);
        Paragraph roomPara = new Paragraph("Room #: " + room, FONT_BOLD_10);
        Paragraph datePara = new Paragraph("Date: " + DateFormat.getDateInstance().format(new java.util.Date()), FONT_BOLD_10);
        
        chemicalPara.setAlignment(Element.ALIGN_CENTER);

        vsu.setAlignment(Element.ALIGN_CENTER);
        dopac.setAlignment(Element.ALIGN_CENTER);
        datePara.setAlignment(Element.ALIGN_CENTER);
        roomPara.setAlignment(Element.ALIGN_CENTER);

        dopac.setSpacingAfter(20);
        datePara.setSpacingAfter(20);

        document.add(vsu);
        document.add(dopac);
        document.add(chemicalPara);
        document.add(roomPara);
        document.add(datePara);

        PdfPTable header;
        header = new PdfPTable(new float[]{6,9,20,11,6,7,13,12,8,8});
        PdfPCell cellHead = new PdfPHeaderCell();
        cellHead.setVerticalAlignment(Element.ALIGN_CENTER);

        PdfPCell cell = new PdfPCell(new Phrase("ID", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        //cell.set
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("CAS-RN", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("CONTAINER", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("SUPPLIER", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("QTY", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("SIZE", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("PURCHASED DATE", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("EXPIRED DATE", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("LOCATION", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        cell = new PdfPCell(new Phrase("TYPE", FONT_BOLD_10));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
        header.addCell(cell);

        header.setWidthPercentage(100);

        addTableContent(document, header);
    }

    private void addTableContent(Document document, PdfPTable table) throws DocumentException {
        try {
            while (RESULT.next()) {

                // entry no.
                PdfPCell cell = new PdfPCell(new Phrase(String.valueOf(iCount++), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
                table.addCell(cell);

                // cas rn column
                cell = new PdfPCell(new Phrase(" "+RESULT.getString(1), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                // container name
                cell = new PdfPCell(new Phrase(" "+RESULT.getString(2), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                // brand
                cell = new PdfPCell(new Phrase(" "+RESULT.getString(3), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                // qty
                cell = new PdfPCell(new Phrase(RESULT.getString(4), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_CENTER);
                table.addCell(cell);

                // SIZE
                cell = new PdfPCell(new Phrase(" "+RESULT.getString(5), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                // purchase date
                cell = new PdfPCell(new Phrase(" "+RESULT.getString(6), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                // expiry date
                cell = new PdfPCell(new Phrase(" "+RESULT.getString(7), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                // location
                cell = new PdfPCell(new Phrase(" "+RESULT.getString(8), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                // type
                cell = new PdfPCell(new Phrase(" "+RESULT.getString(9), FONT_NORMAL_10));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Phrase.ALIGN_LEFT);
                table.addCell(cell);

                //System.out.println(RESULT.getString(11));
            }
            document.add(table);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addFooter(Document document) throws DocumentException {
        Paragraph pSpace = new Paragraph("");
        Paragraph footer = new Paragraph("Prepared by: ", FONT_BOLD_10);
        Paragraph name = new Paragraph(Login.usersEntity.getFullname(), FONT_BOLD_10_UNDERLINE);
        Paragraph desc = new Paragraph(addSpace() + Login.usersEntity.getDesignation(), FONT_NORMAL_09_ITALIC);

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

    private String addSpace() {
        String space = "";

        int x = Login.usersEntity.getFullname().length() - Login.usersEntity.getDesignation().length();

        for (int i = 0; i < x/2; i++) {
            space += " ";
        }

        return space;
    }

}
