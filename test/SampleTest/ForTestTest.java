package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class ForTestTest {

	@Test
	public void test() {
		ForTest sut = new ForTest();
        int expected = 10;
        int actual = sut.maltiplication(5, 2);
        assertThat(actual,is(expected));
    }
	
	@Test
    public void divtest() throws Exception {
        ForTest sut = new ForTest();
        float expected = 0.625f;
        float actual =  sut.division(5, 8);
        assertThat(actual,is(expected));
	}
	
}
