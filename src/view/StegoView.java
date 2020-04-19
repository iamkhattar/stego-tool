package view;

import model.StegoModel;

import javax.swing.*;
import java.awt.*;

public class StegoView extends JFrame {

    private StegoModel model;
    private View currentMode;

    /**
     * Main View Class for StegoTool
     * @param model StegoTool model
     */
    public StegoView(StegoModel model){
        this.model = model;
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        currentMode = new DecodeView(model,this);
        setFrameToEncodeView();
    }

    /**
     * sets current View to Decode View
     */
    public void setFrameToDecodeView(){
        this.remove((Component)currentMode);
        currentMode = new DecodeView(model,this);
        this.setTitle("StegoTool - Decode Mode");
        this.add((Component)currentMode,BorderLayout.CENTER);
        this.setJMenuBar(currentMode.getMenuBar());
        pack();
    }

    /**
     * sets current View to Encode View
     */
    public void setFrameToEncodeView(){
        this.remove((Component)currentMode);
        currentMode = new EncodeView(model,this);
        this.setTitle("StegoTool - Encode Mode");
        this.add((Component)currentMode,BorderLayout.CENTER);
        this.setJMenuBar(currentMode.getMenuBar());
        pack();
    }

}
