
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class userdata extends JFrame {
    public void create(String title) {

//窗口代码如下
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        container.setBackground(Color.white);
        jf.setSize(900, 600);
        jf.setLocation(300, 150);
        menu5 mp = new menu5();
        jf.add(mp);
        Font f = new Font(null, Font.PLAIN, 10);
        JButton mb1 = new JButton("查询用户信息");
        JButton mb2 = new JButton("修改用户信息");
        JButton mb3 = new JButton("删除所选用户");

        mb1.setFont(f);
        mb1.setBounds(100, 420, 120, 40);
        mp.add(mb1);
        mb2.setFont(f);
        mb2.setBounds(390, 420, 120, 40);
        mp.add(mb2);
        mb3.setFont(f);
        mb3.setBounds(680, 420, 120, 40);
        mp.add(mb3);



        JTextField mt1 = new JTextField(50);
        mt1.setBounds(150, 80, 150, 30);
        mp.add(mt1);
        JTextField mt2 = new JTextField(50);
        mt2.setBounds(400, 80, 150, 30);
        mp.add(mt2);
        JTextField mt3 = new JTextField(50);
        mt3.setBounds(650, 80, 150, 30);
        mp.add(mt3);

        String[] columnNames=new String[]{"报刊号","报刊名","出版社"};
        String[][]Data1 = new String[16][3];

        JTable jt1 = new JTable(Data1,columnNames);
        jt1.setBounds(100, 140, 700, 256);
        mp.add(jt1);

        final int[] i = {0};
        mb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String num=mt1.getText();
                String num2=mt2.getText();
                String num3=mt3.getText();
                String a=new String();
                if (num.length()!=0) a=a+" and subno='"+num+"'";
                if (num2.length()!=0) a=a+" and password='"+num2+"'";
                if (num3.length()!=0) a=a+" and address like'%"+num3+"%'";

                {
                    int[] i = {0};
                    jf.repaint();
                    new connect();
                try (Connection conn = connect.getConnection();
                     Statement stmt = conn.createStatement()) {
                    String sql = "SELECT * FROM subscriber WHERE 1=1 "+a;
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        String no = rs.getString("subno");;
                        String na = rs.getString("password");
                        String pr = rs.getString("address");
                        Data1[i[0]][0] = no;
                        Data1[i[0]][1] = na;
                        Data1[i[0]][2] = pr;
                        i[0]++;

                    }
                    for(;i[0]<16;i[0]++)
                    {   Data1[i[0]][0] = "";
                        Data1[i[0]][1] = "";
                        Data1[i[0]][2] = "";

                    }
                    jf.repaint();

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
                String st1 = mt1.getText();
                String st2 = mt2.getText();
                String st3 = mt3.getText();

                new connect();
                if (st1.length() != 0 ) {
                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql2 = "UPDATE  subscriber SET password='"+st2+"',address='"+st3+"'  WHERE subno="+st1;
                        stmt.executeUpdate(sql2);

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











        mb3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String st1 = mt1.getText();

                new connect();
                if (st1.length() != 0 ) {
                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql2 = "DELETE FROM subscriber WHERE subno="+ st1;
                        stmt.executeUpdate(sql2);


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









//窗口结束代码
        mp.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}

class menu5 extends JPanel
{
    @Override
    public void paint(Graphics g)
    {
        Font f2=new Font(null, Font.BOLD,20);
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setFont(f2);
        g2.drawString("欢迎您，管理员",100,50);
        Font f=new Font(null, Font.PLAIN,10);
        g2.setFont(f);
        g2.drawString("用户编号",100,100);
        g2.drawString("用户密码",350,100);
        g2.drawString("订购地址",600,100);

        g2.drawString("用户序号",200,135);
        g2.drawString("用户密码",430,135);
        g2.drawString("订购地址",660,135);


    }
}