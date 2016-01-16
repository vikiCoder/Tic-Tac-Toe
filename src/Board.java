import javax.swing.JFrame;

import java.awt.Component;
import java.awt.FlowLayout;

public class Board extends JFrame
{
	Box box[] = new Box[9];
	
	public Board()
	{
		super("Tic-Tac-Toe");
		this.setSize(440, 390);
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=0; i<9; i++)
		{
			box[i] = new Box();
			add(box[i]);
		}
	}
}
