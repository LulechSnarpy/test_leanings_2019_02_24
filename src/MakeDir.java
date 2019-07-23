import java.io.File;

import org.testng.annotations.Test;

public class MakeDir {
	
	@Test
	public void makeDir() {
		File file = new File("/home/testc/test/upload/");
		file.mkdirs();
	}
}
