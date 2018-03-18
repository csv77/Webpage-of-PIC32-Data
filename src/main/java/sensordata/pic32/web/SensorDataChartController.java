package sensordata.pic32.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sensordata.pic32.dao.SensorDataDao;
import sensordata.pic32.domain.SensorDataObject;

@Controller
@RequestMapping("/chart")
public class SensorDataChartController {
	
	SensorDataDao sensorDataDao;
	
	public SensorDataChartController(SensorDataDao sensorDataDao) {
		this.sensorDataDao = sensorDataDao;
	}

	@GetMapping
    public String setupTable(Model model) {
        List<SensorDataObject> sensorData = sensorDataDao.getAllSensorData(); 
        model.addAttribute("sensorDataTable", sensorData);
        return "chart";
    }
}
