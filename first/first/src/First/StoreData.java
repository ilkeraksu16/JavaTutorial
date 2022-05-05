package First;  
  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import MySession.MySession;

  
public class StoreData {  
	public static void main(String[] args) {
//		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//	     SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//	     Session session = factory.openSession();  
//	     insert(session);
//	     factory.close();  
//	     session.close();     
		
		MySession<Customer>mySession = new MySession<Customer>();
		Customer customer=new Customer();        
		  customer.setFirstName("ilker");    
		  customer.setLastName("aksu");    
		  customer.setEmail("den@sd.com");		
		mySession.insert(customer);
	}
	
	private static void insert(Session session) {
		  Transaction t = session.beginTransaction();           
		  Customer customer=new Customer();        
		  customer.setFirstName("mert3");    
		  customer.setLastName("erten3");    
		  customer.setEmail("mert3@gmail.com");		  
		  session.save(customer); 
		  
//		  Account account=new Account();        
//		  account.setAmountMoney(7);    
//		  account.setAccountdescription("cash");
//		  account.setCustomerid(customer.getId());
//		  session.save(account);  
		  t.commit();  
		  System.out.println("successfully added");    
	}
	
	
} 

