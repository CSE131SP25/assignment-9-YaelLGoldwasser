package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;

public class Game {

	private Snake snake;
	private Food food;
	private int score; // 🆕 Add score variable

	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = new Food();
		score = 0; //  Initialize score
	}

	public void play() {
		while (snake.isInbounds()) {
			int dir = getKeypress();
			snake.changeDirection(dir);
			snake.move();

			if (snake.eatFood(food)) {
				food = new Food();
				score++; //  Increase score
			}

			updateDrawing();
		}

		// Game over screen
		StdDraw.clear();
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.5, "Game Over!");
		StdDraw.text(0.5, 0.45, "Final Score: " + score); // Display final score
		StdDraw.show();
	}

	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}

	private void updateDrawing() {
		StdDraw.clear();

		snake.draw();
		food.draw();

		// 🆕 Draw the score at the top
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(0.5, 0.98, "Score: " + score);

		StdDraw.show();
		StdDraw.pause(50);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
