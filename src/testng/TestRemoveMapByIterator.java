package testng;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

public class TestRemoveMapByIterator {

	@Test
	public void test(){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("test1", null);
		paramMap.put("test2", "1");
		for (Iterator<Entry<String, Object>> car = paramMap.entrySet().iterator(); car.hasNext();) {
			Entry<String, Object> entry = car.next();
			if (null == entry.getValue()) {
				car.remove();
			}
		}
	}
}
