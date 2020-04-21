package controller.decodecontrollers;

import model.StegoModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecodeModeGoButtonListener implements ActionListener {

    private StegoModel model;

    public DecodeModeGoButtonListener(StegoModel model){
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.decode();
    }
}
