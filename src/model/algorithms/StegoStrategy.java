package model.algorithms;

public interface StegoStrategy {

    /**
     * Allows users to decode using selected algorithm
     * @return true/false whether encoding is possible or not
     */
    public boolean encode();

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
