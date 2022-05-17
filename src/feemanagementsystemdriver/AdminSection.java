
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class AdminSection extends JFrame implements ActionListener{
    static AdminSection frame;
    private JPanel contentPane;
    JScrollPane sp;
    public void setupFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 530, 300);
        contentPane = new JPanel();
        Color color=new Color(212, 204, 180);

        contentPane.setBackground(color);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
    }
    public AdminSection(){
        setupFrame();
        JLabel lblAdminSection = new JLabel("Admin Section");
	lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 30));
        JButton btnAddAccountant = new JButton("Add Accountant");
        btnAddAccountant.addActionListener(this);
        btnAddAccountant.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JButton btnViewAccountant = new JButton("View Accountant");
        btnViewAccountant.addActionListener(this);
        btnViewAccountant.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(this);
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GroupLayout groupcPane = new GroupLayout(contentPane);
        groupcPane.setHorizontalGroup(
            groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupcPane.createSequentialGroup()
                    .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupcPane.createSequentialGroup()
                                .addGap(161)
                                .addComponent(lblAdminSection))
                        .addGroup(groupcPane.createSequentialGroup()
                                .addGap(149)
                                .addGroup(groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(btnViewAccountant, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddAccountant, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        groupcPane.setVerticalGroup(
            groupcPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(groupcPane.createSequentialGroup()
                    .addComponent(lblAdminSection)
                    .addGap(29)
                    .addComponent(btnAddAccountant, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnViewAccountant, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(59, Short.MAX_VALUE))
        );
        contentPane.setLayout(groupcPane);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Accountant")){
            AddAccountant.startFrame();
            frame.dispose();
        }else if(e.getActionCommand().equals("View Accountant")){
            ViewAccountant.startFrame();
            
        }else {
            FeeManagementSystem.startFrame();
            frame.dispose();
        }
    }
    
    
    public static void startFrame(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AdminSection();
                    frame.setVisible(true);
                } catch (Exception e) {
                        e.printStackTrace();
                }
            }
        });
    }

    
}
