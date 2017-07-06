/**
 * 
 */
package org.lloyd.uk.consumerservice.model;

/**
 * @author jsreen
 *
 */
public class RandomJson {
	
	private String type;
	
	private Value value;
	
	/*public RandomJson(String type, Value value) {
		this.type = type;
		this.value = value;
	}*/
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Value value) {
		this.value = value;
	}
}