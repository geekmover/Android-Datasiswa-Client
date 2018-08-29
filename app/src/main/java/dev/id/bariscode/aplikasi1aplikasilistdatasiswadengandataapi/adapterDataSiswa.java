package dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.respones.ListDatasiswaItem;

public class adapterDataSiswa extends RecyclerView.Adapter<adapterDataSiswa.MyViewHolder>{

    Context ctx;
    List<ListDatasiswaItem> lst_datasiswa;

    public adapterDataSiswa(Context ctx, List<ListDatasiswaItem> lst_datasiswa) {
        this.ctx = ctx;
        this.lst_datasiswa = lst_datasiswa;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_datasiswa, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.txNamaSiswa.setText(lst_datasiswa.get(position).getNamaSiswa());
        holder.txKelasSiswa.setText(lst_datasiswa.get(position).getKelasAngkatan());
        holder.txJurusanSiswa.setText(lst_datasiswa.get(position).getJurusan());
        holder.txTanggalTambahSiswa.setText("●  " + lst_datasiswa.get(position).getTanggalTambah());

        final String urlPhotoSiswa = "http://bariscodeid.000webhostapp.com/portal_educate/photos/" + lst_datasiswa.get(position).getPhoto();

        Picasso.with(ctx).load(urlPhotoSiswa).into(holder.photoSiswa);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,
                        "Nama Lengkap " + lst_datasiswa.get(position).getNamaSiswa() +
                              " Kelas " + lst_datasiswa.get(position).getKelasAngkatan() +
                              " Jurusan " + lst_datasiswa.get(position).getJurusan() +
                              " Kelas " + lst_datasiswa.get(position).getTanggalTambah() +
                              " Photo " +  lst_datasiswa.get(position).getPhoto()
                        , Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return lst_datasiswa.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView photoSiswa;
        TextView txNamaSiswa, txKelasSiswa, txJurusanSiswa, txTanggalTambahSiswa;

        public MyViewHolder(View itemView) {
            super(itemView);
            photoSiswa = (ImageView)itemView.findViewById(R.id.ivPhotoSiswa);
            txNamaSiswa = (TextView)itemView.findViewById(R.id.tvNamaSiswa);
            txKelasSiswa = (TextView)itemView.findViewById(R.id.tvSiswaKelas);
            txJurusanSiswa = (TextView)itemView.findViewById(R.id.tvSiswaJurusan);
            txTanggalTambahSiswa = (TextView)itemView.findViewById(R.id.tvTglTambahSiswa);
        }
    }
}
