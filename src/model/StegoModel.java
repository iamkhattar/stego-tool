package model;

public class StegoModel {

    private String algorithmType;

    private String source;
    private String destination;
    private String cover;

    public StegoModel(String algorithmType){
        this.algorithmType = algorithmType;
        this.source="";
        this.destination="";
        this.cover="";
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

}
