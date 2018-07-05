package org.txazo.okhttp3.test;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OkHttpTest {

    public static void main(String[] args) throws Exception {
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .dispatcher(new Dispatcher(Executors.newFixedThreadPool(20)))
                .build();
        httpClient.dispatcher().setMaxRequests(100);
        httpClient.dispatcher().setMaxRequestsPerHost(20);

        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        httpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }

        });
        System.in.read();
    }

}
