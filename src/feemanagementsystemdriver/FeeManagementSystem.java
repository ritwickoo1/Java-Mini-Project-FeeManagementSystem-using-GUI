
package feemanagementsystemdriver;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class FeeManagementSystem extends JFrame implements ActionListener{
    static FeeManagementSystem frame;
    private JPanel contentPane;
    public void setupFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 530, 300);
        contentPane = new JPanel();
        Color color=new Color(212, 204, 180);

        contentPane.setBackground(color);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        
    }
    public FeeManagementSystem() { // constructor
        setupFrame();
        JLabel lblFee = new JLabel("Fee Management");
        lblFee.setFont(new Font("Tahoma", Font.PLAIN, 30));
        JButton btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAdminLogin.addActionListener(this);
        JButton btnAccountantLogin = new JButton("Accountant Login");
        btnAccountantLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAccountantLogin.addActionListener(this);
        GroupLayout groupcPane = new GroupLayout(contentPane);
        groupcPane.setHorizontalGroup(
            groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupcPane.createSequentialGroup()
                    .addGap(143)
                    .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnAccountantLogin, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnAdminLogin, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                        .addComponent(lblFee)))
                        .addContainerGap(210, Short.MAX_VALUE)) 
        );
        groupcPane.setVerticalGroup(
            groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupcPane.createSequentialGroup()
                    .addComponent(lblFee)
                    .addGap(42)
                    .addComponent(btnAdminLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addComponent(btnAccountantLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(91, Short.MAX_VALUE))
        );
        contentPane.setLayout(groupcPane);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Admin Login")){
            AdminLogin.startFrame();
            frame.dispose();
        }else{
            AccountantLogin.startFrame();
            frame.dispose();
        }
    }
    public static void startFrame(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    frame = new FeeManagementSystem();
                    frame.setVisible(true);
                }catch (Exception e) {
                        e.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        startFrame();
    }
}
