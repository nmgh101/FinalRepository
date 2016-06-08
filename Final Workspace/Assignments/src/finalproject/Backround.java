package finalproject;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import static java.lang.Character.*;

import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Backround extends Canvas implements KeyListener, Runnable
{
	private Player player;
	public boolean menuStart = false;
	Font tr = new Font("TimesRoman", Font.PLAIN, 35);
	private KeyObject key;
	private Random rn = new Random();
	private ExitObj exit;
	private int n;
	private int i;
	private int keyX;
	private int keyY;
	private int score = 0;
	private Image image;
	private boolean check = false;
	private boolean gameWin = false;

	/* uncomment once you are ready for this part
	 *
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	*/

	private boolean[] keys;
	private BufferedImage back;

	public Backround()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff

		player = new Player(0,300,5);
		
		n = 751;
		i = rn.nextInt() % n;
		
		while(i < 0)
		{
			i = rn.nextInt() % n;
		}
		
		keyX = i;
		System.out.println("Key x is " + keyX);
		
		n = 551;

		i = rn.nextInt() % n;
		
		while(i < 0)
		{
			i = rn.nextInt() % n;
		}
		
		keyY = i;
		System.out.println("Key y is " + keyY);

		key = new KeyObject(keyX,keyY);
		
		exit = new ExitObj(700,300);
		
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		if(gameWin == false)
		{
		graphToBack.setColor(Color.magenta);
		graphToBack.setFont(tr);
		graphToBack.drawString("Jesse Belinsky's final project", 190, 130);
		graphToBack.drawString("Arrow keys to move.", 240, 230);
		graphToBack.drawString("Collect seven keys to unlock the exit!", 140, 330);
		graphToBack.drawString("Press S to start.", 275, 430);
		}
		else
		{
			if(check == false)
			{
				graphToBack.setColor(Color.WHITE);
				graphToBack.fillRect(0,0,800,600);
				check = true;
			}
			graphToBack.setColor(Color.black);
			graphToBack.setFont(tr);
			graphToBack.drawString("You Win!", 325, 300);
		}
		

		if(keys[4] == true)
		{
			menuStart = true;
		}
		
		if(menuStart == true && gameWin == false)
		{
			graphToBack.setColor(Color.WHITE);
			graphToBack.fillRect(0,0,800,600);
			//System.out.println("Player x = " + ship.getX() + " Player y = " + ship.getY());
		
			if(keys[0] == true)
			{
				if(player.getX()>-0)
					player.move("LEFT");
			}
		
			if(keys[1] == true)
			{
				if(player.getX()<this.getWidth()-30)
					player.move("RIGHT");
			}
		
			if(keys[2] == true)
			{
				if(player.getY()>-0)
					player.move("UP");
			}
		
			if(keys[3] == true)
			{
				if(player.getY()<this.getHeight()-31)
					player.move("DOWN");
			}
		
			
			if(key != null)
			{
				if((player.getX() > (key.getX() - 15) && player.getY() > (key.getY() - 15) 
					&& player.getX() < (key.getX() + 15) && player.getY() < (key.getY() + 15)))
			{
				System.out.println("Touching");
				
				n = 751;

				i = rn.nextInt() % n;
				
				while(i < 0)
				{
					i = rn.nextInt() % n;
				}
				
				keyX = i;
				
				n = 551;

				i = rn.nextInt() % n;
				
				while(i < 0)
				{
					i = rn.nextInt() % n;
				}
				
				keyY = i;
				
				key = new KeyObject(keyX, keyY);
				
				System.out.println("Key x is " + keyX + " And key y is " + keyY);
				
				score ++;
			}
			}
			
		
			if(score > 6)
			{
				
				if(player.getX() > (exit.getX() - 30) && player.getY() > (exit.getY() - 30) 
						&& player.getX() < (exit.getX() + 30) && player.getY() < (exit.getY() + 30))
						{
							gameWin = true;

						}
			}

		//add code to move stuff

		
		
		//add in collision detection
			if(score < 7)
			{
				key.draw(graphToBack);
			}
			else
			{
				key = null;
			}
			
			player.draw(graphToBack);
			
						
			if(score > 6)
			{
				exit.draw(graphToBack);
			}
			
			
			
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
		
		
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

