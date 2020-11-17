package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {
	private LoginService loginService;
	private LoginGenerator loginGenerator;

	@Before
	public void setUp() {
		loginService = new LoginService(new String[]{"JROL",
				"BPER", "CGUR", "JDU", "JRAL", "JRAL1"});

		loginGenerator = new LoginGenerator(loginService);
	}

	@Test
	public void generateLoginForNomAndPrenom() {
		// CT1
		loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
		assertTrue(loginService.loginExists("PDUR"));

		// CT2
		loginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
		assertTrue(loginService.loginExists("JRAL2"));

		// CT3
		loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
		assertTrue(loginService.loginExists("JROL1"));

		// CT4
		loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
		assertTrue(loginService.loginExists("PDUR1"));
	}
}