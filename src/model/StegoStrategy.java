package model;

public interface StegoStrategy {

    public void encode();
    public void decode();
    public boolean isImageSizeSufficient(byte[] cover, byte[] payload);

}
