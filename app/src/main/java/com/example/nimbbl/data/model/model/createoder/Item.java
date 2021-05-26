package com.example.nimbbl.data.model.model.createoder;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable {

    @SerializedName("address")
    private Address address;

    @SerializedName("amount_before_tax")
    private int amount_before_tax;

    @SerializedName("attempts")
    private int attempts;

    @SerializedName("callback_mode")
    private String callback_mode;

    @SerializedName("callback_url")
    private String callback_url;

    @SerializedName("cancellation_reason")
    private String cancellation_reason;

    @SerializedName("currency")
    private String currency;

    @SerializedName("custom_attributes")
    private String custom_attributes;

    @SerializedName("description")
    private String description;

    @SerializedName("device_user_agent")
    private String device_user_agent;

    @SerializedName("invoice_id")
    private String invoice_id;

    @SerializedName("merchant_shopfront_domain")
    private String merchant_shopfront_domain;

    @SerializedName("order_date")
    private String order_date;

    @SerializedName("order_from_ip")
    private String order_from_ip;

    @SerializedName("order_id")
    private String order_id;

    @SerializedName("order_line_item")
    private List<String> order_line_item;

    @SerializedName("order_metadata")
    private String order_metadata;

    @SerializedName("partner_id")
    private String partner_id;

    @SerializedName("referrer_platform")
    private String referrer_platform;

    @SerializedName("status")
    private String status;

    @SerializedName("sub_merchant_id")
    private int sub_merchant_id;

    @SerializedName("tax")
    private int tax;

    @SerializedName("total_amount")
    private int total_amount;

    @SerializedName("user")
    private User user;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAmount_before_tax() {
        return amount_before_tax;
    }

    public void setAmount_before_tax(int amount_before_tax) {
        this.amount_before_tax = amount_before_tax;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getCallback_mode() {
        return callback_mode;
    }

    public void setCallback_mode(String callback_mode) {
        this.callback_mode = callback_mode;
    }

    public String getCallback_url() {
        return callback_url;
    }

    public void setCallback_url(String callback_url) {
        this.callback_url = callback_url;
    }

    public String getCancellation_reason() {
        return cancellation_reason;
    }

    public void setCancellation_reason(String cancellation_reason) {
        this.cancellation_reason = cancellation_reason;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCustom_attributes() {
        return custom_attributes;
    }

    public void setCustom_attributes(String custom_attributes) {
        this.custom_attributes = custom_attributes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDevice_user_agent() {
        return device_user_agent;
    }

    public void setDevice_user_agent(String device_user_agent) {
        this.device_user_agent = device_user_agent;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getMerchant_shopfront_domain() {
        return merchant_shopfront_domain;
    }

    public void setMerchant_shopfront_domain(String merchant_shopfront_domain) {
        this.merchant_shopfront_domain = merchant_shopfront_domain;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_from_ip() {
        return order_from_ip;
    }

    public void setOrder_from_ip(String order_from_ip) {
        this.order_from_ip = order_from_ip;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public List<String> getOrder_line_item() {
        return order_line_item;
    }

    public void setOrder_line_item(List<String> order_line_item) {
        this.order_line_item = order_line_item;
    }

    public String getOrder_metadata() {
        return order_metadata;
    }

    public void setOrder_metadata(String order_metadata) {
        this.order_metadata = order_metadata;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    public String getReferrer_platform() {
        return referrer_platform;
    }

    public void setReferrer_platform(String referrer_platform) {
        this.referrer_platform = referrer_platform;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSub_merchant_id() {
        return sub_merchant_id;
    }

    public void setSub_merchant_id(int sub_merchant_id) {
        this.sub_merchant_id = sub_merchant_id;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
