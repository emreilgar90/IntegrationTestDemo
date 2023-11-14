package com.emreilgar.integrationtest.controller;

import okhttp3.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CustomerControllerTest {


    @Test
    void findAllTest() throws IOException {
        OkHttpClient client= new OkHttpClient().newBuilder().build();
        Request request= new Request.Builder()
                .addHeader("Content-Type","application/json")
                .url("http://localhost:9090/customer/getall")
                .method("GET",null)
                .build();
               Response response= client.newCall(request).execute();
        System.out.println(response.body().string());
    }
    @Test
    void saveTest() throws IOException {
        OkHttpClient client= new OkHttpClient().newBuilder().build();
        MediaType mediaType= MediaType.parse("applicatiom/json");
        RequestBody requestBody = RequestBody.create(mediaType, "{\n" +
                        "  \"name\": \"Emre\",\n" +
                        "  \"address\": \"İstanbul\",\n" +
                        "  \"telephone\": \"0536 500 00 00\"\n" +
                        "}");
        /**Yukarıda veriyi yolladık aşağıda test ediyoruz.**/
        Request request= new Request.Builder()
                .addHeader("Content-Type","application/json")
                .url("http://localhost:9090/customer/save")
                .method("POST",requestBody)
                .build();
        Response response= client.newCall(request).execute();
        System.out.println(response.body().string());

    }
}
