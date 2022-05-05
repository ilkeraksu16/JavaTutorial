package Tables;

import javax.persistence.*;

@Entity
@Table(name = "account", schema = "\"task\"")
public class Account {
	@Id	
	@GeneratedValue()
	public int id;
	public int customerId;
	public String accountNo;
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
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String type;
}
