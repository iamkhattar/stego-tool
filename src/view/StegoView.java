package view;

import model.StegoModel;

import javax.swing.*;
import java.awt.*;

public class StegoView extends JFrame {

    private StegoModel model;

    public StegoView(StegoModel model){
        this.model = model;
        initialzeView();
    }

    private void initialzeView(){
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("StegoTool");
        this.setLayout(new BorderLayout());
        MainPanel panel = new MainPanel(model);
        this.add(panel,BorderLayout.CENTER);
        pack();
    }

}
