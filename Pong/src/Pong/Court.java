package Pong;

import java.applet.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;


public class Court extends Applet implements Runnable, KeyListener{
	private int W = 1000, H = 900;
	Thread thread;
	mypaddle p1;
	public void init() {
		this.resize(W,H);
		p1 = new mypaddle(1);
		this.addKeyListener(this);
		thread = new Thread(this);
		thread.start();
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, W, H);
		p1.draw(g);
		
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void run() {
		for (;;) {
			p1.move();
			
			repaint();
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
		
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode () == KeyEvent.VK_UP) {
			p1.setupAccel(false);
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setdownAccel(false);
		}
		
		
	}
	
	
		
	}

