package assignment9;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;

	public Food() {
		// Set food at a random position within [0.05, 0.95] to stay in bounds
		x = 0.05 + Math.random() * 0.9;
		y = 0.05 + Math.random() * 0.9;
	}

	public void draw() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}