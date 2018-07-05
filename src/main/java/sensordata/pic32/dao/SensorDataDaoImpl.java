package sensordata.pic32.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sensordata.pic32.domain.SensorDataObject;

@Repository
public class SensorDataDaoImpl implements SensorDataDao {

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
}
