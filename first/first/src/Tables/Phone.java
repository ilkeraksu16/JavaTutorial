package Tables;

import javax.persistence.*;

@Entity
@Table(name = "phone", schema = "\"task\"")
public class Phone {
	@Id	
	@GeneratedValue()
	public int id;
	public int customerId;
	public String phone;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
