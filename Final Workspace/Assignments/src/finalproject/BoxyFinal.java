package finalproject;
//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class BoxyFinal extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public BoxyFinal()
	{
		super("BOXYFINAL");
		setSize(WIDTH,HEIGHT);

		Backround theGame = new Backround();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		BoxyFinal run = new BoxyFinal();
	}
}