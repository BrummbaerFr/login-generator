package geco;

import java.util.Random;

public class PasswordGeneration {

	/**
	 * Returns a random 8-character password.
	 *
	 * @return a random 8-character password.
	 */
	public String getRandomPassword() {
		final Random random = new Random();
		final StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			sb.append((char) (random.nextInt(94) + 33));
		}

		return sb.toString();
	}
}
