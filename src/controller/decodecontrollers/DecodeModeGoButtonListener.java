package controller.decodecontrollers;

import controller.encodecontrollers.EncodeErrorController;
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
        String source = model.getSource();
        String destination = model.getPayload();

        if(source.equals("")){
            new EncodeErrorController("No Source File Selected");
        }else if(destination.equals("")) {
            new EncodeErrorController("No Payload File Selected");
        }

        model.decode();
    }
}
