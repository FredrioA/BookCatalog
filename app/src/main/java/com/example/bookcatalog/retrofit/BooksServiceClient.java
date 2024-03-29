package com.example.bookcatalog.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.bookcatalog.utils.AppConstants.BASE_URL;

public class BooksServiceClient {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


    public static IBookService getBookService(){
        return getRetrofitInstance().create(IBookService.class);
    }


}
