package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {
	private PasswordGeneration generator;

	@Before
	public void setUp() throws Exception {
		generator = new PasswordGeneration();
	}

	@Test
	public void getRandomPassword() {
		assertEquals(8, generator.getRandomPassword().length());
	}
}