package model.utilities;

import java.io.*;

public class Read {


    /** read a file and puts it into an array of bytes
     *
     * @param path path of the file being read
     * @return returns the file in bytes
     */
    public byte[] read(String path){
        File file = new File(path);
        byte[] b = new byte[(int)file.length()];

        try{
            InputStream fs = new FileInputStream(file);
            fs.read(b);
        }
        //Exception handling
        catch(FileNotFoundException e){
            System.out.println("Read FileNotFound: ");
            e.printStackTrace();
        }
        catch(IOException e){
            System.out.println("Read IOException: ");
            e.printStackTrace();
        }

        return b;
    }

    /** Gets the extension of a file
     *
     * @param path the path of the file being read
     * @return returns the extension name of the file being read
     */
    public String getFileExtension(String path){
        String extensionName ="";
        extensionName = new File(path).getName();
        extensionName = extensionName.substring(extensionName.lastIndexOf(".") + 1);
        return extensionName;
    }

    /** Checks if the file being read exists
     *
     * @param path the path of the being read
     * @return returns if the file exists or not
     */
    public boolean doesFileExist(String path){
        return new File(path).exists();
    }

    /** Converting array of Bytes to an array of Binary Strings
     *
     * @param byt gets the array of bytes that are being converted
     * @return returns the bytes in binary string form
     */
    public String[] convertByteToBinaryString(byte[] byt){
        String[] binaryString =  new String[byt.length];
        for(int i =0; i<byt.length; i++){
            byte currByt = byt[i];
            // ensures that no trailing bits are lost
            binaryString[i] = String.format("%8s", Integer.toBinaryString(currByt & 0xFF)).replace(' ', '0');
        }
        return binaryString;
    }

    /** converting array of Binary Strings to an array Bytes
     *
     * @param binString the array of binary strings that are being converted into bytes
     * @return returns an array of binary strings
     */
    public byte[] convertBinaryStringToByte(String[] binString){
        byte[] bytArr = new byte[binString.length];
        for(int i =0; i< binString.length; i++){
            bytArr[i] = (byte) Integer.parseInt(binString[i], 2);
        }
        return bytArr;
    }

    /** Checks to see if a file is a bmp file
     *
     * @param extension the file extension being checked
     * @return returns if the file is a bmp file or not
     */
    public boolean isFileBmp(String extension){
        return getFileExtension(extension).equals("bmp");
    }

}
