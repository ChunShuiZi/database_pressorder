
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login extends JFrame {
    public void create(String title) {


//窗口代码如下
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        container.setBackground(Color.white);
        jf.setSize(900, 600);
        jf.setLocation(300, 150);
        menu mp = new menu();
        jf.add(mp);
        Font f = new Font(null, Font.PLAIN, 20);











        JTextField mt1 = new JTextField(20);
        mt1.setBounds(270, 170, 400, 50);
        JTextField mt2 = new JTextField(20);
        mt2.setBounds(270, 270, 400, 50);
        mp.add(mt1);
        mp.add(mt2);

        JRadioButton rb1 = new JRadioButton("订阅者");
        JRadioButton rb2 = new JRadioButton("管理员");
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rb1);
        buttonGroup1.add(rb2);
        rb1.setBounds(300, 350, 150, 50);
        rb2.setBounds(500, 350, 150, 50);
        mp.add(rb1);
        mp.add(rb2);


        JButton mb1 = new JButton("登录");
        JButton mb2 = new JButton("注册");
        mb1.setFont(f);
        mb1.setBounds(220, 420, 150, 50);
        mp.add(mb1);
        mb2.setFont(f);
        mb2.setBounds(500, 420, 150, 50);
        mp.add(mb2);

        mb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String st1=mt1.getText();
                String st2 = mt2.getText();
                if(rb1.isSelected())
                {
                    new connect();

                        try (Connection conn = connect.getConnection();
                             Statement stmt = conn.createStatement()) {
                            String sql2 = "SELECT password FROM subscriber WHERE subno='"+st1+"'";
                            ResultSet rs = stmt.executeQuery(sql2);
                            while (rs.next()) {
                                String pa = rs.getString("password");
                               if(pa.equals(st2) && st2.length()!=0)
                               {
                                   new subscriber().create(title,st1);
                               }
                               else  new error().create(title);


                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }



                }
                if(rb2.isSelected())
                {
                    new connect();

                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql2 = "SELECT password FROM admin WHERE adminno='"+st1+"'";
                        ResultSet rs = stmt.executeQuery(sql2);
                        while (rs.next()) {
                            String pa = rs.getString("password");
                            if(pa.equals(st2) && st2.length()!=0)
                            {
                                new admin().create(title);
                            }
                            else  new error().create(title);


                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
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

        mb2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new reginster().create(title);

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
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}

class menu extends JPanel
{
    @Override
    public void paint(Graphics g)
    {
        Font f2=new Font(null, Font.HANGING_BASELINE,25);
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setFont(f2);
        g2.drawString("订阅报刊管理系统",340,100);
        Font f=new Font(null, Font.PLAIN,20);
        g2.setFont(f);
        g2.drawString("账号",200,200);
        g2.drawString("密码",200,300);
    }
}