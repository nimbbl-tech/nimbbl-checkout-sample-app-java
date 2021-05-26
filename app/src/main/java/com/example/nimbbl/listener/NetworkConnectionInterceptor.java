package com.example.nimbbl.listener;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public abstract class NetworkConnectionInterceptor implements Interceptor {

    public abstract boolean isInternetAvailable();

    public abstract void onInternetUnavailable(String errorMsg);

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!isInternetAvailable()) {
            onInternetUnavailable("Oops!! It looks like you are not connected with internet, please check your internet connection and try again.");
        }

        try {
            return chain.proceed(chain.request());
        } catch (SocketTimeoutException | UnknownHostException | ConnectException e) {
            if (e instanceof SocketTimeoutException)
                onInternetUnavailable("Request time out, please retry your request.");

            else if (e instanceof UnknownHostException)
                onInternetUnavailable("The connection to the server was unsuccessful. Please retry your request.");

            else
                onInternetUnavailable("Oops!! It looks like you are not connected with internet, please check your internet connection and try again.");
        }

        return chain.proceed(request);
    }
}