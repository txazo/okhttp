package org.txazo.okhttp3.test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpTest {

    public static void main(String[] args) throws Exception {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();
        Response response = httpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }

}
