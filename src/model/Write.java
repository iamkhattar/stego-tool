package model;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Write {

    /** storing the new image in a new file
     *
     * @param path the file path for new image
     */
    public void write(String path, byte[] stegoImage){
        File f;
        try{
            f = new File(path);
            OutputStream os = new FileOutputStream(f);
            os.write(stegoImage);
        }catch(IOException e){
            System.out.println("Error making new image :" +e);
        }
    }

}