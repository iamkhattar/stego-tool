package model.algorithms;

import model.utilities.Read;
import model.utilities.Write;

public class LSBAlgorithm implements StegoStrategy {

    private final int HEADER_START = 0;
    private final int PAYLOAD_START = 54;

    private String coverPath;
    private String payloadPath;
    private String stegoPath;

    /**
     * Constructor to initialise the LSB Algorithm Class
     * @param coverPath Path of Cover Image
     * @param payloadPath Path of Payload
     * @param stegoPath Path of Final Image
     */
    public LSBAlgorithm(String coverPath, String payloadPath, String stegoPath){
        this.coverPath= coverPath;
        this.payloadPath= payloadPath;
        this.stegoPath= stegoPath;
    }


    @Override
    public boolean encode() {

        Read read = new Read();
        Write write = new Write();

        byte[] coverBytes = read.readFile(coverPath);
        byte[] payloadBytes = read.readFile(payloadPath);
        byte[] stegoBytes = new byte[coverBytes.length];

        String payloadExtension = read.getFileExtension(payloadPath);

        if(!isImageSizeSufficient(coverBytes,payloadBytes)){
            return false;
        }

        byte[] payloadSizeArray = encodePayloadSize(payloadBytes);
        byte[] extensionNameArray = encodePayloadExtension(payloadExtension);

        //Copy the Header
        for(int i=HEADER_START; i<PAYLOAD_START; i++){
            stegoBytes[i]=coverBytes[i];
        }

        //Correct the Payload
        payloadBytes = correctPayload(payloadSizeArray,extensionNameArray,payloadBytes);

        int payloadIndexCounter = 0;
        int payloadBitCounter = 0;

        //Perform Left Significant Bit Algorithm Once payload has been fixed
        for(int i=PAYLOAD_START; i<coverBytes.length;i++){

            //Increment Index Counter
            if(payloadBitCounter == 8){
                payloadBitCounter=0;
                payloadIndexCounter++;
            }

            //Current Byte
            byte stegoByte = coverBytes[i];

            //Change LSB
            if(payloadIndexCounter<payloadBytes.length){
                byte payloadByte = payloadBytes[payloadIndexCounter];
                byte payloadBit = getBit(payloadByte, payloadBitCounter);
                stegoByte=setLSB(stegoByte,payloadBit);
                payloadBitCounter++;
            }

            //Copy encoded Bytes
            stegoBytes[i] = stegoByte;
        }

        write.write(stegoPath,stegoBytes);
        return true;
    }

    /**
     * getting a specific bit of a byte
     * @param b passing in a byte
     * @param position passing position we want to shift the byte
     * @return gets the bit at the desired position of a byte
     */
    private byte getBit(byte b, int position) {
        String str = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
        if(str.charAt(position)=='0'){
            return 0;
        }else{
            return 1;
        }
    }

    /**
     * Changing the last bit of a byte
     * @param b reading in a byte
     * @param lsb declaring what the last bit of the bit will be changed to
     * @return a new byte with a changed last significant bit
     */
    private byte setLSB(byte b, int lsb){
        if(lsb==0){
            return (byte) (b & ~ 0x1);
        }else{
            return (byte) (b | 0x1);
        }
    }

    /** getting the header information of a byte of the payload
     *
     * @param payload passing in the file to be hidden in an array of bytes
     * @return returns the information of the payload header
     */
    private byte[] encodePayloadSize(byte[] payload){
        byte[] headerInfo = new byte[4];
        int size = payload.length;
        headerInfo[0] = (byte)(size >>> 24);
        headerInfo[1] = (byte)(size >>> 16);
        headerInfo[2] = (byte)(size >>> 8);
        headerInfo[3] = (byte)size;
        return headerInfo;
    }

    /**
     * converts the payload extension into bytes
     * @param extensionName the payload extension type
     * @return the payload extension in bytes
     */
    private byte[] encodePayloadExtension(String extensionName){
        byte[] b = new byte[8];
        for(int i=0;i<b.length;i++) {
            if(i<extensionName.length()) {
                b[i] = (byte)extensionName.charAt(i);
            }else {
                b[i] = 0;
            }

        }
        return b;
    }

    /**
     * adds the size of the payloadSize and the extension type into the new payload
     * @param payloadSizeArray the payload size in bytes
     * @param payloadExtensionArray the payload extension in bytes
     * @param payload the payload in bytes
     * @return returns the new payload
     */
    private byte[] correctPayload(byte[] payloadSizeArray, byte[] payloadExtensionArray, byte[] payload){
        byte[] newpayload = new byte[payload.length+12];
        for(int i=0;i<4;i++){
            newpayload[i]=payloadSizeArray[i];
        }
        for(int i=0;i<8;i++){
            newpayload[i+4]=payloadExtensionArray[i];
        }
        for(int i=0;i<payload.length;i++){
            newpayload[i+12]=payload[i];
        }
        return newpayload;
    }


    @Override
    public void decode() {

    }

    @Override
    public boolean isImageSizeSufficient(byte[] cover, byte[] payload){
        int payloadSize = payload.length;
        int coverSize = cover.length;
        return ((payloadSize*8)<(coverSize-150));
    }


}
