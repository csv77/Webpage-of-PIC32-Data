package sensordata.pic32.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sensordata.pic32.dao.SensorDataDao;
import sensordata.pic32.domain.SensorDataObject;

@Controller
@RequestMapping("/")
@EnableWebMvc
public class SensorPageController implements WebMvcConfigurer {
	
	SensorDataDao sensorDataDao;
	
	public SensorPageController(SensorDataDao sensorDataDao) {
		this.sensorDataDao = sensorDataDao;
	}
	
	@GetMapping(value = "/login")
	public String loginPage(@RequestParam(value = "logout", required = false) String logout, 
			@RequestParam(value = "error", required = false) String error, Model model) {
		if(logout != null) {
			model.addAttribute("logout", "You've been logged out.");
		}
		else if(error != null) {
			model.addAttribute("error", "Wrong username or password.");
		}
		return "login";
	}
	
	@GetMapping(value = {"/", "/home"})
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
	
	@PostMapping(params = {"excel"})
    public String excelPage(Model model) {
        List<SensorDataObject> sensorData = sensorDataDao.getAllSensorData(); 
        model.addAttribute("sensorDataTable", sensorData);
        return "excel";
    }
	
	@PostMapping(params = {"home"})
    public String backToHomePage(Model model) {
        Date today = new Date(); 
        model.addAttribute("today", today);
        return "home";
    }
} 