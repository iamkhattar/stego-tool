package model.algorithms;

import model.utilities.Read;

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
    public void encode() {
        byte[] coverBytes = new Read().readFile(coverPath);
        byte[] payloadBytes = new Read().readFile(payloadPath);
        if(isImageSizeSufficient(coverBytes,payloadBytes)){
            System.out.println("We can encode");
        }else{
            System.out.println("We cant encode");
        }
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
