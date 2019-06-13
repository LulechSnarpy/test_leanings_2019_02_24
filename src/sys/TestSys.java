package sys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class TestSys {
	@Test
	public void getTmpDir() {
		System.out.println(System.getProperty("java.io.tmpdir"));
	}
	@Test 
	public void getSystemProperties() throws FileNotFoundException, IOException {
		Properties p = System.getProperties();
		p.store(new FileOutputStream(new File("./resource/file/system.properties")), "");
	}
}
