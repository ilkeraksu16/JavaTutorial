package Operations;

import MySession.MySession;
import Tables.Account;
import Utility.XBag;
import Utility.XBagFactory;

public class AccountOperation implements IOperation {
	MySession<Account> accountSession = new MySession<Account>();
	@Override
	public XBag add(XBag inBag) {
		Account account = new Account();
		XBag outBag = XBagFactory.createBag();
		account.setAccountNo((String)inBag.get("AccountNo"));
		account.setCustomerId((int)inBag.get("CustomerId"));
		accountSession.insert(account);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
		
	}
	@Override
	public XBag update(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Account account = new Account();
		account.setAccountNo((String)inBag.get("AccountNo"));
		account.setCustomerId((int)inBag.get("CustomerId"));
		accountSession.update(account);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
	}
	@Override
	public XBag delete(XBag inBag) {
		XBag outBag = XBagFactory.createBag();
		Account account = new Account();
		account.setId((int)inBag.get("Id"));
		accountSession.delete(account);
		outBag.put("Mesaj", "Ýþlem Baþarýlý");;
		return outBag;
		
	}
}
