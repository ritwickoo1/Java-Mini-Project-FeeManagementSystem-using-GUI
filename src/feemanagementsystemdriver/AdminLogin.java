
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
import javax.swing.border.EmptyBorder;

public class AdminLogin extends JFrame implements ActionListener{
    static AdminLogin frame;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    
    public void setupFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 530, 300);
        contentPane = new JPanel();
        Color color=new Color(212, 204, 180);//;

        contentPane.setBackground(color);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        textField = new JTextField();
        textField.setColumns(10);

        passwordField = new JPasswordField();
        
    }
    public AdminLogin(){
        setupFrame();
        JLabel lblAdminLogin = new JLabel("Admin Login");
        lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLogin.addActionListener(this);
        GroupLayout groupcPane = new GroupLayout(contentPane);
        groupcPane.setHorizontalGroup(
            groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupcPane.createSequentialGroup()
                    .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupcPane.createSequentialGroup()
                                .addGap(180)
                                .addComponent(lblAdminLogin))
                        .addGroup(groupcPane.createSequentialGroup()
                                .addGap(95)
                                .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblName)
                                        .addComponent(lblPassword))
                                .addGap(58)
                                .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(passwordField)
                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                        .addGroup(groupcPane.createSequentialGroup()
                                .addGap(250)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        groupcPane.setVerticalGroup(
            groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupcPane.createSequentialGroup()
                    .addComponent(lblAdminLogin)
                    .addGap(29)
                    .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27)
                    .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword))
                    .addGap(36)
                    .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE))
        );
        contentPane.setLayout(groupcPane);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String name=textField.getText();
        char ch[]=passwordField.getPassword();
        String password=String.valueOf(ch);
        if(name.equals("admin")&&password.equals("admin123")){
                AdminSection.startFrame();
                frame.dispose();
        }else{
                JOptionPane.showMessageDialog(AdminLogin.this,"Invalid Username And Password, Try Again");
                textField.setText("");passwordField.setText("");
        }
    }
    
    
    
    public static void startFrame(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AdminLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }
            }
        });
    }
}
