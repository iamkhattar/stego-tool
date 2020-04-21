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
        //Check for Errors
        String source = model.getSource();
        String payload = model.getPayload();
        String destination = model.getPayload();

        if(source.equals("")){
            new EncodeErrorController("No Source File Selected");
        }else if(payload.equals("")){
            new EncodeErrorController("No Payload File Selected");
        }else if(destination.equals("")){
            new EncodeErrorController("No Destination File Selected");
        }else{
            if(model.encode()){
                new EncodeSuccessController("Payload was hidden successfully");
            }else{
                new EncodeErrorController("Cover Image size is insufficient");
            }
        }


    }
}
