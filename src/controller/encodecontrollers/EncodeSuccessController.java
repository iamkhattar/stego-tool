package controller.encodecontrollers;

import javax.swing.*;

public class EncodeSuccessController {
    private String message;

    public EncodeSuccessController(String message){
        this.message = message;
        this.createSuccessDialog();
    }

    private void createSuccessDialog(){
        JOptionPane.showMessageDialog(new JFrame(), message, "Encode Successful!",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
