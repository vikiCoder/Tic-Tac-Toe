import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class Board extends JFrame
{
	static Box box[][] = new Box[3][3];
	static JLabel message;
	
	public Board()
	{
		super("Tic-Tac-Toe");
		this.setSize(440, 440);
		setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				box[i][j] = new Box();
				add(box[i][j]);
			}
		}
		
		message = new JLabel("X's turn");
		add(message);
	}
	
	public static String status()
	{
		String msg = String.format("%c won", Box.turn);
		boolean endgame = false;
		
		for(int i=0; i<3; i++)
		{
			if( ( (box[i][0].value==box[i][1].value)&&(box[i][0].value==box[i][2].value)&&(box[i][0].value!=' ') ) 
					|| ( (box[0][i].value==box[1][i].value)&&(box[0][i].value==box[2][i].value)&&(box[0][i].value!=' ') ) )
			{
				msg = String.format("%c won", Box.turn);
				endgame = true;
				break;
			} 
		}
		
		if( ( (box[0][0].value==box[1][1].value)&&(box[0][0].value==box[2][2].value)&&(box[0][0].value!=' ') ) 
				|| ( (box[0][2].value==box[1][1].value)&&(box[0][2].value==box[2][0].value)&&(box[0][2].value!=' ') ) )
		{
			msg = String.format("%c won", Box.turn);
			endgame = true;
		}
		
		if(!endgame)
		{
			Box.changeTurn();
			msg = String.format("%c's turn", Box.turn);
		}
		
		if(endgame)
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
					box[i][j].isChangable = false;
			}
		}
		
		message.setText(msg);
		return msg;
	}
	 
}
