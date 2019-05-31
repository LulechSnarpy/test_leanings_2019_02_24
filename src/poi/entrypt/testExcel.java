package poi.entrypt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testExcel {
    public static void main(String arg[]) throws IOException, GeneralSecurityException {
        //讀取加密的 Excel
        InputStream inp = new FileInputStream("D:/test.xlsx");
        POIFSFileSystem pfs = new POIFSFileSystem(inp);
        inp.close();
        EncryptionInfo encInfo = new EncryptionInfo(pfs);
        Decryptor decryptor = Decryptor.getInstance(encInfo);
        decryptor.verifyPassword("123456");
        XSSFWorkbook workbook = new XSSFWorkbook(decryptor.getDataStream(pfs));
        
        //重新加密
        POIFSFileSystem fileSystem = new POIFSFileSystem();
        EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
        Encryptor enc = info.getEncryptor();
        enc.confirmPassword("12345");
        OutputStream encryptedDS = enc.getDataStream(fileSystem);
        workbook.write(encryptedDS);
        FileOutputStream fos = new FileOutputStream("D:/test.xlsx");
        fileSystem.writeFilesystem(fos);
        fos.close();
        workbook.close();
    }
}
