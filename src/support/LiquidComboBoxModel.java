/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author jonsa
 */
public class LiquidComboBoxModel extends AbstractListModel<Object> implements ComboBoxModel<Object>{

    private final String[] unit = new String[]{"mL","L","Gal"};
    private String selection;
    
    @Override
    public int getSize() {
        return unit.length;
    }

    @Override
    public Object getElementAt(int index) {
        return unit[index];
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }    
}
