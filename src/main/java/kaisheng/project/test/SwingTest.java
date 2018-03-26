package kaisheng.project.test;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SwingTest extends JFrame{

	
	private static final long serialVersionUID = 1L;
	
		//JButton resButton = new JButton("0");
		
		JTextField res = new JTextField("0");
		JPanel jPane = new JPanel();
		
		
		public SwingTest(){
			this.setLayout(new BorderLayout());
			
			this.add(jPane,BorderLayout.CENTER);
			this.add(res,BorderLayout.NORTH);
			
			GridLayout gridLayout = new GridLayout(4, 4,3,3);
			jPane.setLayout(gridLayout);
			
			String [] buttonNames = new String []{"7", "8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
			
			for(int i = 0;i < buttonNames.length;i++){
				JButton btn = new JButton(buttonNames[i]);
				System.out.println(btn.getText());
				jPane.add(btn);
			}
			
			pack();
	        setTitle("我的计算器");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        
	        
	        res.setSize(200, 50);
	        res.setHorizontalAlignment(SwingConstants.RIGHT);
	        res.setEnabled(false); 
		}
		
	public static void main(String[] args){
		SwingTest test = new SwingTest();
		
		test.setVisible(true);
	}	
	
}
