package generic_Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it contains reusable method with respect is excel
 * 
 * @author yashu
 *
 */
public class ExcelFileUtility {// excel file
	private Workbook wb;

	/**
	 * this method is used to intilized execl file
	 * 
	 * @param excelpath
	 * @throws IOException
	 */
	public void reintilization(String excelpath)  {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException |IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * it is used to read the single data from excel
	 * 
	 * @param Sheetname
	 * @param rownum
	 * @param cellvalue
	 * @return
	 */
	public String readData(String Sheetname, int rownum, int cellvalue) {
		return wb.getSheet(Sheetname).getRow(rownum).getCell(cellvalue).getStringCellValue();
	}

	/**
	 * this method is used read data from excel in the form of key values
	 * 
	 * @param sheetname
	 * @return
	 * @return
	 * @return
	 */
	public Map<String, String> readdata(String sheetname) {
		// Map<String, String> map= new HashMap<>();
		Map<String, String> map = new HashMap<String, String>();

		org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(sheetname);
		for (int i = 0; i <= sh.getLastRowNum(); i++) {
			String Key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
//	Cell cell=	sh.getRow(i).getCell(0);
//	Cell cell1=sh.getRow(i).getCell(1);
//	String key=cell.getStringCellValue();
//	String value=cell1.getStringCellValue();
			map.put(Key, value);

		}
		return map;

	}

	public void closeWorkBook() {

		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
