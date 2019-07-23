package workingtemp;

import java.math.BigDecimal;

import org.testng.annotations.Test;

public class TestBigDecimal {
	@Test
	public void test() {
		System.out.println(BigDecimal.ZERO.setScale(4).toPlainString());
	}
}
