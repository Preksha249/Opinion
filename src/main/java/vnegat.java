//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Font;


public class vnegat extends JFrame {

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
					vnegat frame = new vnegat();
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
	public vnegat() {
		
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 523);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("OptionPane.warningDialog.titlePane.background"));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/angry.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));		
		lblNewLabel.setBounds(106, 12, 408, 316);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DISAPPOINTED");
		lblNewLabel_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Chandas", Font.BOLD, 40));
		lblNewLabel_1.setBounds(132, 372, 367, 52);
		contentPane.add(lblNewLabel_1);
	}
}
