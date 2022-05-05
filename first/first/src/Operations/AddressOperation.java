package Operations;

import MySession.MySession;
import Tables.Address;
import Utility.XBag;
import Utility.XBagFactory;

public class AddressOperation implements IOperation{
	MySession<Address> addressSession = new MySession<Address>();
	@Override
	public XBag add(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Address address = new Address();
		address.setAddress((String)inBag.get("Address"));
		address.setCustomerId((int)inBag.get("CustomerId"));
		addressSession.insert(address);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
	@Override
	public XBag update(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Address address = new Address();
		address.setAddress((String)inBag.get("Address"));
		address.setCustomerId((int)inBag.get("CustomerId"));
		addressSession.update(address);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
	@Override
	public XBag delete(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Address address = new Address();
		address.setId((int)inBag.get("Id"));
		addressSession.delete(address);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
}
