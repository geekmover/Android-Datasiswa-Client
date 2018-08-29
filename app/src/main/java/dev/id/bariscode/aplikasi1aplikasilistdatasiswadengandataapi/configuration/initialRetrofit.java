package dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.configuration;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class initialRetrofit {

    public static String API_URL = "http://bariscodeid.000webhostapp.com/portal_educate/";

    public static Retrofit setInit() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static apiServices getInstance() {
        return setInit().create(apiServices.class);
    }
}
