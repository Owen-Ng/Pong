package Pong;
import java.awt.Color;
import java.awt.Graphics;
public class Ball {
	double xvel, yvel, x ,y;
	public Ball() {
		x = 500;
		y = 500;
		xvel = -1;
		yvel = -1;
	}
	public void move() {
		x += 2*xvel;
		y += 2*yvel;
		if (y< 100) {
			yvel = -yvel;
		}
		else if (y>900) {
			yvel = -yvel;
		}
		
	}
	public void ballcollision(racket p1, racket p2) {
		if (x <= 40) {
			if (y >= p1.getY() && y <= p1.getY() + 50) {
				xvel = -xvel;
				yvel = -1;
			}
			else if (y>= p1.getY() + 51 && y <= p1.getY() + 100) {
				xvel = -xvel;
				yvel = 1;
			}
		}
		if (x >= 960) {
			if (y >= p2.getY() && y <= p2.getY() + 50) {
				xvel = -xvel;
				yvel = -1;
			}
			else if (y >= p2.getY() +51 && y <= p2.getY() + 100) {
				xvel = -xvel;
				yvel = 1;
			}
		}
		
	}
	public int GetX() {
		return (int)x;
	}
	public int GetY() {
		return (int)y;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int)y-10, 10, 10);
	}
}
