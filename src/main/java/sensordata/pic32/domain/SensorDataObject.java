package sensordata.pic32.domain;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensordata")
public class SensorDataObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Column(name = "date", nullable = false)
	Date date;
	
	@Column(name = "temperature", nullable = false)
	Double temperature;
	
	@Column(name = "humidity", nullable = false)
	Double humidity;
	
	public SensorDataObject() {
	}
	
	public SensorDataObject(Integer id, Date date, Double temperature, Double humidity) {
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
	
	@Override
	public String toString() {
		return "index: " + this.id + 
				"\tdate: " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.US).format(this.date) +
				"\ttemperature: " + String.format("%.2f", this.temperature) + " C°" +
				"\thumidity: " + String.format("%.2f", this.humidity) + " %";
	}
}
