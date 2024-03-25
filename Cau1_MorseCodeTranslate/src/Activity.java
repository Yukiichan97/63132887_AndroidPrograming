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
    private JTextField txtChuoi;
    private JTextField txtMorseCode;
    private boolean _txtTKChanged;
    private boolean _txtMKChanged;

	/**
     * Create the frame.
     */
	public Activity() {
		setTitle("Máy dịch mã Morse theo thời gian thực");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbChuoi = new JLabel("Nhập chuỗi:");
		lbChuoi.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		lbChuoi.setBounds(39, 45, 214, 31);
		contentPane.add(lbChuoi);

		JLabel lbMorseCode = new JLabel("Nhập mã Morse:");
		lbMorseCode.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		lbMorseCode.setBounds(39, 110, 214, 31);
		contentPane.add(lbMorseCode);

		txtChuoi = new JTextField();
		txtChuoi.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		txtChuoi.setColumns(10);
		txtChuoi.setBounds(285, 45, 214, 31);
		contentPane.add(txtChuoi);

		txtMorseCode = new JTextField();
		txtMorseCode.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		txtMorseCode.setColumns(10);
		txtMorseCode.setBounds(285, 110, 214, 31);
		contentPane.add(txtMorseCode);
		
		JLabel txtMSSV = new JLabel("MSSV: 63132887");
		txtMSSV.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		txtMSSV.setBounds(39, 178, 214, 31);
		contentPane.add(txtMSSV);
		
		JLabel txtHoVaTen = new JLabel("Họ và tên: Phạm Nguyễn Hoài Minh");
		txtHoVaTen.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
		txtHoVaTen.setBounds(285, 178, 334, 31);
		contentPane.add(txtHoVaTen);

		txtChuoi.getDocument().addDocumentListener(new DocumentListener() {
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
					String txtTK_str = txtChuoi.getText();
					String txtMK_str = Morse.stringToMorseCode(txtTK_str);
					txtMorseCode.setText(txtMK_str);
					System.out.println("changed");
					_txtTKChanged = false;
				}
			}
		});

		txtMorseCode.getDocument().addDocumentListener(new DocumentListener() {
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
					String txtMK_str = txtMorseCode.getText();
					String txtTK_str = Morse.morseCodeToString(txtMK_str);
					txtChuoi.setText(txtTK_str);
					System.out.println("Changed");
					_txtMKChanged = false;
				}
			}
		});
	}
}