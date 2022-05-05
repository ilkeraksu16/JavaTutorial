package Operations;

import Utility.XBag;

public interface IOperation {
public XBag add(XBag inBag);
public XBag update(XBag inBag);
public XBag delete(XBag inBag);
}
