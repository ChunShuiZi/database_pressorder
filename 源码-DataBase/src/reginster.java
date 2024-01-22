import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class reginster extends JFrame {
    public void create(String title) {

//窗口代码如下
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        container.setBackground(Color.white);
        jf.setSize(900, 600);
        jf.setLocation(300, 150);
        menu2 mp = new menu2();
        jf.add(mp);
        Font f = new Font(null, Font.PLAIN, 20);
        JButton mb1 = new JButton("确认注册");
        mb1.setFont(f);
        mb1.setBounds(360, 420, 150, 50);
        mp.add(mb1);



        JTextField mt1 = new JTextField(20);
        mt1.setBounds(270, 170, 400, 35);
        JTextField mt2 = new JTextField(20);
        mt2.setBounds(270, 235, 400, 35);
        JTextField mt3 = new JTextField(20);
        mt3.setBounds(270, 300, 400, 35);
        mp.add(mt1);
        mp.add(mt2);
        mp.add(mt3);

        JRadioButton rb1 = new JRadioButton("订阅者");
        JRadioButton rb2 = new JRadioButton("管理员");
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rb1);
        buttonGroup1.add(rb2);
        rb1.setBounds(300, 350, 150, 50);
        rb2.setBounds(500, 350, 150, 50);
        mp.add(rb1);
        mp.add(rb2);

        mb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (rb1.isSelected()) {
                    String st1 = mt1.getText();
                    String st2 = mt2.getText();
                    String st3 = mt3.getText();
                    new connect();
                    if (st1.length() != 0 && st2.length() != 0) {
                        try (Connection conn = connect.getConnection();
                             Statement stmt = conn.createStatement()) {
                            String sql2 = "INSERT INTO subscriber(subno,password,address) VALUES(" + st1 + ",'" + st2 + "','" + st3 + "')";
                            stmt.executeUpdate(sql2);


                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    }
                }

                    if (rb2.isSelected()) {
                        String st1 = mt1.getText();
                        String st2 = mt2.getText();
                        String st3 = mt3.getText();
                        new connect();
                        if (st1.length() != 0 && st2.length() != 0 && st3.length() != 0) {
                            try (Connection conn = connect.getConnection();
                                 Statement stmt = conn.createStatement()) {
                                String sql2 = "INSERT INTO admin(adminno,password,address) VALUES(" + st1 + ",'" + st2 + "','" + st3 + "')";
                                stmt.executeUpdate(sql2);


                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }

                        }




                }
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });













//窗口结束代码
        mp.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}

class menu2 extends JPanel
{
    @Override
    public void paint(Graphics g)
    {
        Font f2=new Font(null, Font.ITALIC,25);
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setFont(f2);
        g2.drawString("订阅报刊管理注册界面",330,100);
        Font f=new Font(null, Font.PLAIN,20);
        g2.setFont(f);
        g2.drawString("账号",200,195);
        g2.drawString("密码",200,260);
        g2.drawString("地址",200,325);
    }
}