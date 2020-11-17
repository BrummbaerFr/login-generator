package geco;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LoginServiceTest {
	private LoginService ls;

	@Before
	public void setUp() {
		final String[] logins = new String[4];
		logins[0] = "login 1";
		logins[1] = "login 2";
		logins[2] = "login 3";
		logins[3] = "login 4";

		ls = new LoginService(logins);
	}

	@Test
	public void loginExists() {
		assertFalse(ls.loginExists("login 7"));

		assertTrue(ls.loginExists("login 1"));
	}

	@Test
	public void addLogin() {
		ls.addLogin("login 19");

		assertTrue(ls.loginExists("login 19"));
	}

	@Test
	public void findAllLoginsStartingWith() {
		ls.addLogin("hi");

		assertEquals(4, ls.findAllLoginsStartingWith("login").size());
	}

	@Test
	public void findAllLogins() {
		ls.addLogin("hello");

		assertEquals(5, ls.findAllLogins().size());
	}
}