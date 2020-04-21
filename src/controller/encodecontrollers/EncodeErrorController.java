package controller.encodecontrollers;

import javax.swing.*;

public class EncodeErrorController {

    private String message;

    public EncodeErrorController(String message){
        this.message = message;
        this.createError();
    }

    private void createError(){
        JOptionPane.showMessageDialog(new JFrame(), message, "Encode Error!",
                JOptionPane.ERROR_MESSAGE);
    }
}
