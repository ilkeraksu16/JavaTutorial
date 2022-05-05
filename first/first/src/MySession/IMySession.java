package MySession;

import java.util.ArrayList;
import java.util.List;

public interface IMySession<T> {
	List<T> list(T criter) throws IllegalArgumentException, IllegalAccessException;
	void insert(T model);
	void update(T model);
	void delete(T model);
	T get(T model) throws IllegalArgumentException, IllegalAccessException;
}
