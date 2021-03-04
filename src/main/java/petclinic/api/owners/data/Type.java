package petclinic.api.owners.data;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class Type{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}