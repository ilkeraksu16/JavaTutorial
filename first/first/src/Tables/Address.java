package Tables;

import javax.persistence.*;

@Entity
@Table(name = "address", schema = "\"task\"")
public class Address {
	@Id	
	@GeneratedValue()
	public int id;
	public int customerId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String address;
}
