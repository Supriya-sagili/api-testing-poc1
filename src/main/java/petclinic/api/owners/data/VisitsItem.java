package petclinic.api.owners.data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class VisitsItem{

	@SerializedName("date")
	private String date;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	public String getDate(){
		return date;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}
}