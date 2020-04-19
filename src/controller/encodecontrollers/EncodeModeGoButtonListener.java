package controller.encodecontrollers;

import model.StegoModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncodeModeGoButtonListener implements ActionListener {
    private StegoModel model;

    public EncodeModeGoButtonListener(StegoModel model){
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Go Pressed");
    }
}
