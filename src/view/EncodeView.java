package view;

import controller.encodecontrollers.*;
import model.StegoModel;

import javax.swing.*;
import java.awt.*;

public class EncodeView extends JPanel implements View {

    private StegoModel model;
    private StegoView view;

    /**
     * Encode View for StegoTool
     * @param model StegoTool model
     * @param view StegoTool view
     */
    public EncodeView(StegoModel model, StegoView view){
        this.model = model;
        this.view = view;
        this.buildPanel();
    }

    /**
     * builds Encode Panel
     */
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

    /**
     * builds left hand side panel for the encode view
     * @return JPanel left hand side panel for encode view
     */
    private JPanel getLeftPanel(){
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(3,1));
        JButton sourceButton = new JButton("Choose Source");
        sourceButton.addActionListener(new EncodeModeSourceButtonListener(model, this));
        JButton payloadButton = new JButton("Choose Payload");
        payloadButton.addActionListener(new EncodeModePayloadButtonListener(model, this));
        JButton destinationButton = new JButton("Choose Destination");
        destinationButton.addActionListener(new EncodeModeDestinationListener(model, this));
        leftPanel.add(sourceButton);
        leftPanel.add(payloadButton);
        leftPanel.add(destinationButton);
        return leftPanel;
    }

    /**
     * builds center panel for the encode view
     * @return JPanel center panel for encode view
     */
    private JPanel getCenterPanel(){
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1,1));
        String[] algorithmOptions = {"LSB","BPCS"};
        JComboBox algorithmBox = new JComboBox(algorithmOptions);
        algorithmBox.setSelectedIndex(0);
        algorithmBox.addItemListener(new EncodeModeAlgorithmSelectionListener(model));
        centerPanel.add(algorithmBox);
        return centerPanel;
    }

    /**
     * builds right hand side panel for encode view
     * @return JPanel right hand side panel for encode view
     */
    private JPanel getRightPanel(){
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(1,1));
        JButton goButton = new JButton("Go");
        rightPanel.add(goButton);
        goButton.addActionListener(new EncodeModeGoButtonListener(model));
        return rightPanel;
    }

    @Override
    public JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("Switch to Decode Mode");
        menu.add(menuItem);
        menuItem.addActionListener(new EncodeModeMenuListener(model,view));

        return menuBar;
    }
}
