package com.yadavishan.learning.httpClient;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoService {
    @GET("/todos/{todoId}")
    public Call<Todo> getTodo(@Path("todoId") String todoId);
}
