package driver;

import model.StegoModel;
import view.StegoView;

public class Driver {

    public static void main(String args[]){
        StegoModel model = new StegoModel("LSB");
        StegoView view = new StegoView(model);
    }

}
