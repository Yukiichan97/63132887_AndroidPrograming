import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Activity extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtTK;
    private JTextField txtMK;
    private boolean _txtTKChanged;
    private boolean _txtMKChanged;

	/**
     * Create the frame.
     */
	public Activity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbTK = new JLabel("Nhập chuỗi:");
		lbTK.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		lbTK.setBounds(39, 45, 214, 31);
		contentPane.add(lbTK);

		JLabel lbMK = new JLabel("Nhập mã Morse:");
		lbMK.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		lbMK.setBounds(39, 110, 214, 31);
		contentPane.add(lbMK);

		txtTK = new JTextField();
		txtTK.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		txtTK.setColumns(10);
		txtTK.setBounds(285, 45, 214, 31);
		contentPane.add(txtTK);

		txtMK = new JTextField();
		txtMK.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		txtMK.setColumns(10);
		txtMK.setBounds(285, 110, 214, 31);
		contentPane.add(txtMK);

		txtTK.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				convert();
			}
			public void removeUpdate(DocumentEvent e) {
				convert();
			}
			public void insertUpdate(DocumentEvent e) {
				convert();
			}

			public void convert() {
				if(!_txtMKChanged){
					_txtTKChanged = true;
					String txtTK_str = txtTK.getText();
					String txtMK_str = Morse.stringToMorseCode(txtTK_str);
					txtMK.setText(txtMK_str);
					_txtTKChanged = false;
				}
			}
		});

		txtMK.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				convert();
			}
			public void removeUpdate(DocumentEvent e) {
				convert();
			}
			public void insertUpdate(DocumentEvent e) {
				convert();
			}

			public void convert() {
				if(!_txtTKChanged){
					_txtMKChanged = true;
					String txtMK_str = txtMK.getText();
					String txtTK_str = Morse.morseCodeToString(txtMK_str);
					txtTK.setText(txtTK_str);
					_txtMKChanged = false;
				}
			}
		});
	}
}