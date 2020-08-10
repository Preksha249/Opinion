//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
//import javax.swing.UIManager;
//import javax.swing.UIManager;
//import javax.swing.UIManager;
//import java.awt.Window.Type;
import java.awt.Dimension;



public class negat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void collect() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					negat frame = new negat();
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
	public negat() {
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(500, 500, 500, 500));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/sad.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));		
		lblNewLabel.setBounds(106, 12, 408, 316);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SAD");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(new Color(255, 0, 102));
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Chandas", Font.BOLD, 40));
		lblNewLabel_1.setBounds(157, 372, 316, 52);
		contentPane.add(lblNewLabel_1);
	}
}
