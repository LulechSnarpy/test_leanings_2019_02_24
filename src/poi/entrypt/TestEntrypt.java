package poi.entrypt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


public class TestEntrypt {
	
	@Test
	public void encrypt() throws Exception{
		//构建XSSFWorkbook
	    XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
	    XSSFSheet sheet1 = xssfWorkbook.createSheet("sheet1");
	    XSSFRow row1 = sheet1.createRow(0);
	    XSSFCell cell1 = row1.createCell(0);
	    cell1.setCellValue("cell1");
	    cell1.setCellType(CellType.STRING);
	    XSSFCell cell2 = row1.createCell(1);
	    cell2.setCellValue(2);
	    cell2.setCellType(CellType.NUMERIC);

	    //保存此XSSFWorkbook对象为xlsx文件
	    xssfWorkbook.write(new FileOutputStream("D:/test.xlsx"));
		xssfWorkbook.close();
		
		POIFSFileSystem fs = new POIFSFileSystem();
	    EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
	    Encryptor enc = info.getEncryptor();

	    //设置密码
	    enc.confirmPassword("123456");

	    //加密文件
	    OPCPackage opc = OPCPackage.open(new File("D:/test.xlsx"), PackageAccess.READ_WRITE);
	    OutputStream os = enc.getDataStream(fs);
	    opc.save(os);
	    opc.close();

	    //把加密后的文件写回到流
	    FileOutputStream fos = new FileOutputStream("D:/test.xlsx");
	    fs.writeFilesystem(fos);
	    fos.close();
	}
}
