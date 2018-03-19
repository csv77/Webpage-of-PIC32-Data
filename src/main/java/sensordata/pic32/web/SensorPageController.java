package sensordata.pic32.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sensordata.pic32.dao.SensorDataDao;
import sensordata.pic32.domain.SensorDataObject;

@Controller
@RequestMapping("/")
public class SensorPageController {
	
	SensorDataDao sensorDataDao;
	
	public SensorPageController(SensorDataDao sensorDataDao) {
		this.sensorDataDao = sensorDataDao;
	}
	
	@GetMapping
    public String homePage(Model model) {
        Date today = new Date();
        model.addAttribute("today", today);
        return "home";
    }
	
	@PostMapping(params = {"table"})
	public String tablePage(Model model) {
        List<SensorDataObject> sensorData = sensorDataDao.getAllSensorData(); 
        model.addAttribute("sensorDataTable", sensorData);
        return "table";
    }
	
	@PostMapping(params = {"chart"})
    public String chartPage(Model model) {
        List<SensorDataObject> sensorData = sensorDataDao.getAllSensorData(); 
        model.addAttribute("sensorDataTable", sensorData);
        return "chart";
    }
	
	@PostMapping(params = {"home"})
    public String backToHomePage(Model model) {
        Date today = new Date(); 
        model.addAttribute("today", today);
        return "home";
    }
} 