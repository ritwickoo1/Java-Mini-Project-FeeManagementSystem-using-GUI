
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
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;


public class AccountantSection extends JFrame{
    static AccountantSection frame;
    private JPanel contentPane;
    
    public static void startFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new AccountantSection();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void setupFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 530, 300);
        Color color=new Color(212, 204, 180);//;
        contentPane = new JPanel();
        contentPane.setBackground(color);
        
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
    }
    public AccountantSection() {
        setupFrame();
        JButton btnNewButton = new JButton("Add Student");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    AddStudent.startFrame(new String[]{});
                    frame.disable();
                }
        });

        JLabel lblAccountantSection = new JLabel("Accountant Section");
        lblAccountantSection.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblAccountantSection.setForeground(Color.DARK_GRAY);

        JButton btnViewStudent = new JButton("View Student");
        btnViewStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    ViewStudent.startFrame();
            }
        });

        JButton btnEditStudent = new JButton("Edit Student");
        btnEditStudent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnEditStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //EditStudent.main(new String[]{});
                frame.dispose();
            }
        });

        JButton btnDueFee = new JButton("Due Fee");
        btnDueFee.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDueFee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    //DueFee.main(new String[]{});
            }
        });

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                FeeManagementSystem.startFrame();
                frame.dispose();
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(136)
                            .addComponent(lblAccountantSection))
                    .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(60)
                            .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(gl_contentPane.createSequentialGroup()
                                            .addComponent(btnEditStudent, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnDueFee, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(gl_contentPane.createSequentialGroup()
                                            .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                            .addGap(53)
                                            .addComponent(btnViewStudent, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(gl_contentPane.createSequentialGroup()
                            .addGap(144)
                            .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(53, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(7)
                    .addComponent(lblAccountantSection)
                    .addGap(25)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewStudent, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                    .addGap(35)
                    .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditStudent, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDueFee, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                    .addGap(36)
                    .addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(138, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
    
}
