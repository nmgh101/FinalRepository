package finalproject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class KeyObject extends MovingThing {
	

	private int speed;
	private Image image;

	public KeyObject()
	{
		this(0,0,0);
	}

	public KeyObject(int x, int y)
	{
		this(x,y,0);
	}

	public KeyObject(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/finalproject/key.JPG"));
		}
		catch(Exception e)
		{
			System.out.println("Not getting key file");
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
	{
   	window.drawImage(image,getX(),getY(),20,20,null);
	}

	public String toString()
	{
		return "";
	}

}
