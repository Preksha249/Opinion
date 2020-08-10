import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import edu.stanford.nlp.sentiment.SentimentUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
//import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;

//import javax.swing.ImageIcon;
//import javax.swing.UIManager;
//import java.awt.Color;

public class senti_swing5 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fbspace;
	JTextField cid;

	/**
	 * Launch the application.
	 */
	public void feedback() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					senti_swing5 frame = new senti_swing5();
					frame.setVisible(true);
					
					 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
						int height = screensize.height;
						int width= screensize.width;
						frame.setSize(width/3, height/2);
						frame.setLocationRelativeTo( null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public senti_swing5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFeedback = new JLabel("FEEDBACK");
		lblFeedback.setBackground(new Color(0, 0, 0));
		lblFeedback.setForeground(new Color(0, 0, 0));
		lblFeedback.setFont(new Font("Century Schoolbook L", Font.BOLD | Font.ITALIC, 46));
		lblFeedback.setBounds(150, 25, 302, 84);
		contentPane.add(lblFeedback);
		
		fbspace = new JTextField();
		fbspace.setBackground(new Color(192, 192, 192));
		fbspace.setBounds(90, 167, 408, 202);
		contentPane.add(fbspace);
		fbspace.setColumns(10);
		
		cid = new JTextField();
		cid.setBackground(new Color(176, 196, 222));
		cid.setFont(new Font("Dialog", Font.PLAIN, 15));
		cid.setBounds(43, 84, 55, 30);
		contentPane.add(cid);
		cid.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(29, 69, 70, 15);
		contentPane.add(lblId);
		
		JLabel lblTypeYourFeedback = new JLabel("Type your feedback here....");
		lblTypeYourFeedback.setFont(new Font("Dialog", Font.ITALIC, 14));
		lblTypeYourFeedback.setBounds(43, 140, 240, 15);
		contentPane.add(lblTypeYourFeedback);
		
		final JButton BTnButton = new JButton("SUBMIT");
		BTnButton.setBackground(new Color(176, 196, 222));
		BTnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cnm = cid.getText();
				String fb = fbspace.getText();
		          
				 try {
	                	Class.forName("com.mysql.jdbc.Driver");
	        			
	        			/* Create connection url. */
	        			String mysqlConnUrl = "jdbc:mysql://localhost:3306/test";
	        			
	        			/* db user name. */
	        			String mysqlUserName = "root";
	        			
	        			/* db password. */
	        			String mysqlPassword = "prek2499";
	        			
	        			/* Get the Connection object. */   
	                	              	
	 	              	
	                    Connection connection = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
	                    Statement sta = connection.createStatement();
	                    
	               
	                    
	                   String queryy = "INSERT INTO feedback(feedback,cusn) values('" + fb + "','" + cnm + "')";
                         
	                 //  insert into feedback(feedback,cusn) values('verynice',40);

	                   
	                   @SuppressWarnings("unused")
					int u = sta.executeUpdate(queryy);
	                   JOptionPane.showMessageDialog(BTnButton, "THANK YOU. VISIT AGAIN!"); 
	                
	                   String s=fbspace.getText();
	                   SentimentAnalysis sa=new SentimentAnalysis();
	                   sa.sentiana(s);
	                   dispose();
	         
	                         
	                       	
	                  //  }
	                    connection.close();
	                } catch (Exception exception) {
	         
	                	exception.printStackTrace();
	                }			
				
			}
		});
		BTnButton.setBounds(443, 404, 138, 30);
		contentPane.add(BTnButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/piggu/Desktop/fbb.png"));
		lblNewLabel.setBounds(443, 35, 64, 59);
		contentPane.add(lblNewLabel);
	}
}
