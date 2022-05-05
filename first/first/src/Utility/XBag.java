package Utility;

import java.util.HashMap;

public class XBag {
	private HashMap<String, Object> objMap;
	public XBag() {
		objMap = new HashMap<String, Object>();
	}
	
	public XBag(XBag bag) {
		objMap = bag.objMap;
	}
	
	public HashMap<String, Object> getObject(){
		return objMap;
	}
	
	public void setObjMap(HashMap<String, Object> objMap) {
		this.objMap = objMap;
	}
	
	public Object get(String keyValue) {
		return objMap.get(keyValue);
	}
	
	public void put(String keyValue, Object obj) {
		if(get(keyValue) == null) {
			objMap.put(keyValue, obj);
		}else {
			objMap.replace(keyValue, obj);
		}
	}
	
	protected static XBag newInstance() {
		return new XBag();
	}
}
