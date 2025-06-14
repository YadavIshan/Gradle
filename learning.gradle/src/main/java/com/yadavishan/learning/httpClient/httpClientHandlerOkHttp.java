package com.yadavishan.learning.httpClient;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class httpClientHandlerOkHttp implements CommandLineRunner {

    static final String URL = "https://jsonplaceholder.typicode.com/todos/1";
    @Override
    public void run(String... args) throws Exception {
        System.out.println("inside OkHttp... handler for client calls using OkHttp library.");
        //Setting up and using OkHttp to make a client network call
        OkHttpClient client = new OkHttpClient();

        //Building request
        Request request =  new Request.Builder().url(URL).build();

        //Making an HTPP client call
        try(Response response = client.newCall(request).execute()){
            if(response.isSuccessful()){
                System.out.println("Client call made successfully and response received!!" + response.toString());
            }else{
                System.out.println("Client call is not successfully");
            }
        }catch(Exception exception){
            //Will add logger later
            System.out.println("Exception occured while making a client call : {}"+ exception);
        }

    }
}
