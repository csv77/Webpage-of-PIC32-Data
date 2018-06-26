package sensordata.pic32.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sensordata.pic32.domain.SensorDataObject;

@Repository
public class SensorDataDaoImpl implements SensorDataDao {
//	private static final String SELECT_ALL = "select * from sensordata";
//	private static final String SELECT_ONE_RECORD = "select * from sensordata where id = ?";
//	
//	private final DataSource dataSource;
	private final SessionFactory sessionFactory;
	
	public SensorDataDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public SensorDataObject getSensorData(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(SensorDataObject.class, id);
	}

	@Transactional
	public List<SensorDataObject> getAllSensorData() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from SensorDataObject", SensorDataObject.class).list();
	}
	
	
//	@Override
//	public List<SensorDataObject> getAllSensorData() {
//		try (Connection connection = dataSource.getConnection();
//			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
//			ResultSet result = preparedStatement.executeQuery()) {
//			
//			List<SensorDataObject> sensorData = new ArrayList<>();
//			while(result.next()) {
//				Integer id = result.getInt("id");
//				Date date = new Date(result.getTimestamp("date").getTime());
//				Double temperature = result.getDouble("temperature");
//				Double humidity = result.getDouble("humidity");
//				sensorData.add(new SensorDataObject(id, date, temperature, humidity));
//			}
//			return sensorData;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//
//	@Override
//	public SensorDataObject getSensorData(Integer id) {
//		try (Connection connection = dataSource.getConnection();
//			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE_RECORD)) {
//			preparedStatement.setString(1, id.toString());
//			
//			SensorDataObject sensorData = null;
//			try (ResultSet result = preparedStatement.executeQuery()) {
//				if(result.next()) {
//					Integer index = result.getInt("id");
//					Date date = new Date(result.getTimestamp("date").getTime());
//					Double temperature = result.getDouble("temperature");
//					Double humidity = result.getDouble("humidity");
//					sensorData = new SensorDataObject(index, date, temperature, humidity); 
//				}
//			}
//			return sensorData;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
}
