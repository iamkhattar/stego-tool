package controller.decodecontrollers;

import model.StegoModel;
import view.StegoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecodeModeMenuListener implements ActionListener {
    private StegoModel model;
    private StegoView view;

    public DecodeModeMenuListener(StegoModel model, StegoView view){
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Switch to Encode Mode"){
            view.setFrameToEncodeView();
        }
    }
}
