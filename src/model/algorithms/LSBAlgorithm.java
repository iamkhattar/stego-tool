package model.algorithms;

public class LSBAlgorithm implements StegoStrategy {

    private final int HEADER_START = 0;
    private final int PAYLOAD_START = 54;

    private String coverPath;
    private String payloadPath;
    private String stegoPath;

    public LSBAlgorithm(String coverPath, String payloadPath, String stegoPath){
        this.coverPath= coverPath;
        this.payloadPath= payloadPath;
        this.stegoPath= stegoPath;
    }


    @Override
    public void encode() {

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
