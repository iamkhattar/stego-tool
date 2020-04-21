package model;

import controller.encodecontrollers.EncodeErrorController;
import model.algorithms.BPCSAlgorithm;
import model.algorithms.LSBAlgorithm;
import model.algorithms.StegoStrategy;

public class StegoModel {

    private String algorithmType;
    private StegoStrategy strategy;

    private String source;
    private String destination;
    private String payload;

    public StegoModel(String algorithmType){
        this.algorithmType = algorithmType;
        this.source="";
        this.destination="";
        this.payload="";
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setStrategy(){
        if(algorithmType.equals("LSB")){
            strategy = new LSBAlgorithm(source,payload,destination);
        }else{
            strategy = new BPCSAlgorithm();
        }
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

    public String getPayload() {
        return payload;
    }

    public void setPayload(String cover) {
        this.payload = cover;
    }

    public boolean encode(){
        setStrategy();
        return strategy.encode();

    }

    public void decode(){
        strategy.decode();
    }

}
