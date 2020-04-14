package com.xml;

public class Weather {
	private String condition, date, city;
	private String low, high, current;

	public Weather() {
	}	

	public String getCondition() {
		return condition;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();		
		builder.append("[");
		builder.append("date=");
		builder.append(date);
		builder.append(", condition=");
		builder.append(condition);
		builder.append(", city=");
		builder.append(city);
		builder.append(", low=");
		builder.append(low);
		builder.append(", high=");
		builder.append(high);		
		builder.append("]");
		return builder.toString();
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		if (low == null)
			low = "";
		else
			this.low = low;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		if (high == null)
			high = "";
		else
			this.high = high;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		if (current == null)
			current = "";
		else
			this.current = current;
	}
}
