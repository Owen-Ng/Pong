package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class CPUracket implements racket {
	double y, yvel;
	boolean upAccel, downAccel;
	int player, x;
	final double gravity = 0.5;
	Ball b;

	public CPUracket(int player, Ball b) {
		upAccel = false;
		downAccel = false;
		this.b = b;
		y = 210;
		yvel = 0;
		if (player == 1)
			x = 20;
		else
			x = 960;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, (int) y, 20, 100);
		// TODO Auto-generated method stub

	}

	public void move() {
		// TODO Auto-generated method stub

		y = b.GetY() - 15;
		if (y < 100) {
			y = 50;

		} else if (y > 800) {
			y = 800;
		}

	}

	public int getY() {
		// TODO Auto-generated method stub
		return (int) y;
	}

}
