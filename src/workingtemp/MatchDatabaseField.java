package workingtemp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import org.junit.Test;

/**
 * 清理字段信息 并 获取相应的属性名称
 * */
public class MatchDatabaseField {
	
	@Test
	public void generateGetterSetter() {
		try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\lulec\\Desktop\\ProNames.txt"))) {
			String property = null;
			String propertyUpperHeader = null;
			String propertyUpperHeader1 = null;
			String modelName = "agentStaffContract";
			while (null != (property = reader.readLine())) {
				propertyUpperHeader = toUpperHeader(property);
				property = property.replace("1", "");
				propertyUpperHeader1 = propertyUpperHeader.replace("1", "");
				System.out.printf("public String get%s() {\r\n" + 
						"        return %s.get%s();\r\n" + 
						"    }\n", propertyUpperHeader, modelName, propertyUpperHeader1);
				System.out.println();
				System.out.printf("public void set%s(String %s) {\r\n" + 
						"        %s.set%s(%s);\r\n" + 
						"    }\n", propertyUpperHeader, property, modelName, propertyUpperHeader1, property);
				System.out.println();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//@Test
	public void toFile() {
		try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\lulec\\Desktop\\FieldNames.txt"));
				PrintWriter writer = new PrintWriter(new File("C:\\Users\\lulec\\Desktop\\ProNames.txt"));
				PrintWriter writer1 = new PrintWriter(new File("C:\\Users\\lulec\\Desktop\\FieldNamesCl.txt"));) {
			String field = null;
			while (null != (field = reader.readLine())) {
				field = clearField(field);
				writer1.println(field);
				writer.println(FieldToProperty(field));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	// @Test
	public void outprint() {
		System.out.println(FieldToProperty("a_bag"));
		System.out.println(crlearTop("T5.beef"));
	}
	
	public String clearField(String s) {
		s = s.toLowerCase();
		int idx = s.indexOf(" as ");
		s =  idx > -1 ? (idx+4 < s.length() ?  s.substring(idx+4) : "") : s;
		s = s.replaceAll("`", "");
		return crlearTop(s);
	}
	
	public String crlearTop(String s) {
		int idx = s.indexOf('.');
		return idx > -1 ? (idx < s.length() ? s.substring(idx+1) : "") : s; 
	}
	
	public String toUpperHeader(String s) {
		if ("".equals(s)) return s;
		char first = s.charAt(0);
		if (Character.isLetter(first)) first = (char)(first-32);
		return first + s.substring(1);
	}
	
	public String FieldToProperty(String field) {
		StringBuffer buffer = new StringBuffer();
		String property = field.toLowerCase();
		String[] elements = property.split("_");
		boolean flag = false;
		for (String element : elements) {
			if ("".equals(element)) continue;
			if (flag) buffer.append(toUpperHeader(element));
			else buffer.append(element);
			flag = true;
		}
		property = buffer.toString();
		return property;
	}
}
