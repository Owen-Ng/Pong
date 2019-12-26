package Pong;

import java.applet.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;


public class Court extends Applet implements Runnable, KeyListener{
	private int W = 1000, H = 900;
	Thread thread;
	myracket p1;
	CPUracket p2;
	Ball b1;
	Player2 h2;
	boolean gamestarted;
	boolean onev1;
	public void init() {
		this.resize(W,H);
		this.addKeyListener(this);
		b1 = new Ball();
		p1 = new myracket(1);
		p2 = new CPUracket(2, b1);
		h2 = new Player2(2);
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
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
			g.drawString("Press ENTER to play with AI", 260, 470);
			
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 35)); 
			g.drawString("Press x for 1v1", 285, 520);
		
		}
		else {
			if (!onev1) {
			p1.draw(g);
			b1.draw(g);
			p2.draw(g);
			
			}
			else {
				p1.draw(g);
				b1.draw(g);
				h2.draw(g);
			}
		}
		
	}
	public void update(Graphics g) {
		paint(g);
	}
	public void run() {
		for (;;) {
			if (gamestarted) {
				if(onev1) {
					p1.move();
					h2.move();
					b1.move();
					b1.ballcollision(p1, h2);
					repaint();
				}
				else {
			p1.move();
			p2.move();
			b1.move();
			b1.ballcollision(p1, p2);
			repaint();
				}
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
		else if (e.getKeyCode() == KeyEvent.VK_W) {
			h2.setupAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			h2.setdownAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setdownAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			gamestarted = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_X) {
			gamestarted = true;
			onev1 = true;
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode () == KeyEvent.VK_UP) {
			p1.setupAccel(false);
			
		}
		else if (e.getKeyCode () == KeyEvent.VK_W) {
			h2.setupAccel(false);
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_S) {
			h2.setdownAccel(false);
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

