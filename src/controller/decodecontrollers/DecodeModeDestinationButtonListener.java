package controller.decodecontrollers;

import model.StegoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DecodeModeDestinationButtonListener implements ActionListener {

    private StegoModel model;
    private JPanel panel;

    public DecodeModeDestinationButtonListener(StegoModel model, JPanel panel){
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
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }

    }
}
