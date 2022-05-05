package Operations;

import MySession.MySession;
import Tables.Phone;
import Utility.XBag;
import Utility.XBagFactory;

public class PhoneOperation implements IOperation{
	MySession<Phone> phoneSession = new MySession<Phone>();
	@Override
	public XBag add(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Phone phone = new Phone();
		phone.setPhone((String)inBag.get("Phone"));
		phone.setCustomerId((int)inBag.get("CustomerId"));
		phoneSession.insert(phone);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
	@Override
	public XBag update(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Phone phone = new Phone();
		phone.setPhone((String)inBag.get("Phone"));
		phone.setCustomerId((int)inBag.get("CustomerId"));
		phoneSession.update(phone);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
		
	}
	@Override
	public XBag delete(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Phone phone = new Phone();
		phone.setId((int)inBag.get("Id"));
		phoneSession.delete(phone);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
}
