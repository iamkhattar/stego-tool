package controller.encodecontrollers;

import model.StegoModel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EncodeModeAlgorithmSelectionListener implements ItemListener {

    private StegoModel model;

    public EncodeModeAlgorithmSelectionListener(StegoModel model){
        this.model = model;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        Object selectedItem = comboBox.getSelectedItem();
        System.out.println(selectedItem);
    }
}
