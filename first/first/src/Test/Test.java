package Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import MySession.MySession;
import Operations.CommandExecuter;
import Tables.*;
import Utility.IXBagKeys;
import Utility.XBag;
import Utility.XBagFactory;
import Xml.XmlParser;

public class Test {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException, ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		
		//XBag inBag = XBagFactory.createBag();
		XBag outBag = XBagFactory.createBag();
//		inBag.put("AccountNo", "3265987452");
//		inBag.put("CustomerId", 1);
//		outBag = CommandExecuter.execute("AccountAdd",inBag);
		
		XBag xmlToXBag = XmlParser.parseXMLToList("request");
		String commandName = (String) xmlToXBag.get(IXBagKeys.CommandName);
		outBag = CommandExecuter.execute(commandName,xmlToXBag);
		String mesaj = (String) outBag.get("Mesaj");
		System.out.println(mesaj);
		
	}

}
