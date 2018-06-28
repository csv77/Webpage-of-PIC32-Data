package sensordata.pic32.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.LineChartSeries;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import sensordata.pic32.domain.SensorDataObject;

public class SensorDataExcelView extends AbstractXlsxView {
	
	private List<String> headersList = Arrays.asList("Index", "Date", "Temperature (°C)", "Humidity (%)");
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		final List<SensorDataObject> listOfSensorData = (List<SensorDataObject>)model.get("sensorDataTable");
		final Map<String, CellStyle> styles = setStyles(workbook);
		
		XSSFSheet sheet = ((XSSFWorkbook)workbook).createSheet("SensorData");
		createHeader(sheet, styles.get("header"));
		
		listOfSensorData.forEach(sensorData -> createTableRow(sheet, sensorData, styles));
		
		sheet.createFreezePane(1, 1);
		
		setWidth(sheet);
		
		XSSFDrawing drawing = sheet.createDrawingPatriarch();
		XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 6, 2, 22, 26);
		
		XSSFChart chart = drawing.createChart(anchor);
		XSSFChartLegend legend = chart.getOrCreateLegend();
		legend.setPosition(LegendPosition.BOTTOM);
		
		LineChartData data = chart.getChartDataFactory().createLineChartData();
		chart.setTitleFormula("SensorData");
		
		ChartAxis bottomAxis = chart.getChartAxisFactory().createDateAxis(AxisPosition.BOTTOM);
		ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
		leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
		
		ChartDataSource<Number> x = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 0, 0));
		ChartDataSource<Number> yTemp = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 2, 2));
		ChartDataSource<Number> yHum = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 10, 3, 3));
		
		LineChartSeries tempSerie = data.addSeries(x, yTemp);
		LineChartSeries humSerie = data.addSeries(x, yHum);
		tempSerie.setTitle("Temperature");
		humSerie.setTitle("Humidity");
		
		chart.plot(data, new ChartAxis[] {bottomAxis, leftAxis});
	}
	
	private void createHeader(Sheet sheet, CellStyle style) {
		Row header = sheet.createRow(0);
		
		int i = 0;
		for(String element : headersList) {
			Cell cell = header.createCell(i++);
			cell.setCellValue(element);
			cell.setCellStyle(style);
		}
	}
	
	private void createTableRow(Sheet sheet, SensorDataObject sensorData, Map<String, CellStyle> styles) {
		Row row = sheet.createRow(sheet.getLastRowNum() + 1);
		row.createCell(0).setCellValue(sensorData.getId());
		
		Cell cellOfDate = row.createCell(1);
		cellOfDate.setCellValue(sensorData.getDate());
		cellOfDate.setCellStyle(styles.get("date"));
		
		Cell cellOfTemp = row.createCell(2);
		cellOfTemp.setCellValue(sensorData.getTemperature());
		cellOfTemp.setCellStyle(styles.get("temperature"));
		Cell cellOfHum = row.createCell(3);
		cellOfHum.setCellValue(sensorData.getHumidity());
		cellOfHum.setCellStyle(styles.get("humidity"));
		
	}
	
	private void setWidth(Sheet sheet) {
		Row row = sheet.getRow(0);
		int lastRowNum = row.getLastCellNum();
		for(int i = 0; i < lastRowNum; i++) {
			sheet.autoSizeColumn(i);
		}
	}
	
	private Map<String, CellStyle> setStyles(Workbook workbook) {
		Map<String, CellStyle> styles = new HashMap<>();
		
		CellStyle styleOfHeader = workbook.createCellStyle();
		styleOfHeader.setAlignment(HorizontalAlignment.CENTER);
		Font font = workbook.createFont();
		font.setBold(true);
		styleOfHeader.setFont(font);
		styleOfHeader.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		styleOfHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styles.put("header", styleOfHeader);
		
		CellStyle styleOfDate = workbook.createCellStyle();
		styleOfDate.setDataFormat(workbook.createDataFormat().getFormat("[$-409]mmmm dd, yy h:mm:ss AM/PM"));
		styles.put("date", styleOfDate);
		
		CellStyle styleOfTemp = workbook.createCellStyle();
		styleOfTemp.setDataFormat(workbook.createDataFormat().getFormat("###0.00"));
		styles.put("temperature", styleOfTemp);
		
		CellStyle styleOfHum = workbook.createCellStyle();
		styleOfHum.setDataFormat(workbook.createDataFormat().getFormat("###0.00"));
		styles.put("humidity", styleOfHum);
		
		return styles;
	}
}
