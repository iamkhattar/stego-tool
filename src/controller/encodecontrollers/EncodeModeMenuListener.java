package controller.encodecontrollers;

import model.StegoModel;
import view.StegoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncodeModeMenuListener implements ActionListener {

    private StegoModel model;
    private StegoView view;

    public EncodeModeMenuListener(StegoModel model, StegoView view){
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
