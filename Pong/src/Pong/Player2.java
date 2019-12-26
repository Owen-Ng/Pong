package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Player2 implements racket{

	double y, yvel;
	boolean upAccel, downAccel;
	int player, x;
	final double gravity = 0.5;
	
	public Player2 (int player) {
		upAccel = false;
		downAccel = false;
		y = 210; yvel = 0;
		if (player == 1)
			x = 20;
		else
			x = 940;
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x,(int) y, 20, 80);
		// TODO Auto-generated method stub
		
	}

	
	public void move() {
		// TODO Auto-generated method stub
		if (upAccel) {
			yvel -= 1;
		}
		else if (downAccel) {
			yvel += 1;
		}
		else if (!upAccel && !downAccel) {
			yvel *= gravity;
		}
		y += yvel;
		if (y< 50) {
			y = 50;
		
		}
		else if (y>800) {
		y = 800;
	}
		if (yvel >4) {
			yvel = 4;
		}
		else if (yvel <-4) {
			yvel = -4;
		}
	}
		
	
	public void setupAccel(boolean input) {
		upAccel = input;
	}
	public void setdownAccel(boolean input) {
		downAccel = input;
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return (int) y;
	}

}
