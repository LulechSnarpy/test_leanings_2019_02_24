package workingtemp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class FindReportField {
  private Map<String, String> map = new HashMap<>();
  @Test
  public void f() throws Exception{
	  try(BufferedReader buffer = new BufferedReader(new FileReader("./resource/file/field.txt"))) {
		  String s = null;
		  while(null != (s = buffer.readLine())) {
			  map.put(s.toLowerCase(), s);
		  }
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
	  try(BufferedReader buffer = new BufferedReader(new FileReader("./resource/file/column.txt"));
			  PrintWriter pw = new PrintWriter("./resource/file/reportfield.txt")) {
		  String s = null;
		  String v = null;
		  while(null != (s = buffer.readLine())) {
			  v = map.get(s.toLowerCase().replaceAll("_", ""));
			  if (null == v) v = s;
			  pw.println(v);
		  }
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
  }
  
}
