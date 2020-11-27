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
		assertEquals("PDUR", loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul"));
		assertTrue(loginService.loginExists("PDUR"));

		// CT2
		assertEquals("JRAL2", loginGenerator.generateLoginForNomAndPrenom("Ralling", "John"));
		assertTrue(loginService.loginExists("JRAL2"));

		// CT3
		assertEquals("JROL1", loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean"));
		assertTrue(loginService.loginExists("JROL1"));

		// CT4
		assertEquals("PDUR1", loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul"));
		assertTrue(loginService.loginExists("PDUR1"));

		// CT5
		assertEquals("PDU", loginGenerator.generateLoginForNomAndPrenom("Du", "Paul"));
		assertTrue(loginService.loginExists("PDU"));
	}
}