package xyz.foobar;

import java.io.Serializable;
import java.util.List;

/**
 * The object representing a diff. Implement this class as you see fit.
 *
 */
public class Diff<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String parent;

	private List<String> fields;

	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}


	@Override
	public String toString() {
		return "Diff [parent=" + parent + ", fields=" + fields + ", obj=" + obj + "]";
	}

}
