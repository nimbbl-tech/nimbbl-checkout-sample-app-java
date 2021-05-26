package com.example.nimbbl.data.model.model.createoder;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CreateOrder_Model implements Serializable {
    @SerializedName("id")
    private String id;

    @SerializedName("jsonrpc")
    private String jsonrpc;

    @SerializedName("result")
    private Result result;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
