package petclinic.api.owners.data;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Builder
@Setter
public class Response{


	@SerializedName("pets")
	private List<PetsItem> pets;

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("address")
	private String address;

	@SerializedName("city")
	private String city;

	@SerializedName("telephone")
	private String telephone;

	@SerializedName("id")
	private int id;

	public List<PetsItem> getPets(){
		return pets;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getAddress(){
		return address;
	}

	public String getCity(){
		return city;
	}

	public String getTelephone(){
		return telephone;
	}

	public int getId(){
		return id;
	}
}