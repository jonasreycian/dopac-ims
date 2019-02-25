/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Nas
 */
public class TableProperties {
    
    private javax.swing.JTable table;
    public TableProperties(javax.swing.JTable t) {
        super();
        table = t;
    }
    
    public void centerAlignHeader(){
        javax.swing.table.JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new HeaderRenderer(table));
    }
    
    public void centerAlignColumn(int columnIndex){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        
        table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
    }
}
