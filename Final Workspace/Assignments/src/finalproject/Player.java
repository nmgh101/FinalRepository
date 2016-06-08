package finalproject;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;

import javax.imageio.ImageIO;

public class Player extends MovingThing
{
	private int speed;
	private Image image;

	public Player()
	{
		this(0,0,0);
	}

	public Player(int x, int y)
	{
		this(x,y,0);
	}

	public Player(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/finalproject/Color-yellow.JPG"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			//feel free to do something here
		}
	}


	public void setSpeed(int s)
	{
		speed = s;
	   //add more code
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),30,30,null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
