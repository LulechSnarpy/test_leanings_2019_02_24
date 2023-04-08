package testng;

import org.testng.annotations.*;


/**
 * 
 * @author Lulech
 * @see https://howtodoinjava.com/testng/how-to-execute-testng-tests-with-maven-build/
 */
public class TestNGTest {
	String testName = "";
	
	@BeforeTest
	@Parameters({ "test-name" })
	public void beforeTest(@Optional("test-name")String testName){
		this.testName = testName;
		long id = Thread.currentThread().getId();
		System.out.println("Before test " + testName + ". Thread id is: " + id);
	}
	
	@BeforeClass
	public void beforeClass(){
		long id = Thread.currentThread().getId();
		System.out.println("Before test-class " + testName + ". Thread id is : "
				+ id);
	}
	
	@Test
	public void testMethodOne(){
		long id = Thread.currentThread().getId();
		System.out.println("Sample test-method " + testName
				+ ". Thread id is: " + id);
	}
	
	@AfterClass
	public void afterClass(){
		long id = Thread.currentThread().getId();
		System.out.println("After test-method " + testName
				+ ". Thread id is: " + id);
	}
	
	@AfterTest
	public void afterTest(){
		long id = Thread.currentThread().getId();
		System.out.println("After test " + testName + ". Thread  id is: " + id);
	}
}
