package Pong;

import java.applet.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;


public class Court extends Applet implements Runnable, KeyListener{
	private int W = 1000, H = 900;
	Thread thread;
	myracket p1;
	CPUracket p2;
	Ball b1;
	boolean gamestarted;
	public void init() {
		this.resize(W,H);
		this.addKeyListener(this);
		b1 = new Ball();
		p1 = new myracket(1);
		p2 = new CPUracket(2, b1);
		
		thread = new Thread(this);
		thread.start();
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, W, H);
		if (b1.GetX() < 0 || b1.GetX() > 1000) {
			g.setColor(Color.RED);
			g.drawString("Game Over", 500, 450);
		}
		else if (!gamestarted) {
			g.setColor(Color.BLUE);
			g.drawString("Press ENTER to play with AI or Press x for 1v1", 500, 450);
			
		}
		else {
			
			p1.draw(g);
			b1.draw(g);
			p2.draw(g);
		}
		
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void run() {
		for (;;) {
			if (gamestarted) {
			p1.move();
			p2.move();
			b1.move();
			b1.ballcollision(p1, p2);
			repaint();
			}
			try {
				Thread.sleep(10);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode () == KeyEvent.VK_UP) {
			p1.setupAccel(true);
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setdownAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			gamestarted = true;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode () == KeyEvent.VK_UP) {
			p1.setupAccel(false);
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setdownAccel(false);
		}
		
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
		
	}

