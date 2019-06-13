package poi;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.testng.annotations.Test;

public class TestSXSSF {
	
	public void createSheet() throws Exception{
		SXSSFWorkbook book = new SXSSFWorkbook();
		SXSSFSheet sheet = book.createSheet("runaway");
		SXSSFRow row = sheet.createRow(0);
		SXSSFCell cell = row.createCell(0);
		cell.setCellValue("Foolish");
		book.write(new FileOutputStream(new File("./resource/file/foolish.xlsx")));
		book.close();
	}
	
	@Test
	public void createSheet2() throws Exception{
		SXSSFWorkbook book = new SXSSFWorkbook(1000);
		SXSSFSheet sheet = book.createSheet("runaway");
		for (int i = 0; i < 10000; i++) {
			SXSSFRow row = sheet.createRow(i);
			SXSSFCell cell = row.createCell(0);
			CellStyle style = book.createCellStyle();
			DataFormat df = book.createDataFormat();
			cell.setCellValue("FoolishMan " + i);
			for (int j = 1 ; j<=4; j++) {
				cell = row.createCell(j);
				cell.setCellValue(i*i*i+3*i*i*j+3*i*j*j+j*j*j);
				style.setDataFormat(df.getFormat("#,###"));
				cell.setCellStyle(style);
			}
		}
		book.write(new FileOutputStream(new File("./resource/file/foolish.xlsx")));
		book.close();
	}
}
