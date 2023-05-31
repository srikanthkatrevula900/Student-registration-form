import java.awt.EventQueue;

import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public class StudentInformation {

	private JFrame frame;
	private JTextField txtname1;
	private JTextField txtage;
	private JTextField txtblood;
	private JTextField txtcourse;
	private JTextField txtcontact;
	private JTable table;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInformation window = new StudentInformation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentInformation() {
		initialize();
		Connect();
		table_load();
	}

	
			private void table_load() {
				// TODO Auto-generated method stub
				try
				{
					pst=con.prepareStatement("select*from information ");
							rs=pst.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	public void Connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3308/studentform","root","root");
			// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/studentform","root","root");
		}
		catch(ClassNotFoundException  ex)
		{
		}
		catch (SQLException ex)
		{
		
		}
		}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.setBounds(100, 100, 1081, 775);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT RIGISTRATION FORM");
		lblNewLabel.setForeground(new Color(51, 102, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(414, 28, 482, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 153));
		panel.setForeground(Color.RED);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(22, 103, 448, 407);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel txtname = new JLabel("Name");
		txtname.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtname.setBounds(47, 26, 111, 29);
		panel.add(txtname);
		
		JLabel lblNewLabel_2 = new JLabel("DOB");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(47, 150, 97, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Blood Group");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(47, 204, 111, 36);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Course");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(47, 273, 97, 29);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Contact");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(47, 347, 97, 29);
		panel.add(lblNewLabel_1);
		
		txtname1 = new JTextField();
		txtname1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtname1.setForeground(SystemColor.desktop);
		txtname1.setBackground(SystemColor.inactiveCaptionBorder);
		txtname1.setBounds(213, 19, 167, 36);
		panel.add(txtname1);
		txtname1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Age");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(47, 83, 111, 29);
		panel.add(lblNewLabel_5);
		
		txtage = new JTextField();
		txtage.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtage.setBackground(SystemColor.inactiveCaptionBorder);
		txtage.setColumns(10);
		txtage.setBounds(213, 82, 167, 36);
		panel.add(txtage);
		
		txtblood = new JTextField();
		txtblood.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtblood.setBackground(SystemColor.inactiveCaptionBorder);
		txtblood.setColumns(10);
		txtblood.setBounds(213, 207, 167, 36);
		panel.add(txtblood);
		
		txtcourse = new JTextField();
		txtcourse.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtcourse.setBackground(SystemColor.inactiveCaptionBorder);
		txtcourse.setColumns(10);
		txtcourse.setBounds(213, 272, 167, 36);
		panel.add(txtcourse);
		
		txtcontact = new JTextField();
		txtcontact.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtcontact.setBackground(SystemColor.inactiveCaptionBorder);
		txtcontact.setColumns(10);
		txtcontact.setBounds(213, 346, 167, 36);
		panel.add(txtcontact);
		
		JDateChooser txtdob = new JDateChooser();
		txtdob.setForeground(new Color(255, 153, 153));
		txtdob.setBackground(new Color(255, 153, 153));
		txtdob.setDateFormatString("yyyy-MM-dd");
		txtdob.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		txtdob.setBounds(213, 144, 167, 41);
		panel.add(txtdob);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBackground(Color.WHITE);
		Image img=new ImageIcon(this.getClass().getResource("/save.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name,Age,DOB,BloodGroup,Course,Contact;
				
				Name=txtname1.getText();
				Age=txtage.getText();
				DOB=txtdob.getToolTipText();
				BloodGroup=txtblood.getText();
				Course=txtcourse.getText();
				Contact=txtcontact.getText();
				try {
				pst=con.prepareStatement("insert into information(Name,Age,DOB,BloodGroup,Course,Contact)values(?,?,?,?,?,?)");
				pst.setString(1, Name);
				pst.setString(2, Age);
				SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
			
				String date=sdf.format(txtdob.getDate());
				pst.setString(3, date);
				pst.setString(4, BloodGroup);
				pst.setString(5, Course);
				pst.setString(6, Contact);
				pst.execute();

JOptionPane.showMessageDialog(null, "Data Insertion Successfully...!");

showData();
				
				table_load();
				txtname1.setText("");
				txtage.setText("");
				txtdob.setToolTipText("");
				txtblood.setText("");
				txtcourse.setText("");
				txtcontact.setText("");
				txtname1.requestFocus();
								}
catch(SQLException e1)
				{
	e1.printStackTrace();
				}
			}

			private void showData() {
				// TODO Auto-generated method stub
				
			}
			
			
		});
	
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(36, 535, 104, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setForeground(Color.BLACK);
		Image img1=new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
		btnReset.setIcon(new ImageIcon(img1));
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtname1.setText("");
				txtage.setText("");
				txtdob.setToolTipText("");
				txtblood.setText("");
				txtcourse.setText("");
				txtcontact.setText("");
				txtname1.requestFocus();
				
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(186, 535, 124, 42);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(Color.WHITE);
		Image img2=new ImageIcon(this.getClass().getResource("/exit1.png")).getImage();
		btnExit.setIcon(new ImageIcon(img2));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(340, 535, 130, 42);
		frame.getContentPane().add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(510, 114, 533, 407);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 153));
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(22, 613, 448, 90);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblId = new JLabel("Student Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(66, 30, 111, 29);
		panel_1.add(lblId);
		
		txtid = new JTextField();
		txtid.setBackground(SystemColor.inactiveCaptionBorder);
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String Student_id=txtid.getText();
					pst=con.prepareStatement("select  Name,Age,DOB,BloodGroup,Course,Contact where Student_Id=?");
					
					pst.setString(1, Student_id);
					ResultSet rs=pst.executeQuery();
					if(rs.next()==true)
					{
						String name1=rs.getString(1);
						String age=rs.getString(2);
						String dob=rs.getString(3);
						String blood=rs.getString(4);
						String course=rs.getString(5);
						String contact=rs.getString(6);
						
						
						
						txtname1.setText(name1);
						txtage.setText(age);
						txtdob.setToolTipText(dob);
						txtblood.setText(blood);
						txtcourse.setText(course);
						txtcontact.setText(contact);
					
					}
					else
					{
						txtname1.setText("");
						txtage.setText("");
						txtdob.setToolTipText("");
						txtblood.setText("");
						txtcourse.setText("");
						txtcontact.setText("");
					}
				
				}
				catch(SQLException ex) {
				}
				}
				
				
				
				
				
		});
		txtid.setColumns(10);
		txtid.setBounds(210, 29, 167, 36);
		panel_1.add(txtid);
		
		JButton btnUpdate = new JButton("UPDATE");
		Image img3=new ImageIcon(this.getClass().getResource("/upload1.png")).getImage();
		btnUpdate.setIcon(new ImageIcon(img2));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
           String  Name,Age,DOB,BloodGroup,Course,Contact,Student_Id;
				
				Name=txtname1.getText();
				Age=txtage.getText();
				DOB=txtdob.getToolTipText();
				BloodGroup=txtblood.getText();
				Course=txtcourse.getText();
				Contact=txtcontact.getText();
				Student_Id=txtid.getText();
				try {
				pst=con.prepareStatement("update information set Name=?,Age=?,DOB=?,Bloodgroup=?,Course=?,Contact=?  where Student_Id=?");
				pst.setString(1, Name);
				pst.setString(2, Age);
				SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
				
				String date=sdf.format(txtdob.getDate());
				pst.setString(3, date);
				pst.setString(4, BloodGroup);
				pst.setString(5, Course);
				pst.setString(6, Contact);
				pst.setString(7, Student_Id);
				pst.executeUpdate();

JOptionPane.showMessageDialog(null, "Update Successfully...!");

		
				table_load();
				txtname1.setText("");
				txtage.setText("");
				txtdob.setToolTipText("");
				txtblood.setText("");
				txtcourse.setText("");
				txtcontact.setText("");
				txtname1.requestFocus();
								}
catch(SQLException e1)
				{
	e1.printStackTrace();
				}
							
								
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(544, 588, 160, 58);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		Image img4=new ImageIcon(this.getClass().getResource("/delete1.png")).getImage();
		btnDelete.setIcon(new ImageIcon(img4));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 String Student_id=txtid.getText();
					
					
					try {
					pst=con.prepareStatement("delete from information where Student_Id= ?");
				
					pst.setString(1, Student_id);
					pst.execute();

	JOptionPane.showMessageDialog(null, "Deleted Successfully...!");
				
					table_load();
					txtname1.setText("");
					txtage.setText("");
					txtdob.setToolTipText("");
					txtblood.setText("");
					txtcourse.setText("");
					txtcontact.setText("");
					txtname1.requestFocus();
									}
	catch(SQLException e1)
					{
		e1.printStackTrace();
					}
								
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(781, 588, 169, 58);
		frame.getContentPane().add(btnDelete);
		
		JLabel topimage = new JLabel("");
		topimage.setIcon(new ImageIcon("C:\\Users\\91944\\eclipse-workspace\\StudentRegistrationForm\\bin\\student1.png"));

		topimage.setBounds(341, 28, 63, 58);
				frame.getContentPane().add(topimage);
				
	}
}
