package sensordata.pic32.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import sensordata.pic32.domain.SensorDataObject;

public class SensorDataDaoImpl implements SensorDataDao {
	private static final String SELECT_ALL = "select * from sensordata";
	private static final String SELECT_ONE_RECORD = "select * from sensordata where id = ?";
	
	private final DataSource dataSource;
	
	public SensorDataDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<SensorDataObject> getAllSensorData() {
		try (Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
			ResultSet result = preparedStatement.executeQuery()) {
			
			List<SensorDataObject> sensorData = new ArrayList<>();
			while(result.next()) {
				Integer id = result.getInt("id");
				Date date = new Date(result.getTimestamp("date").getTime());
				Double temperature = result.getDouble("temperature");
				Double humidity = result.getDouble("humidity");
				sensorData.add(new SensorDataObject(id, date, temperature, humidity));
			}
			return sensorData;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public SensorDataObject getSensorData(Integer id) {
		try (Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_RECORD)) {
			preparedStatement.setString(1, id.toString());
			
			SensorDataObject sensorData = null;
			try (ResultSet result = preparedStatement.executeQuery()) {
				if(result.next()) {
					Integer index = result.getInt("id");
					Date date = new Date(result.getTimestamp("date").getTime());
					Double temperature = result.getDouble("temperature");
					Double humidity = result.getDouble("humidity");
					sensorData = new SensorDataObject(index, date, temperature, humidity); 
				}
			}
			return sensorData;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
