package dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.configuration.initialRetrofit;

import dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.configuration.apiServices;
import dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.respones.ListDatasiswaItem;
import dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.respones.ResponseDataSiswa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class homeActivity extends AppCompatActivity {

    private RecyclerView rvLoadDataSiswa;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvLoadDataSiswa = (RecyclerView)findViewById(R.id.rvListDataSiswa);
        rvLoadDataSiswa.setHasFixedSize(true);
        rvLoadDataSiswa.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        tampildataSiswa();

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.srlRefreshData);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });
    }

    private void refreshContent() {
        apiServices api = initialRetrofit.getInstance();
        Call<ResponseDataSiswa> beritaCall = api.request_dtsiswa();

        beritaCall.enqueue(new Callback<ResponseDataSiswa>() {
            @Override
            public void onResponse(Call<ResponseDataSiswa> call, Response<ResponseDataSiswa> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<ListDatasiswaItem> data_berita = response.body().getListDatasiswa();
                    boolean status = response.body().isStatus();
                    if (status){
                        adapterDataSiswa adapter = new adapterDataSiswa(homeActivity.this, data_berita);
                        rvLoadDataSiswa.setAdapter(adapter);
                        swipeRefreshLayout.setRefreshing(false);
                    } else {
                        Toast.makeText(homeActivity.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDataSiswa> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void tampildataSiswa() {
        apiServices apiServices = initialRetrofit.getInstance();
        Call<ResponseDataSiswa> callDataSiswa = apiServices.request_dtsiswa();

        callDataSiswa.enqueue(new Callback<ResponseDataSiswa>() {
            @Override
            public void onResponse(Call<ResponseDataSiswa> call, Response<ResponseDataSiswa> response) {
                if (response.isSuccessful()){
                    Log.d("response api", response.body().toString());
                    List<ListDatasiswaItem> data_berita = response.body().getListDatasiswa();
                    boolean status = response.body().isStatus();
                    if (status){
                        adapterDataSiswa adapter = new adapterDataSiswa(homeActivity.this, data_berita);
                        rvLoadDataSiswa.setAdapter(adapter);
                    } else {
                        Toast.makeText(homeActivity.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseDataSiswa> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
