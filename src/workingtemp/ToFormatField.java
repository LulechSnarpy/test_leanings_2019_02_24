package workingtemp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import org.testng.annotations.Test;

public class ToFormatField {
  @Test
  public void f() {
	  try(BufferedReader buffer = new BufferedReader(new FileReader("./resource/file/reportfield.txt"));
			  PrintWriter pw = new PrintWriter("./resource/file/reportfields.txt")) {
		  String s = null;
		  StringBuffer bf = new StringBuffer();
		  while(null != (s = buffer.readLine())) {
			if (!s.trim().isEmpty()) {
				s = "${v."+s+"}";
			}
			bf.append("\t").append(s);
		  }
		  if(bf.length() > 0) {
			  bf.deleteCharAt(0);
		  }
		  pw.print(bf.toString());
	  } catch (Exception e) {
		  e.printStackTrace();
	  }
  }
}
