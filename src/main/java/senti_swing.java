

import java.awt.EventQueue;
import java.awt.Font;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
//import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;


/**
 * User Registration using Swing
 * @author javaguides.net
 * @param <UserLog>
 *
 */
public class senti_swing extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField regnum;
    private JTextField lastname;
    private JTextField email;
    private JTextField firstname;
    private JTextField mob;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public void detailregister() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    senti_swing frame = new senti_swing();
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

    public senti_swing() {
    	
    /*	JLabel background;
    	setSize(800,500);
    	setLayout(null);
    	ImageIcon img = new ImageIcon("/home/piggu/Desktop/BG2.jpg");
    	
    	background = new JLabel("",img,JLabel.CENTER);
    	background.setBounds(0,0,800,500);
    	add(background);
    	setVisible(true); */
    	
    	//setBackground(Color.GRAY);
        setIconImage(Toolkit.getDefaultToolkit().getImage("/home/piggu/Desktop/BG2.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 230, 140));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("REGISTER");
        lblNewUserRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewUserRegister.setFont(new Font("Dyuthi", Font.BOLD, 30));
        lblNewUserRegister.setBounds(132, 12, 145, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("REGISTER NUMBER");
        lblName.setFont(new Font("Dialog", Font.ITALIC, 15));
        lblName.setBounds(80, 66, 208, 30);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("LAST NAME");
        lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 15));
        lblNewLabel.setBounds(80, 153, 156, 25);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\rID");
        lblEmailAddress.setFont(new Font("Dialog", Font.ITALIC, 15));
        lblEmailAddress.setBounds(80, 394, 65, 30);
        contentPane.add(lblEmailAddress);
        
                JLabel lblUsername = new JLabel("FIRST NAME");
                lblUsername.setFont(new Font("Dialog", Font.ITALIC, 15));
                lblUsername.setBounds(80, 233, 124, 29);
                contentPane.add(lblUsername);

        regnum = new JTextField();
        regnum.setOpaque(false);
        regnum.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        regnum.setFont(new Font("aakar", Font.PLAIN, 18));
        regnum.setBounds(73, 95, 290, 36);
      //  regnum.setBackground(arg0);
        contentPane.add(regnum);
        regnum.setColumns(10);

        lastname = new JTextField();
        lastname.setOpaque(false);
        lastname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
       // lastname.setHorizontalAlignment(SwingConstants.CENTER);
        lastname.setFont(new Font("aakar", Font.PLAIN, 18));
        lastname.setBounds(73, 177, 290, 36);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setOpaque(false);
        email.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

        email.setFont(new Font("aakar", Font.PLAIN, 18));
        email.setBounds(73, 423, 290, 36);
        contentPane.add(email);
        email.setColumns(10);

        firstname = new JTextField();
        firstname.setOpaque(false);
        firstname.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        firstname.setFont(new Font("aakar", Font.PLAIN, 18));
        firstname.setBounds(73, 259, 290, 36);
        contentPane.add(firstname);
        firstname.setColumns(10);

        JLabel lblMobileNumber = new JLabel("MOBILE NUMBER");
        lblMobileNumber.setFont(new Font("Dialog", Font.ITALIC, 15));
        lblMobileNumber.setBounds(80, 351, 176, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setOpaque(false);
        mob.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        mob.setFont(new Font("aakar", Font.PLAIN, 18));
        mob.setBounds(73, 341, 290, 36);
        contentPane.add(mob);
        mob.setColumns(10);

        btnNewButton = new JButton("Register");
        btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.WHITE, new Color(255, 255, 255), null, null));
        btnNewButton.addActionListener(new ActionListener() {
           
			//private int x;
			//private String query;

			public void actionPerformed(ActionEvent e) {
                String rnum = regnum.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String firstName = firstname.getText();
                String mobileNumber = mob.getText();
             int len = mobileNumber.length();
               // String password = passwordField.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

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
                    
                    
                    String selectqu="select * from customer where cusn='" + rnum + "'and fname='" + firstName + "'and lname='" + lastName + "'";
                    ResultSet l=sta.executeQuery(selectqu);
                    
                
                   //int x = sta.executeUpdate(que);
                    if (l.next()==true) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy Registered");
                       // pause(50);
                        senti_swing3 it=new senti_swing3();
                    	it.regn.setText(rnum);
                    	it.setVisible(true);
                    	dispose();   
                        
                    } 
                  //  else if(x.next()==n)
                   // {JOptionPane.showMessageDialog(btnNewButton, "please enter the values"); }
                    else {
                    	
                    	if (len != 10) {
                            JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                        }
                    	else {
                    	String querrr= "INSERT INTO customer values('" + rnum + "','" + lastName + "','" + firstName + "','" + mobileNumber+ "','" +emailId   + "')";
                    	sta.executeUpdate(querrr);
                    	
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "! Your account is sucessfully created");
                        
                        senti_swing3 it=new senti_swing3();
                    	it.regn.setText(rnum);
                    	it.setVisible(true);
                    	dispose(); 
                    	}
                    }
                    connection.close();
                } catch (Exception exception) {  JOptionPane.showMessageDialog(btnNewButton, "Please enter the details");
                    exception.printStackTrace();
                }
            }

		
        });
        btnNewButton.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
        btnNewButton.setBounds(617, 373, 259, 50);
        btnNewButton.setBackground(new Color(154, 205, 50));
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon("/home/piggu/Desktop/regi.png"));
        lblNewLabel_2.setBounds(681, 244, 135, 106);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(0, 100, 0));
        lblNewLabel_1.setOpaque(false);
        lblNewLabel_1.setIcon(new ImageIcon("/home/piggu/Desktop/pawn.jpg"));
        lblNewLabel_1.setBackground(new Color(0, 100, 0));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(470, 0, 544, 571);
        contentPane.add(lblNewLabel_1);
        
        JPanel panel = new JPanel();
        panel.setBounds(470, 0, 544, 571);
        contentPane.add(panel);
    }
}
