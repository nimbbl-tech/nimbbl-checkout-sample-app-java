package com.example.nimbbl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;

import androidx.multidex.MultiDexApplication;

import com.example.nimbbl.data.model.network.ApiCallJava;
import com.example.nimbbl.listener.InternetConnectionListener;
import com.example.nimbbl.listener.NetworkConnectionInterceptor;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Nimbbl extends MultiDexApplication {

    private static Nimbbl mInstance;

    private ApiCallJava apiService;
    private InternetConnectionListener mInternetConnectionListener;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private String baseUrl = "https://shop.nimbbl.tech/api/";


    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        mInstance = this;
    }


    public static synchronized Nimbbl getInstance() {
        return mInstance;
    }


    public void setInternetConnectionListener(InternetConnectionListener listener) {
        mInternetConnectionListener = listener;
    }


    public void removeInternetConnectionListener() {
        mInternetConnectionListener = null;
    }


    public ApiCallJava getApiService() {
        if (apiService == null) {
            apiService = provideRetrofit(baseUrl).create(ApiCallJava.class);
        }
        return apiService;
    }


    private Retrofit provideRetrofit(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(provideOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }


    private OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
        okhttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.readTimeout(30, TimeUnit.SECONDS);
        okhttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);

        okhttpClientBuilder.addInterceptor(loggingInterceptor);

        okhttpClientBuilder.addInterceptor(new NetworkConnectionInterceptor() {
            @Override
            public boolean isInternetAvailable() {
                return Nimbbl.this.isNetworkAvailable();
            }

            @Override
            public void onInternetUnavailable(String errorMsg) {
                if (mInternetConnectionListener != null) {
                    mInternetConnectionListener.onConnectionError(errorMsg);
                }
            }
        });

        return okhttpClientBuilder.build();
    }


    /**
     * Used to check is network is available or not.
     * @return
     */
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
