package dev.id.bariscode.aplikasi1aplikasilistdatasiswadengandataapi.respones;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDataSiswa{

	@SerializedName("list_datasiswa")
	private List<ListDatasiswaItem> listDatasiswa;

	@SerializedName("status")
	private boolean status;

	public void setListDatasiswa(List<ListDatasiswaItem> listDatasiswa){
		this.listDatasiswa = listDatasiswa;
	}

	public List<ListDatasiswaItem> getListDatasiswa(){
		return listDatasiswa;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDataSiswa{" + 
			"list_datasiswa = '" + listDatasiswa + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}