package sensordata.pic32.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

public class SensorDataExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		final List<SensorDataObject> listOfSensorData = (List<SensorDataObject>)model.get("sensorDataTable");
		
		Sheet sheet = workbook.createSheet();
		Row firstRow = sheet.createRow(0);
		firstRow.createCell(0).setCellValue(5.5);
	}
}
