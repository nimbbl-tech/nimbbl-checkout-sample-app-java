package com.example.nimbbl.data.model.network;

import com.example.nimbbl.data.model.model.createoder.CreateOrder_Model;
import com.example.nimbbl.data.model.model.postbody.Catlogbody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiCallJava {


    @POST
    Call<CreateOrder_Model> createOrder(@Url String url, @Body Catlogbody productId);
}
