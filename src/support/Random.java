/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Nas
 */
public class Random {    
    public static String getFuckingRandomString(){
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String s = "";
        for(int i=0; i<12; i++){
            int rand = (int) ((Math.random() * 1000) % str1.length());
            s += String.valueOf(str1.charAt(rand));
        }
        return s;
    }
    
    public static String getCurrentDateTime() {
        String date[] = DateFormat.getDateInstance(3).format(new java.util.Date()).split("/");
        String time[] = DateFormat.getTimeInstance(2).format(new java.util.Date()).split(":");

        String month = date[0].length() == 1 ? "0" + date[0] : date[0];
        String day = date[1].length() == 1 ? "0" + date[1] : date[1];
        int year = 2000 + Integer.valueOf(date[2]);

        time[0] = time[2].contains("PM") ? ("0" + time[0]) : (12 + Integer.valueOf(time[0])) + "";
        time[2] = time[2].substring(0, 2);

        return year + "-" + month + "-" + day + " " + time[0] + ":" + time[1] + ":" + time[2];
    }
    
    public static void openFilePdf(String path){
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(path);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Please make sure you have a pdf reader in your system!", "Error message!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        File myFile = new File("C:/Users/jonsa/Documents/Inventory Reports/Chemicals/2018/April/IReport_dedDflcdjAxs20180422041600.pdf");
        //myFile.renameTo(new File("D:/file.pdf"));
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        File localFIle = new File(System.getProperty("user.dir") + "\\pdfs\\gdfgdfg.pdf");
        
        FileUtils.copyFile(myFile, localFIle);
        
        
        File file = new File(System.getProperty("user.dir") + "\\pdfs\\");
                file.mkdirs();
                
                System.out.println(file.getAbsolutePath());
    }
}
