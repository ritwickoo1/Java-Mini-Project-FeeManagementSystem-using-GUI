
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;


public class AddAccountant extends JFrame implements ActionListener{
    static AddAccountant frame;
    private JPanel contentPane;
    private JTextField nametf;
    private JPasswordField passwordField;
    private JTextField emailtf;
    private JTextField contactnotf;
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Add Accountant")){
            String name = nametf.getText();
            char ch[]=passwordField.getPassword();
            String password=String.valueOf(ch);
            String email=emailtf.getText();
            String contactno=contactnotf.getText();
            Accountant a=new Accountant(name,password,email,contactno);
            int status=AccountantDB.save(a);
            if(status>0){
                JOptionPane.showMessageDialog(AddAccountant.this,"Accountant added successfully!");
                nametf.setText("");
                emailtf.setText("");
                contactnotf.setText("");
                passwordField.setText("");
            }else{
                JOptionPane.showMessageDialog(AddAccountant.this,"Sorry, Unable to add Accountant!");
            }
        }else{
            AdminSection.startFrame();
            frame.dispose();
        }
    }
    public void setupFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 530, 350);
        contentPane = new JPanel();
        Color color=new Color(212, 204, 180);

        contentPane.setBackground(color);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        nametf = new JTextField();
        nametf.setColumns(10);

        passwordField = new JPasswordField();

        emailtf = new JTextField();
        emailtf.setColumns(10);

        contactnotf = new JTextField();
        contactnotf.setColumns(10);
    }
    public AddAccountant(){
        setupFrame();
        JLabel lblAddAccountant = new JLabel("Add Accountant");
        lblAddAccountant.setFont(new Font("Tahoma", Font.PLAIN, 30));
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JLabel lblContactNo = new JLabel("Contact No:");
        lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JButton btnAddAccountant = new JButton("Add Accountant");
        btnAddAccountant.addActionListener(this);
        btnAddAccountant.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(this);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GroupLayout groupcPane = new GroupLayout(contentPane);
            groupcPane.setHorizontalGroup(
                groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(groupcPane.createSequentialGroup()
                        .addContainerGap()
                            .addGap(90)
                        .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                
                                .addComponent(lblName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblContactNo, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                        .addGap(30)
                        .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(contactnotf, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailtf, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nametf, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                        .addComponent(passwordField)))
                        .addContainerGap(101, Short.MAX_VALUE))
                    .addGroup(groupcPane.createSequentialGroup()
                        .addGap(140)
                        .addComponent(btnAddAccountant, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(18))
                    .addGroup(GroupLayout.Alignment.TRAILING, groupcPane.createSequentialGroup()
                        .addContainerGap(163, Short.MAX_VALUE)
                        .addComponent(lblAddAccountant)
                        .addGap(122))
		);
		groupcPane.setVerticalGroup(
                    groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupcPane.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblAddAccountant)
                            .addGap(20)
                            .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblName)
                                .addComponent(nametf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18)
                            .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPassword)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18)
                            .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEmail)
                                .addComponent(emailtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18)
                            .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblContactNo)
                                .addComponent(contactnotf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18)
                            .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btnAddAccountant, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                .addComponent(btnBack))
                            .addContainerGap())
		);
		contentPane.setLayout(groupcPane);        
    }
    public static void startFrame(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                        frame = new AddAccountant();
                        frame.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }
            }
	});
    }


}
