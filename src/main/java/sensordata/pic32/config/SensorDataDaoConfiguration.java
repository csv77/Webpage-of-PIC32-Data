package sensordata.pic32.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

import sensordata.pic32.dao.SensorDataDao;
import sensordata.pic32.dao.SensorDataDaoImpl;

@Configuration
public class SensorDataDaoConfiguration {
	
	@Bean
	public SensorDataDao sensorDataDao() {
		return new SensorDataDaoImpl(dataSource());
	}
	
	@Bean 
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("csabi");
		dataSource.setPassword("ae293147");
		dataSource.setJdbcUrl("jdbc:mysql://localhost/sajat");
		dataSource.setMinimumIdle(2);
		dataSource.setMaximumPoolSize(5);
		return dataSource;
	}
}
