
package feemanagementsystemdriver;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountantLogin extends JFrame implements ActionListener{
    static AccountantLogin frame;
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
    public AccountantLogin() {
        setupFrame();
        JLabel lblAccountantLogin = new JLabel("Accountant Login");
        lblAccountantLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblAccountantLogin.setForeground(Color.DARK_GRAY);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JButton btnLogin = new JButton("login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLogin.addActionListener(this);
        JButton btnBack = new JButton("back");
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBack.addActionListener(this);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(110)
                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(lblPassword)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                    .addComponent(lblName)
                                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                            .addGap(10)
                                            .addComponent(lblAccountantLogin))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                            .addGap(50)
                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                    .addComponent(passwordField)
                                                    .addComponent(textField, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))))))
                    .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(158)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
                                .addGap(40)
                                .addComponent(btnBack)))
                .addContainerGap(78, Short.MAX_VALUE))
    );
    gl_contentPane.setVerticalGroup(
        gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAccountantLogin)
                .addGap(18)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lblName)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblPassword)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBack))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("login")){
            String name=textField.getText();
            String password=String.valueOf(passwordField.getPassword());
            boolean status=AccountantDB.validate(name, password);
            if(status){
                AccountantSection.startFrame();
                frame.dispose();
            }else{
                JOptionPane.showMessageDialog(AccountantLogin.this,"Sorry, username or password error!","Login error!",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            FeeManagementSystem.startFrame();
            frame.dispose();
        }
            
    }
    
    
    public static void startFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AccountantLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
