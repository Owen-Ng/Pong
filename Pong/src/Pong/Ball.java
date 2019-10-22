package Pong;
import java.awt.Color;
import java.awt.Graphics;
public class Ball {
	double xvel, yvel, x ,y;
	public Ball() {
		x = 450;
		y = 500;
		xvel = -1;
		yvel = -1;
	}
	public void move() {
		x += xvel;
		y += yvel;
		if (y< 50) {
			yvel = -yvel;
		}
		else if (y>900) {
			yvel = -yvel;
		}
		
	}
	public void ballcollision(mypaddle p1, mypaddle p2) {
		if (x <= 40) {
			if (y >= p1.getY() && y <= p1.getY() + 80) {
				xvel = -xvel;
			}
		}
		if (x >= 540) {
			if (y >= p2.getY() && y <= p2.getY() + 80) {
				xvel = -xvel;
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
