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
public class SolidComboBoxModel extends AbstractListModel<Object> implements ComboBoxModel<Object>{

    private final String[] unit;
    private String selection;

    public SolidComboBoxModel() {
        unit = new String[]{"mg","g","kg"};
    }
    
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
