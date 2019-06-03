package beaninfo;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;


public class BeanInfoTest {
	
	@Test
	public void testBeanInfo() throws Exception{
		BeanInfo info = Introspector.getBeanInfo(Dash.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			System.out.println(pd.getName());
		}
	}
	
	
	@Test
	public void testGetStaticValue() throws Exception{
		Object o = Dash.class.getField("SECOND").get(null);
		System.out.println(o);
	}
}
