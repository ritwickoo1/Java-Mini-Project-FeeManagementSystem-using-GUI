
package feemanagementsystemdriver;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;

public class EditStudent extends JFrame {
	static EditStudent frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	JTextArea textArea;
	private JTextField textField_10;
	
	public static void startFrame() {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        frame = new EditStudent();
                        frame.setVisible(true);
                } catch (Exception e) {
                            e.printStackTrace();
                    }
                }
            });
	}

	public void setupFrame(){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 530, 600);
            Color color=new Color(212, 204, 180);//;
            contentPane = new JPanel();
            contentPane.setBackground(color);
        
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            textField = new JTextField();
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setColumns(10);

            textField_2 = new JTextField();
            textField_2.setColumns(10);

            textField_3 = new JTextField();
            textField_3.setColumns(10);

            textField_4 = new JTextField();
            textField_4.setColumns(10);

            textField_5 = new JTextField();
            textField_5.setColumns(10);

            textField_6 = new JTextField();
            textField_6.setColumns(10);

            textField_7 = new JTextField();
            textField_7.setColumns(10);

            textField_8 = new JTextField();
            textField_8.setColumns(10);

            textField_9 = new JTextField();
            textField_9.setColumns(10);

            textArea = new JTextArea();
            textField_10 = new JTextField();
            textField_10.setColumns(10);
        }
	public EditStudent() {
            setupFrame();
            

            JLabel lblName = new JLabel("Name:");

            JLabel lblEmail = new JLabel("Email:");

            JLabel lblCourse = new JLabel("Course:");

            JLabel lblFee = new JLabel("Fee:");

            JLabel lblPaid = new JLabel("Paid:");

            JLabel lblDue = new JLabel("Due:");

            JLabel lblAddress = new JLabel("Address:");

            JLabel lblCity = new JLabel("City:");

            JLabel lblState = new JLabel("State:");

            JLabel lblCountry = new JLabel("Country:");

            JLabel lblContactNo = new JLabel("Contact No:");

            JButton btnAddAccountant = new JButton("Update");
            btnAddAccountant.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnAddAccountant.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                            String name=textField.getText();
                            String email=textField_1.getText();
                            String course=textField_2.getText();
                            int fee=Integer.parseInt(textField_3.getText());
                            int paid=Integer.parseInt(textField_4.getText());
                            int due=Integer.parseInt(textField_5.getText());
                            String address=textArea.getText();
                            String city=textField_6.getText();
                            String state=textField_7.getText();
                            String country=textField_8.getText();
                            String contactno=textField_9.getText();
                            int rollno=Integer.parseInt(textField_10.getText());

                            Student s=new Student(rollno,name,email,course,fee,paid,due,address,city,state,country,contactno);
                            int status=StudentDB.update(s);

                            if(status>0){
                                    JOptionPane.showMessageDialog(EditStudent.this,"Student updated successfully!");
                                    AccountantSection.startFrame();
                                    frame.dispose();
                            }else{
                                    JOptionPane.showMessageDialog(EditStudent.this,"Sorry, Unable to add student!");
                            }
                    }
            });

            

            JButton btnBack = new JButton("back");
            btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                            AccountantSection.startFrame();
                            frame.dispose();
                    }
            });

            JLabel lblRollNo = new JLabel("Roll No:");

            

            JSeparator separator = new JSeparator();

            JButton btnLoadRecord = new JButton("Load Record");
            btnLoadRecord.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnLoadRecord.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        String srollno=textField_10.getText();
                        if(srollno==null||srollno.trim().equals("")){
                                JOptionPane.showMessageDialog(EditStudent.this,"Please enter rollno first!");
                        }else{
                            int rollno=Integer.parseInt(srollno);
                            Student s=StudentDB.getStudentByRollno(rollno);
                            textField.setText(s.getName());
                            textField_1.setText(s.getEmail());
                            textField_2.setText(s.getCourse());
                            textField_3.setText(String.valueOf(s.getFee()));
                            textField_4.setText(String.valueOf(s.getPaid()));
                            textField_5.setText(String.valueOf(s.getDue()));
                            textArea.setText(s.getAddress());
                            textField_6.setText(s.getCity());
                            textField_7.setText(s.getState());
                            textField_8.setText(s.getCountry());
                            textField_9.setText(s.getContactno());
                        }
                    }
            });
            GroupLayout gl_contentPane = new GroupLayout(contentPane);
            gl_contentPane.setHorizontalGroup(
                    gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(lblName)
                                            .addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblFee, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPaid, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDue, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(lblRollNo, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lblEmail, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)))
                                    .addGap(33)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField_9, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                                    .addComponent(textArea))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                                    .addComponent(btnLoadRecord)))
                                    .addContainerGap())
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblContactNo)
                                    .addContainerGap(356, Short.MAX_VALUE))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblCountry, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                    .addGap(350))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(383, Short.MAX_VALUE))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(128)
                                    .addComponent(btnAddAccountant, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                    .addGap(30)
                                    .addComponent(btnBack)
                                    .addContainerGap(78, Short.MAX_VALUE))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(lblState, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(364, Short.MAX_VALUE))
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGap(27)
                                    .addComponent(separator, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(46, Short.MAX_VALUE))
            );
            gl_contentPane.setVerticalGroup(
                    gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(gl_contentPane.createSequentialGroup()
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblRollNo)
                                            .addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnLoadRecord))
                                    .addGap(16)
                                    .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblName)
                                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblEmail)
                                            .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblCourse)
                                            .addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblFee)
                                            .addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPaid)
                                            .addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblDue)
                                            .addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblAddress)
                                            .addComponent(textArea, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addComponent(lblCity)
                                                    .addGap(18))
                                            .addGroup(gl_contentPane.createSequentialGroup()
                                                    .addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblState)
                                            .addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblCountry)
                                            .addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(lblContactNo)
                                            .addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(7)
                                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAddAccountant, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBack))
                                    .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}
