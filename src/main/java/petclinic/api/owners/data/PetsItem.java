package petclinic.api.owners.data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.List;

@Getter
public class PetsItem{

	@SerializedName("visits")
	private List<VisitsItem> visits;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private Type type;

	@SerializedName("birthDate")
	private String birthDate;

	public List<VisitsItem> getVisits(){
		return visits;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Type getType(){
		return type;
	}

	public String getBirthDate(){
		return birthDate;
	}
}