package model.algorithms;

public class BPCSAlgorithm implements StegoStrategy {


    @Override
    public boolean encode() {
        return false;
    }

    @Override
    public void decode() {

    }

    @Override
    public boolean isImageSizeSufficient(byte[] cover, byte[] payload) {
        return false;
    }

}
