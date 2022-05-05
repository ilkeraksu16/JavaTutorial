package MySession;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public abstract class BaseSession {
	
	protected StandardServiceRegistry ssr;
	protected Metadata meta;
	protected SessionFactory factory;
	protected Session session;
	protected Transaction t;
	
	public BaseSession() {
		if(ssr == null)
			ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		
		if(meta == null)
			meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	    
		if(factory == null)
			factory = meta.getSessionFactoryBuilder().build();  
	    
		if(session == null)
			session = factory.openSession(); 
		
		if(t == null)
			t = session.beginTransaction();
		
	}
	
}
