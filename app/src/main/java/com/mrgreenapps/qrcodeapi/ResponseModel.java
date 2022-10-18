package com.mrgreenapps.qrcodeapi;

public class ResponseModel {
    private String input;
    private String response;

    public ResponseModel(String input, String response) {
        this.input = input;
        this.response = response;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
