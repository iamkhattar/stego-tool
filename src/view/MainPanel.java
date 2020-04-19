package view;

import model.StegoModel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private StegoModel model;

    public MainPanel(StegoModel model){
        this.model = model;
        buildPanel();
    }

    private void buildPanel(){
        JPanel mainPanel = new JPanel();
        GridLayout mainPanelLayout = new GridLayout(1,3);
        mainPanel.setLayout(mainPanelLayout);
        JPanel leftPanel = getLeftPanel();
        JPanel centerPanel = getCenterPanel();
        JPanel rightPanel = getRightPanel();
        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);
        this.add(mainPanel);
    }

    private JPanel getLeftPanel(){
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(2,1));
        JButton sourceButton = new JButton("Choose Source");
        JButton destinationButton = new JButton("Choose Destination");
        leftPanel.add(sourceButton);
        leftPanel.add(destinationButton);
        return leftPanel;
    }

    private JPanel getCenterPanel(){
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2,1));

        String[] algorithmOptions = {"LSB","BPCS"};
        JComboBox algorithmBox = new JComboBox(algorithmOptions);
        algorithmBox.setSelectedIndex(0);
        centerPanel.add(algorithmBox);

        String[] saveOptions = {"Encode","Decode"};
        JComboBox saveBox = new JComboBox(saveOptions);
        saveBox.setSelectedIndex(0);
        centerPanel.add(saveBox);

        return centerPanel;
    }

    private JPanel getRightPanel(){
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(1,1));
        JButton goButton = new JButton("Go");
        rightPanel.add(goButton);
        return rightPanel;
    }
}
