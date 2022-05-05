package Xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Utility.IXBagKeys;
import Utility.XBag;
import Utility.XBagFactory;

public class XmlParser {
	public static XBag parseXMLToList(String xmlType) throws ParserConfigurationException, SAXException, IOException{
		XBag outBag = XBagFactory.createBag();
		int tagLength = 0;
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = (Document) builder.parse(new File(xmlType+".xml"));
		
		
		String commandName = document.getDocumentElement().getElementsByTagName(IXBagKeys.CommandName).item(0).getTextContent();
		
		NodeList nodeListId = document.getDocumentElement().getElementsByTagName(IXBagKeys.Id);
		NodeList nodeListCustomerId = document.getDocumentElement().getElementsByTagName(IXBagKeys.CustomerId);
		NodeList nodeListAddress = document.getDocumentElement().getElementsByTagName(IXBagKeys.Address);
		NodeList nodeListFirstName = document.getDocumentElement().getElementsByTagName(IXBagKeys.FirstName);
		NodeList nodeListLastName = document.getDocumentElement().getElementsByTagName(IXBagKeys.LastName);
		NodeList nodeListEMAil = document.getDocumentElement().getElementsByTagName(IXBagKeys.EMAil);
		NodeList nodeListPhone = document.getDocumentElement().getElementsByTagName(IXBagKeys.Phone);
		NodeList nodeListAccountNo = document.getDocumentElement().getElementsByTagName(IXBagKeys.AccountNo);
		
		
		tagLength = nodeListId.getLength();
		if(tagLength > 0) {
			String id = document.getDocumentElement().getElementsByTagName(IXBagKeys.Id).item(0).getTextContent();
			outBag.put(IXBagKeys.Id, Integer.parseInt(id));
		}
		
		tagLength = nodeListCustomerId.getLength();
		if(tagLength > 0) {
			String customerId = document.getDocumentElement().getElementsByTagName(IXBagKeys.CustomerId).item(0).getTextContent();
			outBag.put(IXBagKeys.CustomerId,  Integer.parseInt(customerId));
		}
		
		tagLength = nodeListAddress.getLength();
		if(tagLength > 0) {
			String address = document.getDocumentElement().getElementsByTagName(IXBagKeys.Address).item(0).getTextContent();
			outBag.put(IXBagKeys.Address, address);
		}
		
		tagLength = nodeListFirstName.getLength();
		if(tagLength > 0) {
			String firstName = nodeListFirstName.item(0).getTextContent();
			outBag.put(IXBagKeys.FirstName, firstName);
		}
		
		
		tagLength = nodeListLastName.getLength();
		if(tagLength > 0) {
			String lastName = nodeListLastName.item(0).getTextContent();
			outBag.put(IXBagKeys.LastName, lastName);
		}
		
		tagLength = nodeListEMAil.getLength();
		if(tagLength > 0) {
			String eMAil = nodeListEMAil.item(0).getTextContent();
			outBag.put(IXBagKeys.EMAil, eMAil);
		}
		
		tagLength = nodeListPhone.getLength();
		if(tagLength > 0) {
			String phone = nodeListPhone.item(0).getTextContent();
			outBag.put(IXBagKeys.Phone, phone);
		}
		
		tagLength = nodeListAccountNo.getLength();
		if(tagLength > 0) {
			String accountNo = nodeListAccountNo.item(0).getTextContent();
			outBag.put(IXBagKeys.AccountNo, accountNo);
		}
		
		outBag.put(IXBagKeys.CommandName, commandName);
		
		return outBag;
	}
}
