package Tables;

import javax.persistence.*;

@Entity
@Table(name = "service", schema = "\"task\"")
public class Service {
	@Id	
	@GeneratedValue()
	public int id;
	public String commandName, className, methodName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
}
