

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

/**
 * User Registration using Swing
 * @author javaguides.net
 * @param <UserLog>
 *
 */
public class senti_swing3 extends JFrame {
    private static final long serialVersionUID = 1L;
	public String JTextField;;
    private JPanel contentPane;
    private JTextField itemcode;
    private JTextField itemname;
    private JTextField date;
    private JButton btnNewButton;
    JTextField regn;
  

    /**
     * Launch the application.
     */
    public void itemdet() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    senti_swing3 frame = new senti_swing3();
                    frame.setVisible(true);
                    
                    Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screensize.height;
					int width= screensize.width;
					frame.setSize(width/2, height/2);
					frame.setLocationRelativeTo( null);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param <UserLogin>
     */
    private void clearfield()
	{     
    	itemcode.setText(null);;
    	itemname.setText(null);
    	date.setText(null);
    	
	}

    public senti_swing3() {
    	setBackground(new Color(192, 192, 192));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 250, 921, 595);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("ITEMS");
        lblNewUserRegister.setForeground(Color.WHITE);
        lblNewUserRegister.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
        lblNewUserRegister.setBounds(342, 12, 116, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("ITEM CODE");
        lblName.setForeground(Color.WHITE);
        lblName.setFont(new Font("Abyssinica SIL", Font.BOLD | Font.ITALIC, 17));
        lblName.setBounds(111, 149, 126, 36);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("ITEM NAME ");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setFont(new Font("Abyssinica SIL", Font.BOLD | Font.ITALIC, 17));
        lblNewLabel.setBounds(111, 266, 116, 29);
        contentPane.add(lblNewLabel);

        itemcode = new JTextField();
        itemcode.setFont(new Font("Tahoma", Font.PLAIN, 25));
        itemcode.setBounds(111, 185, 259, 36);
        contentPane.add(itemcode);
        itemcode.setColumns(10);

        itemname = new JTextField();
        itemname.setFont(new Font("Tahoma", Font.PLAIN, 25));
        itemname.setBounds(111, 294, 259, 36);
        contentPane.add(itemname);
        itemname.setColumns(10);
        
                JLabel lblUsername = new JLabel("DATE");
                lblUsername.setForeground(new Color(255, 255, 255));
                lblUsername.setFont(new Font("Abyssinica SIL", Font.BOLD | Font.ITALIC, 17));
                lblUsername.setBounds(111, 373, 77, 29);
                contentPane.add(lblUsername);

        date = new JTextField();
        date.setFont(new Font("Tahoma", Font.PLAIN, 25));
        date.setBounds(111, 403, 259, 36);
        contentPane.add(date);
        date.setColumns(10);
        
        JLabel lblRegNum = new JLabel("REG NUM");
        lblRegNum.setFont(new Font("Dyuthi", Font.BOLD, 14));
        lblRegNum.setForeground(new Color(255, 255, 255));
        lblRegNum.setBounds(28, 68, 77, 29);
        contentPane.add(lblRegNum);
        
        regn = new JTextField();
        regn.setFont(new Font("Dialog", Font.BOLD, 15));
        regn.setBounds(103, 65, 77, 29);
        contentPane.add(regn);
        regn.setColumns(10);

        btnNewButton = new JButton("ENTER THE ITEM");
        btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, null));
        btnNewButton.addActionListener(new ActionListener() {
           
			//private int x;
			//private String query;

        	public void actionPerformed(ActionEvent e) {
                String icode = itemcode.getText();
                String iname = itemname.getText();
                String custnum = regn.getText();
               // String emailId = email.getText();
                String dat = date.getText();
               // String mobileNumber = mob.getText();
               // int len = mobileNumber.length();
               // String password = passwordField.getText();

          /*      String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }
          */ 
               
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
                    
                   
					String selqu="select * from customer where cusn='" + custnum + "'";
             
                    ResultSet t=sta.executeQuery(selqu);
                    
                 //   String query = "INSERT INTO account values('" + firstName + "','" + lastName + "','" + userName + "','" +
                   //     password + "','" + emailId + "','" + mobileNumber + "')";

                   
                   // int x = sta.executeUpdate(query);
                    if (t.next()==true) {
                    	
                    	String querrr= "INSERT INTO item values('" + icode + "','" + iname + "','" + dat + "','" + custnum+ "')";
                    	sta.executeUpdate(querrr);
                    	 clearfield();
                        JOptionPane.showMessageDialog(btnNewButton,
                             "Your item is sucessfully entered");
                        pause(300);
                        
                        
                    }
                    
                                                          
                    else {  JOptionPane.showMessageDialog(btnNewButton, "not registered");
                    
                                        
                    } pause(1000);
                    JOptionPane.showMessageDialog(btnNewButton,
                            "Kindly give feedback :)");
                    	
                  //  }
                    connection.close();
                } catch (Exception exception) { JOptionPane.showMessageDialog(btnNewButton, "enter the correct item details please");
                    exception.printStackTrace();
                }
            }

			private void pause(int i) {
				// TODO Auto-generated method stub
				
			}
        });
        btnNewButton.setFont(new Font("Dialog", Font.ITALIC, 20));
        btnNewButton.setBounds(564, 313, 239, 36);
        btnNewButton.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
        contentPane.add(btnNewButton);
        
        JButton btnFeedback = new JButton("FEEDBACK");
        btnFeedback.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, null));
        btnFeedback.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		
        		
        		
                senti_swing5 feed=new senti_swing5();
            	feed.feedback();
            	//it.setVisible(true);
            	dispose();
        		
        		
        	}
        });
        btnFeedback.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
        btnFeedback.setBounds(575, 476, 213, 42);
        contentPane.add(btnFeedback);
        
        JLabel lblKindlyGiveYour = new JLabel("kindly give your feedback :)");
        lblKindlyGiveYour.setForeground(Color.DARK_GRAY);
        lblKindlyGiveYour.setFont(new Font("Dialog", Font.BOLD, 15));
        lblKindlyGiveYour.setBounds(552, 429, 236, 27);
        contentPane.add(lblKindlyGiveYour);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setOpaque(true);
        lblNewLabel_2.setIcon(new ImageIcon("/home/piggu/Desktop/item.jpg"));
        lblNewLabel_2.setBounds(0, 0, 456, 569);
        contentPane.add(lblNewLabel_2);
        
        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(564, 109, 241, 205);
        panel.setBackground(new Color(218, 165, 32,70));
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(100, 74, 118, 116);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon("/home/piggu/Desktop/bag.png"));
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("/home/piggu/Desktop/buy.png"));
        lblNewLabel_3.setBounds(22, 36, 118, 134);
        panel.add(lblNewLabel_3);
        
        JLabel lblBought = new JLabel("BOUGHT");
        lblBought.setForeground(new Color(210, 105, 30));
        lblBought.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
        lblBought.setBounds(464, 12, 151, 50);
        contentPane.add(lblBought);
        
      
    }
}
