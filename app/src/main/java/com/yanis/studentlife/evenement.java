package com.yanis.studentlife;

public class evenement {
    private int evenementID;
    private String evenementName;
    private String evenementAddress;
    private String evenementDate;
    private String evenementNumber;

    public evenement() {
    }

    public evenement(int evenementID, String evenementName, String evenementAddress, String evenementDate, String evenementNumber) {
        this.evenementID = evenementID;
        this.evenementName = evenementName;
        this.evenementAddress = evenementAddress;
        this.evenementDate = evenementDate;
        this.evenementNumber = evenementNumber;
    }

    public int getEvenementID() {
        return evenementID;
    }

    public void setEvenementID(int evenementID) {
        this.evenementID = evenementID;
    }

    public String getEvenementName() {
        return evenementName;
    }

    public void setEvenementName(String evenementName) {
        this.evenementName = evenementName;
    }

    public String getEvenementAddress() {
        return evenementAddress;
    }

    public void setEvenementAddress(String evenementAddress) {
        this.evenementAddress = evenementAddress;
    }

    public String getEvenementDate() {
        return evenementDate;
    }

    public void setEvenementDate(String evenementDate) {
        this.evenementDate = evenementDate;
    }

    public String getEvenementNumber() {
        return evenementNumber;
    }

    public void setEvenementNumber(String evenementNumber) {
        this.evenementNumber = evenementNumber;
    }
}
