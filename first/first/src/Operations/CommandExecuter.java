package Operations;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import MySession.MySession;
import Tables.Service;
import Utility.XBag;
import Utility.XBagFactory;

public class CommandExecuter {
	
	public  static XBag execute(String commandName, XBag inBag) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException {

		MySession<Service> serviceSession = new MySession<Service>();
		Service service = new Service();
		service.setCommandName(commandName);
		Service serviceInfo = serviceSession.get(service);
		XBag outBag = XBagFactory.createBag();
		if(serviceInfo != null) {
			Class<?> clazz = Class.forName("Operations."+serviceInfo.className);
			Constructor<?> ctor = clazz.getConstructor(null);
			Object instanceClass = ctor.newInstance();
			Method method = clazz.getMethod(serviceInfo.methodName,XBag.class);
			Object value = method.invoke(instanceClass,inBag);
			outBag = (XBag)value;
			return outBag;
		}
		outBag.put("Mesaj", "Metod Bulunamadý!");
		return outBag;
	}
}
