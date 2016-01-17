import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Box extends JButton
{
	static byte turn='X';
	static final Icon BLANK = new ImageIcon(Box.class.getResource("BLANK.png"));
	static final Icon X = new ImageIcon(Box.class.getResource("X.png"));
	static final Icon O = new ImageIcon(Box.class.getResource("O.png"));
	
	public boolean isChangable = true;
	public byte value = ' ';
	
	public Box()
	{
		super();
		this.setIcon(BLANK);
		
		HandlerClass handler = new HandlerClass();
		this.addActionListener(handler);
	}
	
	static public void changeTurn()
	{
		if(turn == 'X') turn = 'O';
		else turn ='X';
	}
	
	public void setSign()
	{
		if(isChangable)
		{
			if(turn=='X') this.setIcon(X);
			else this.setIcon(O);
			isChangable = false;
			value = turn;
		}
	}
	
	private class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			setSign();
			Board.status();
		}
	}
}
