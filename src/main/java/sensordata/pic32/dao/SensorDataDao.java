package sensordata.pic32.dao;

import java.util.List;

import sensordata.pic32.domain.SensorDataObject;

public interface SensorDataDao {
	
	public List<SensorDataObject> getAllSensorData();
	
	public SensorDataObject getSensorData(Integer id);
}
