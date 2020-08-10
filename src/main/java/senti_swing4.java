

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
//import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
//import javax.swing.JSeparator;

//import javax.swing.UIManager;

public class senti_swing4 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField custnum;
	protected String btnNewButton;

	/**
	 * Launch the application.
	 */
	public void custnum() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					senti_swing4 frame = new senti_swing4();
					frame.setVisible(true);
					
					 Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
						int height = screensize.height;
						int width= screensize.width;
						frame.setSize(width/4, height/3);
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
	public senti_swing4() {
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel enternum = new JLabel("ENTER REGISTER NUMBER");
		enternum.setHorizontalAlignment(SwingConstants.CENTER);
		enternum.setFont(new Font("Abyssinica SIL", Font.BOLD, 23));
		enternum.setForeground(new Color(255, 255, 255));
		enternum.setBackground(Color.WHITE);
		enternum.setBounds(70, 23, 328, 34);
		contentPane.add(enternum);
		
		custnum = new JTextField();
		custnum.setFont(new Font("Dialog", Font.PLAIN, 17));
		custnum.setHorizontalAlignment(SwingConstants.CENTER);
		custnum.setBounds(152, 174, 185, 34);
		contentPane.add(custnum);
		custnum.setColumns(10);
		System.out.println(custnum);
		
		
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setBackground(UIManager.getColor("InternalFrame.borderDarkShadow"));
		btnEnter.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent E) {
				String cnm = custnum.getText();
		          
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
	                    
	                   // System.out.println("till here");
	                    
	                    String squer="select * from customer where cusn='" + cnm + "'";
	           //  String ans = null;
	           //  do {
	                    ResultSet z=sta.executeQuery(squer);
	             
	                   
	                   // int x = sta.executeUpdate(query);
	                    if (z.next()==true) {
	                    	
	                    	senti_swing3 it=new senti_swing3();
	                    	it.regn.setText(cnm);
	                    	it.setVisible(true);
	                    	dispose();   
	                    	
	                    }
	                       
	                    else {  
	                    	JOptionPane.showMessageDialog(contentPane,"not registered");
	                    	senti_swing reg=new senti_swing();
	        				reg.detailregister();
	        				dispose();
	        				JOptionPane.showMessageDialog(contentPane,"Please do register");
	                  
	                     dispose();
	                    
	                    } //ans=JOptionPane.showInputDialog(contentPane,"want to continue?");
	                    
	            // }while(ans=="YES" || ans=="yes");
	                    	
	                  //  }
	                    connection.close();
	                } catch (Exception exception) { JOptionPane.showMessageDialog(contentPane,"Please enter your id number");
	                    exception.printStackTrace();
	                }
	            				
				
			}
		});
		btnEnter.setBounds(177, 232, 133, 34);
		contentPane.add(btnEnter);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/piggu/Desktop/user.png"));
		lblNewLabel.setBackground(new Color(255, 165, 0));
		lblNewLabel.setBounds(184, 71, 126, 85);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/home/piggu/Desktop/long.png"));
		lblNewLabel_1.setBounds(0, 0, 486, 368);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
