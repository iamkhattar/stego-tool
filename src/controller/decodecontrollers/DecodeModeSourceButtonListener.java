package controller.decodecontrollers;

import model.StegoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DecodeModeSourceButtonListener implements ActionListener {

    private StegoModel model;
    private JPanel panel;

    public DecodeModeSourceButtonListener(StegoModel model, JPanel panel){
        this.model = model;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(panel);
            File file = chooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            model.setSource(filePath);
            System.out.println(model.getSource());
        }catch (NullPointerException exception){
            exception.printStackTrace();
        }

    }
}
