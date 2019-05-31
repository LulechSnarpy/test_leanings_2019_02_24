import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class GetFileNames{
	public static List<String> fileNames = new ArrayList<>();
	public static void main (String[] args) {
		File f = new File("F:/");
		getFileNames(f);
		try (PrintWriter pw = new PrintWriter("C:/Users/lulec/Desktop/项目名称列表.txt")) {
			for (String s : fileNames) {
				pw.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void getFileNames(File f) {
		File[] files = f.listFiles();
		if (null == files) return;	
		for (File file : files) {
			if (file.isDirectory()) {
				getFileNames(file);
				continue;
			}
			if (file.getName().endsWith(".doc")
				|| file.getName().endsWith(".docx")
					|| file.getName().endsWith(".txt") )
			fileNames.add(file.getName());
		}
	}
}