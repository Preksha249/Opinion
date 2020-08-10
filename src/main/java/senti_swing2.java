import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class senti_swing2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					senti_swing2 frame = new senti_swing2();
					frame.setVisible(true);
					
					Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screensize.height;
					int width= screensize.width;
					frame.setSize(width/3, height/3);
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
	public senti_swing2() {
		setForeground(Color.BLACK);
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setBorder(null);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				senti_swing reg=new senti_swing();
				reg.detailregister();
				dispose();
			}
		});
		btnRegister.setBounds(93, 107, 253, 33);
		contentPane.add(btnRegister);
		
		JButton btnAlreadyMember = new JButton("ALREADY A MEMBER");
		btnAlreadyMember.setBorder(null);
		btnAlreadyMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				senti_swing4 it=new senti_swing4();
				it.custnum();
				dispose();
			}
		});
		btnAlreadyMember.setBounds(93, 189, 253, 33);
		contentPane.add(btnAlreadyMember);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 30));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(111, 26, 226, 45);
		contentPane.add(lblWelcome);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255,60));
		panel.setBounds(60, 83, 329, 168);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/piggu/Desktop/bg1.jpeg"));
		lblNewLabel.setBounds(0, 0, 652, 373);
		contentPane.add(lblNewLabel);
	}
}
