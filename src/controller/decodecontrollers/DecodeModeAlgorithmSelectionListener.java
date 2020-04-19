package controller.decodecontrollers;

import model.StegoModel;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DecodeModeAlgorithmSelectionListener implements ItemListener {

    private StegoModel model;

    public DecodeModeAlgorithmSelectionListener(StegoModel model){
        this.model = model;
    }


    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        Object selectedItem = comboBox.getSelectedItem();
        model.setAlgorithmType((String)selectedItem);
        System.out.println(model.getAlgorithmType());
    }
}
