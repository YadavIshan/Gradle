// File: src/main/java/com/yadavishan/learning/httpClient/httpClientHandlerRetroFit.java
package com.yadavishan.learning.httpClient;

import okhttp3.OkHttpClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class httpClientHandlerRetroFit implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inside Retrofit... handler for client calls using Retrofit library.");

        // Setting up and using Retrofit to make a client network call
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        // Service setup
        TodoService service = retrofit.create(TodoService.class);

        // Synchronous call
        Call<Todo> callSync = service.getTodo("1");
        Response<Todo> response = callSync.execute();
        if (response.isSuccessful()) {
            Todo todo = response.body();
            System.out.println("Client call made successfully and response received!! " + todo);
        } else {
            System.out.println("Client call is not successful, response code: " + response.code());
        }

        // Asynchronous call
        System.out.println("Making asynchronous and non-blocking client call using Retrofit...");
        Call<Todo> callAsync = service.getTodo("1"); // Create a new Call object
        callAsync.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.isSuccessful()) {
                    Todo todo = response.body();
                    System.out.println("Asynchronous client call made successfully and response received!! " + todo);
                } else {
                    System.out.println("Asynchronous client call is not successful, response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable throwable) {
                System.out.println("Asynchronous client call failed with error: " + throwable.getMessage());
            }
        });
    }
}