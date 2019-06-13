package testng;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class TestRemoveFiles {
	
//  @Test
  public void moveTo() throws IOException {
	  String s = "F:/报表模版 ver 1.0";
	  String t = "F:/报表模版 ver 1.1";
	  findFile(new File(s), t);
  }
  
  @Test
  public void getInfomation() throws IOException {
	  String t = "F:/报表模版 ver 1.2";
	  findFile(new File(t));
  }
  
  public void findFile(File file, String t) throws IOException {
	  File[] files = file.listFiles(x->x.isFile() && x.getName().endsWith(".xlsx"));
	  File[] dirs = file.listFiles(x->x.isDirectory());
	  for (File f : files) {
		  System.out.println(f.getAbsolutePath());
		  Files.copy(Paths.get(f.getAbsolutePath()), Paths.get(new File(t, f.getName()).getAbsolutePath()));
	  }
	  for (File dir : dirs) {
		  findFile(dir, t);
	  }
  }
  
  public void findFile(File file) throws IOException {
	  File[] files = file.listFiles(x->x.isFile() && x.getName().endsWith(".xlsx"));
	  File[] dirs = file.listFiles(x->x.isDirectory());
	  int i = 0;
	  for (File f : files) {
		  System.out.printf("public final static String %s_%04d = \"%s\";\n",f.getName().substring(0, 4),++i,f.getName());
	  }
	  for (File dir : dirs) {
		  findFile(dir);
	  }
  }
}
