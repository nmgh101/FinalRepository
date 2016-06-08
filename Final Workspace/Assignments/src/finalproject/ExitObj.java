package finalproject;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.File;

import javax.imageio.ImageIO;

public class ExitObj extends MovingThing
{
	private int speed;
	private int locX;
	private int locY;
	private Image image;
	
	public ExitObj()
	{
		this(0,0,0);
	}

	public ExitObj(int x, int y)
	{
		this(x,y,0);
		//add code
	}

	public ExitObj(int x, int y, int s)
	{
		setPos(x,y);
		setSpeed(s);
		//add code
		try
		{
			image = ImageIO.read(new File("src/finalproject/exit.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Not getting exit file");
		}
	}

	public void setSpeed(int s)
	{
	   speed = s;	
	}

	public int getSpeed()
	{
	   return speed;
	}
	
	public void draw( Graphics window )
	{		//add code to draw the ammo
		window.drawImage(image ,getX(),getY(),40,40,null);
	}

}
