package model;

public interface StegoStrategy {

    /**
     * Allows users to encode using selected algorithm
      */
    public void encode();

    /**
     * Allows users to decode using selected algorithm
     */
    public void decode();

    /**
     * Checks whether the size of the cover is sufficient
     * @param cover Cover Image in bytes
     * @param payload payload in bytes
     * @return true/false
     */
    public boolean isImageSizeSufficient(byte[] cover, byte[] payload);

}
