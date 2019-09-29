package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class mypaddle implements racket{
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double GRAVITY = 0.04;
	
	public mypaddle (int player) {
		upAccel = false;
		downAccel = false;
		y = 210; yVel = 0;
		if (player == 1)
			x = 20;
		else
			x = 540;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x,(int) y, 20, 80);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		if (upAccel) {
			yVel -= 1;
		}
		else if (downAccel) {
			yVel += 1;
		}
		else if (!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
		y += yVel;
		}
		
	
	public void setupAccel(boolean input) {
		upAccel = input;
	}
	public void setdownAccel(boolean input) {
		downAccel = input;
	}
	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return (int) y;
	}

}
