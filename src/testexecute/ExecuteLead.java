package testexecute;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExecuteLead {
	static Keyword keyword;
	public static void main(String[] args) throws IOException {
		keyword = new Keyword();
		keyword.loadproperties();
		ArrayList data = new ArrayList();
		File f = new File("C:\\Users\\012533\\Desktop\\HybridTestData.xlsx");
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet s = wb.getSheet("Test_Data");	
		Iterator row = s.iterator();
		while (row.hasNext()){
			Row rowitr = (Row)row.next();
			Iterator cellitr = rowitr.cellIterator();
			while (cellitr.hasNext()){
				Cell cell = (Cell) cellitr.next();
switch (cell.getCellType()) {
				
				case Cell.CELL_TYPE_STRING:
					data.add(cell.getStringCellValue());
				    break;
				case Cell.CELL_TYPE_BOOLEAN:
					data.add(cell.getBooleanCellValue());
				    break;
				case Cell.CELL_TYPE_NUMERIC:
					data.add(cell.getNumericCellValue());
				    break;
			}
			
		}
	}
for (int i=3;i<data.size();i++){
			
			if (data.get(i).equals("openbrowser")) {
				System.out.println(data.get(i));
				keyword.openbrowser();
			}
			if (data.get(i).equals("navigate")) {
				String key = (String) data.get(i);
				String testData = (String) data.get(i+2);
				String objectName = (String) data.get(i+3);
				keyword.navigate(testData);
			}
			if (data.get(i).equals("input")) {
				String key = (String) data.get(i);
				String testData = (String) data.get(i+2);
				String objectName = (String) data.get(i+3);
				keyword.input(testData,objectName);
				
			}
			if (data.get(i).equals("click")){
				String key = (String) data.get(i);
				String testData = (String) data.get(i+2);
				String objectName = (String) data.get(i+3);
				keyword.click(objectName);
			}
			if(data.get(i).equals("titleverification")){
				String key = (String) data.get(i);
				String testData = (String) data.get(i+2);
				String objectName = (String) data.get(i+3);
				keyword.titleverification(testData);
			}
			if(data.get(i).equals("alert")){
				String key = (String) data.get(i);
				String testData = (String) data.get(i+2);
				String objectName = (String) data.get(i+3);
			    keyword.alertcheck(testData,objectName);
			}
			if(data.get(i).equals("select")){
				String key = (String) data.get(i);
				String testData = (String) data.get(i+2);
				String objectName = (String) data.get(i+3);
			    keyword.alertcheck(testData,objectName);
			}
			}
}
}
