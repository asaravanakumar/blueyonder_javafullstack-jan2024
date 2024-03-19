package com.examples.sboot.cassandra.model;

//import jakarta.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class ResponseMessage {
    private String status;
    private String message;

    public ResponseMessage() {

    }

    public ResponseMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
