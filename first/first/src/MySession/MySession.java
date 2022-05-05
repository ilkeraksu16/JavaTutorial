package MySession;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Tables.Account;
import Tables.Customer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
public class MySession<T> extends BaseSession implements IMySession<T> {
	
	//@Override
	public List<T> list(T criter) throws IllegalArgumentException, IllegalAccessException {
		open();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		@SuppressWarnings("unchecked")
		CriteriaQuery<T> criteria = builder.createQuery((Class<T>)criter.getClass());
        //criteria.from((Class<T>)criter.getClass());
        
        Root<T> root = criteria.from((Class<T>)criter.getClass());
        
        Class cls = criter.getClass();
        Field[] field = cls.getDeclaredFields();
        
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        for (Field fld : field) {
			Class<?> type = fld.getType();
			String fieldName = fld.getName();
			String typeName = type.getSimpleName();
			Object value = fld.get(criter);
			
			if(typeName.equals("String") && value != null) {
				predicates.add(builder.between(root.get(fieldName), (String)value, (String)value));
			}
			
			if(typeName.equals("int") && value != null && (int)value != 0) {
				predicates.add(builder.between(root.get(fieldName), (int)value, (int)value));
			}
		}
        
        
        Predicate[] asd = (Predicate[]) predicates.toArray(new Predicate[0]);
        List<T> entityList = session.createQuery(criteria.select(root).where(asd)).getResultList();
        
        
		t.commit();
		close();
		return entityList;
	}

	@Override
	public void insert(T model) {
		// TODO Auto-generated method stub
		open();
		session.save(model);
		t.commit(); 
		close();
	}

	@Override
	public void  update (T model) {
		// TODO Auto-generated method stub
		open();
		session.update(model);
		t.commit();
		close();
	}

	@Override
	public void delete(T model) {
		// TODO Auto-generated method stub
		
		open();
		session.delete(model);
		t.commit();
		close();
	}
	@Override
	public T get(T model) throws IllegalArgumentException, IllegalAccessException {
		open();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		@SuppressWarnings("unchecked")
		CriteriaQuery<T> criteria = builder.createQuery((Class<T>)model.getClass());
        //criteria.from((Class<T>)criter.getClass());
        
        Root<T> root = criteria.from((Class<T>)model.getClass());
        
        Class cls = model.getClass();
        Field[] field = cls.getDeclaredFields();
        
        
        List<Predicate> predicates = new ArrayList<Predicate>();
        
        for (Field fld : field) {
			Class<?> type = fld.getType();
			String fieldName = fld.getName();
			String typeName = type.getSimpleName();
			Object value = fld.get(model);
			
			if(typeName.equals("String") && value != null) {
				predicates.add(builder.between(root.get(fieldName), (String)value, (String)value));
			}
			
			if(typeName.equals("int") && value != null && (int)value != 0) {
				predicates.add(builder.between(root.get(fieldName), (int)value, (int)value));
			}
		}
        
        
        Predicate[] asd = (Predicate[]) predicates.toArray(new Predicate[0]);
        List<T> entityList = session.createQuery(criteria.select(root).where(asd)).getResultList();
        
        
		t.commit();
		close();
		return entityList.size()> 0 ? entityList.get(0) : null;
	}
	
	private void close() {
		factory.close();  
	    session.close();  
	}
	private void open() {
		if(factory.isClosed())
			factory.openSession();
		if(!session.isOpen())
			session.beginTransaction();
		
	}
}
