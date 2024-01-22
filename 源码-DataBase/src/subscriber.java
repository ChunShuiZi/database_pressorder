
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class subscriber extends JFrame {
    public void create(String title,String user) {

//窗口代码如下
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        container.setBackground(Color.white);
        jf.setSize(900, 600);
        jf.setLocation(300, 150);
        menu3 mp = new menu3();
        jf.add(mp);
        Font f = new Font(null, Font.PLAIN, 10);
        JButton mb1 = new JButton("查询所选报刊");
        JButton mb2 = new JButton("查询已订报刊");
        JButton mb3 = new JButton("订阅所选报刊");
        JButton mb4 = new JButton("退订所选报刊");
        mb1.setFont(f);
        mb1.setBounds(100, 420, 100, 40);
        mp.add(mb1);
        mb2.setFont(f);
        mb2.setBounds(300, 420, 100, 40);
        mp.add(mb2);
        mb3.setFont(f);
        mb3.setBounds(500, 420, 100, 40);
        mp.add(mb3);
        mb4.setFont(f);
        mb4.setBounds(700, 420, 100, 40);
        mp.add(mb4);


        JTextField mt1 = new JTextField(50);
        mt1.setBounds(200, 80, 130, 30);
        JTextField mt2 = new JTextField(50);
        mt2.setBounds(400, 80, 130, 30);
        JTextField mt3 = new JTextField(50);
        mt3.setBounds(600, 80, 130, 30);



        mp.add(mt1);
        mp.add(mt2);
        mp.add(mt3);


        String[] columnNames=new String[]{"报刊号","报刊名","出版社","订阅状态"};
        String[][]Data1 = new String[16][4];

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

                int[] i = {0};
                jf.repaint();
                new connect();
                String a=new String();
                if (num.length()!=0) a=a+" and pressno='"+num+"'";
                if (num2.length()!=0) a=a+" and pressname like '%"+num2+"%'";
                if (num3.length()!=0) a=a+" and presspress like '%"+num3+"%'";
                try (Connection conn = connect.getConnection();
                     Statement stmt = conn.createStatement()) {
                    String sql = "SELECT * FROM press WHERE 1=1 "+a;
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        String no = rs.getString("pressno");
                        String na = rs.getString("pressname");
                        String pr = rs.getString("presspress");

                        Data1[i[0]][0] = no;
                        Data1[i[0]][1] = na;
                        Data1[i[0]][2] = pr;
                        Data1[i[0]][3] = "";
                        i[0]++;

                    }for(;i[0]<16;i[0]++)
                    {   Data1[i[0]][0] = "";
                        Data1[i[0]][1] = "";
                        Data1[i[0]][2] = "";
                        Data1[i[0]][3] = "";

                    }
                    jf.repaint();

                } catch (SQLException ex) {
                    ex.printStackTrace();
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

                int[] i = {0};
                jf.repaint();
                new connect();

                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql = "SELECT * FROM orderer INNER JOIN press ON orderer.pressno=press.pressno WHERE subscriberno="+user;
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String no = rs.getString("pressno");
                            String na = rs.getString("pressname");
                            String pr = rs.getString("presspress");
                            String ta = rs.getString("state");

                            Data1[i[0]][0] = no;
                            Data1[i[0]][1] = na;
                            Data1[i[0]][2] = pr;
                            Data1[i[0]][3] = ta;

                            i[0]++;

                        }
                        for(;i[0]<16;i[0]++)
                        {
                            Data1[i[0]][0] = "";
                            Data1[i[0]][1] = "";
                            Data1[i[0]][2] = "";
                            Data1[i[0]][3] = "";
                        }
                        jf.repaint();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }}



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
                        String sql2 = "INSERT INTO orderer(pressno,subscriberno,state) VALUES(" + st1 + ",'"+user+"','审核中')";
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


        mb4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String st1 = mt1.getText();

                new connect();
                if (st1.length() != 0 ) {
                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql2 = "DELETE FROM orderer WHERE pressno="+ st1+" AND subscriberno="+user;
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

class menu3 extends JPanel
{
    @Override
    public void paint(Graphics g)
    {
        Font f2=new Font(null, Font.BOLD,20);
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        g2.setFont(f2);
        g2.drawString("欢迎您，订阅者",100,50);
        Font f=new Font(null, Font.PLAIN,10);
        g2.setFont(f);
        g2.drawString("报刊编号",150,100);
        g2.drawString("报刊名称",350,100);
        g2.drawString("出版社",550,100);

        g2.drawString("报刊号",170,135);
        g2.drawString("报刊名",340,135);
        g2.drawString("出版社",520,135);
        g2.drawString("订阅状态",690,135);


    }
}