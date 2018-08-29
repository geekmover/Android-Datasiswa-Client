package dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.respones;

import com.google.gson.annotations.SerializedName;

public class ListDatasiswaItem{

	@SerializedName("nama_siswa")
	private String namaSiswa;

	@SerializedName("kelas_angkatan")
	private String kelasAngkatan;

	@SerializedName("photo")
	private String photo;

	@SerializedName("jurusan")
	private String jurusan;

	@SerializedName("id")
	private String id;

	@SerializedName("tanggal_tambah")
	private String tanggalTambah;

	public void setNamaSiswa(String namaSiswa){
		this.namaSiswa = namaSiswa;
	}

	public String getNamaSiswa(){
		return namaSiswa;
	}

	public void setKelasAngkatan(String kelasAngkatan){
		this.kelasAngkatan = kelasAngkatan;
	}

	public String getKelasAngkatan(){
		return kelasAngkatan;
	}

	public void setPhoto(String photo){
		this.photo = photo;
	}

	public String getPhoto(){
		return photo;
	}

	public void setJurusan(String jurusan){
		this.jurusan = jurusan;
	}

	public String getJurusan(){
		return jurusan;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTanggalTambah(String tanggalTambah){
		this.tanggalTambah = tanggalTambah;
	}

	public String getTanggalTambah(){
		return tanggalTambah;
	}

	@Override
 	public String toString(){
		return 
			"ListDatasiswaItem{" + 
			"nama_siswa = '" + namaSiswa + '\'' + 
			",kelas_angkatan = '" + kelasAngkatan + '\'' + 
			",photo = '" + photo + '\'' + 
			",jurusan = '" + jurusan + '\'' + 
			",id = '" + id + '\'' + 
			",tanggal_tambah = '" + tanggalTambah + '\'' + 
			"}";
		}
}