package sensordata.pic32.domain;

import java.util.Date;

public class SensorDataObject {
	Integer id;
	Date date;
	Double temperature;
	Double humidity;
	
	public SensorDataObject(Integer id, Date date, Double temperature, Double humidity) {
		super();
		this.id = id;
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
}
