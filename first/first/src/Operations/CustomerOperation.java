package Operations;

import MySession.MySession;
import Tables.Customer;
import Utility.XBag;
import Utility.XBagFactory;

public class CustomerOperation implements IOperation{
	MySession<Customer> customerSession = new MySession<Customer>();
	@Override
	public XBag add(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Customer customer=new Customer();        
		customer.setFirstName((String)inBag.get("FirstName"));    
		customer.setLastName((String)inBag.get("LastName"));    
		customer.setEmail((String)inBag.get("EMail"));		
		customerSession.insert(customer);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
	@Override
	public XBag update(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Customer customer=new Customer();        
		customer.setFirstName((String)inBag.get("FirstName"));    
		customer.setLastName((String)inBag.get("LastName"));    
		customer.setEmail((String)inBag.get("EMail"));	
		customer.setId((int)inBag.get("Id"));
		customerSession.update(customer);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
	@Override
	public XBag delete(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Customer customer=new Customer();        
		customer.setId((int)inBag.get("Id"));
		customerSession.delete(customer);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
	
}
