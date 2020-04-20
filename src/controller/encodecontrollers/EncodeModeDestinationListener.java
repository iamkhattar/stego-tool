package controller.encodecontrollers;

import model.StegoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EncodeModeDestinationListener implements ActionListener {
    private StegoModel model;
    private JPanel panel;

    public EncodeModeDestinationListener(StegoModel model, JPanel panel){
        this.model = model;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(panel);
            File file = chooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            model.setDestination(filePath);
            System.out.println(model.getDestination());
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
