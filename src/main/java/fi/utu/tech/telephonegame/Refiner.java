package fi.utu.tech.telephonegame;

import java.util.Random;

public class Refiner {

	private static final String[] text = new String(
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit Aliquam laoreet vitae lectus id vehicula "
					+ "Vivamus nec auctor diam Curabitur tincidunt tincidunt sapien, et porta urna dapibus vitae "
					+ "lacinia interdum Ut rhoncus, ante in tempor interdum, ipsum orci imperdiet massa, ut porta "
					+ "in erat cursus interdum Fusce quis leo venenatis, venenatis massa mollis, convallis mauris "
					+ "tempus quis Mauris vitae eros velit Morbi suscipit aliquet massa mollis sollicitudin"
					+ "turpis varius tortor, quis commodo dolor justo ac massa").split(" ");
	private static Random rnd = new Random();

	
	/*
	 * The refineText method is used to change the message
	 * Now it is time invent something fun! 
	 * 
	 * In the example implementation a random work from a word list is added to the end of the message.
	 * 
	 * Please keep the message readable. No ROT13 etc, please
	 * 
	 */
	public static String refineText(String inText) {
		String outText = inText;

		// Change the content of the message here.
		outText = outText + " " + text[rnd.nextInt(text.length)];

		return outText;
	}

	
	/*
	 * This method changes the color. No editing needed.
	 * 
	 * The color hue value is an integer between 0 and 360
	 */
	public static Integer refineColor(Integer inColor) {
		return (inColor + 20) < 360 ? (inColor + 20) : 0;
	}

}
