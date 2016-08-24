import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Board extends JFrame
{
	static Box box[][] = new Box[3][3];
	static JLabel message;
	static String msg;
	
	public Board()
	{
		super("Tic-Tac-Toe");
		this.setSize(440, 440);
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				box[i][j] = new Box();
				add(box[i][j]);
			}
		}
		
		message = new JLabel("Status: X's turn");
		add(message);
		JLabel space = new JLabel("                                                     ");
		add(space);
		JButton reset = new JButton("Reset Game");
		add(reset);
		
		HandlerClass handler = new HandlerClass();
		reset.addActionListener(handler);
	}
	
	public static String status()
	{
		msg = String.format("%c won", Box.turn);
		boolean endgame = false;
		
		if(Box.turndone == 9)
		{
			msg = String.format("%s Match Draw !!!", "Status:");
			endgame = true;
		}
		
		for(int i=0; i<3; i++)
		{
			if( ( (box[i][0].value==box[i][1].value)&&(box[i][0].value==box[i][2].value)&&(box[i][0].value!=' ') ) 
					|| ( (box[0][i].value==box[1][i].value)&&(box[0][i].value==box[2][i].value)&&(box[0][i].value!=' ') ) )
			{
				msg = String.format("%s %c won", "Status:", Box.turn);
				endgame = true;
				break;
			} 
		}
		
		if( ( (box[0][0].value==box[1][1].value)&&(box[0][0].value==box[2][2].value)&&(box[0][0].value!=' ') ) 
				|| ( (box[0][2].value==box[1][1].value)&&(box[0][2].value==box[2][0].value)&&(box[0][2].value!=' ') ) )
		{
			msg = String.format("%s %c won", "Status:", Box.turn);
			endgame = true;
		}
		
		if(!endgame)
		{
			Box.changeTurn();
			msg = String.format("%s %c's turn", "Status:", Box.turn);
		}
		
		if(endgame)
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
					box[i][j].isChangable = false;
			}
			
			Thread endGameMessage = new Thread(){
				@Override
				public void run(){
					JOptionPane msgbox = new JOptionPane();
					msgbox.showMessageDialog(null, msg);
				}
			};
			endGameMessage.start();
		}
		
		message.setText(msg);
		return msg;
	}
	
	private class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					box[i][j].value = ' ';
					box[i][j].setIcon(Box.BLANK);
					box[i][j].isChangable = true;
				}
				
				Box.turn = 'X';
				Box.turndone = 0;
				message.setText("Status: X's turn");
			}
		}
	}
	 
}
