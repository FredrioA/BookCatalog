package com.example.bookcatalog.retrofit;

import com.example.bookcatalog.models.BookModel;
import com.example.bookcatalog.models.BookShelfModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface IBookService {

    @GET("v1/volumes")
    Call<BookShelfModel> getAllBooks(
            @Query("q") String search,
            @Query("startIndex") int startIndex,
            @Query("maxResults") int maxResults
    );
    
    @GET
    Call<BookModel> getBookByID(@Url String url);
}
