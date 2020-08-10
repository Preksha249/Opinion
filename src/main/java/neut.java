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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import javax.swing.UIManager;


public class neut extends JFrame {

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
					neut frame = new neut();
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
	public neut() {
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 523);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(500, 500, 500, 500));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/nuetral.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));		
		lblNewLabel.setBounds(106, 12, 408, 316);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SATISFIED");
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Chandas", Font.BOLD, 40));
		lblNewLabel_1.setBounds(157, 372, 316, 52);
		contentPane.add(lblNewLabel_1);
	}
}
