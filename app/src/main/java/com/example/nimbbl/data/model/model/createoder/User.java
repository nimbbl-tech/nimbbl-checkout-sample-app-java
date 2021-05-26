package com.example.nimbbl.data.model.model.createoder;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("active")
    private Boolean active;

    @SerializedName("email")
    private String email;

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("id")
    private int id;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("mobile_number")
    private String mobile_number;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("verification_done")
    private String verification_done;

    @SerializedName("verification_done_at")
    private String verification_done_at;

    @SerializedName("verification_token")
    private String verification_token;

    @SerializedName("verified_at")
    private String verified_at;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVerification_done() {
        return verification_done;
    }

    public void setVerification_done(String verification_done) {
        this.verification_done = verification_done;
    }

    public String getVerification_done_at() {
        return verification_done_at;
    }

    public void setVerification_done_at(String verification_done_at) {
        this.verification_done_at = verification_done_at;
    }

    public String getVerification_token() {
        return verification_token;
    }

    public void setVerification_token(String verification_token) {
        this.verification_token = verification_token;
    }

    public String getVerified_at() {
        return verified_at;
    }

    public void setVerified_at(String verified_at) {
        this.verified_at = verified_at;
    }
}
