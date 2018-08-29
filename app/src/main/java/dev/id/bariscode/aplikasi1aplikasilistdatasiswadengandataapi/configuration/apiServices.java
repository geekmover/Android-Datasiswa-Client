package dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.configuration;

import dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.respones.ResponseDataSiswa;
import retrofit2.Call;
import retrofit2.http.GET;

public interface apiServices {
    @GET("tampilkan_datasiswa.php")
    Call<ResponseDataSiswa> request_dtsiswa();
}
