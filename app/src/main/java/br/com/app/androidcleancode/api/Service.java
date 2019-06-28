package br.com.app.androidcleancode.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class Service {

    private static API INSTANCE;

    public static API api() {
        if (INSTANCE == null) {
            Retrofit build = new Retrofit.Builder()
                    .baseUrl("https://bank-app-test.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            INSTANCE = build.create(API.class);
        }
        return INSTANCE;
    }

    private Service() {}

    public interface API {

        @FormUrlEncoded
        @POST("/api/login")
        Call<LoginResponse> login(@Field("user") String user,
                                  @Field("password") String password);
    }
}
