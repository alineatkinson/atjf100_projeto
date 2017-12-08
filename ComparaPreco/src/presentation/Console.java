package presentation;

import java.util.Scanner;

/**
 * @author Aline Atkinson da Cunha
 */

class Console implements Reader {

	private Scanner keyboard = new Scanner(System.in);

	/**
	 * O teclado lê o caracter digitado pelo usuário
	 *
	 */
	public char readCharacter() {
		return keyboard.next().charAt(0);
	}

	/**
	 * The keyboard read the text wirtten into console
	 *
	 */
	public String readText() {
		return keyboard.nextLine();
	}

	/**
	 * O teclado lê o número digitado pelo usuário
	 *
	 */
	public double readNumberDouble() {
		return keyboard.nextDouble();
	}

	/**
	 * O teclado lê o número digitado pelo usuário
	 *
	 */
	public int readNumber() {
        String text = readText();
        return Integer.parseInt(text);
    }

}
