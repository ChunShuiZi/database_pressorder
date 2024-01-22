import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class admin extends JFrame {
    public void create(String title) {

//窗口代码如下
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        container.setBackground(Color.white);
        jf.setSize(900, 600);
        jf.setLocation(300, 150);
        menu4 mp = new menu4();
        jf.add(mp);
        Font f = new Font(null, Font.PLAIN, 9);
        JButton mb1 = new JButton("新增一种报刊");
        JButton mb2 = new JButton("查询所选报刊");
        JButton mb3 = new JButton("修改报刊信息");
        JButton mb4 = new JButton("删除所选报刊");
        JButton mb5 = new JButton("查询用户订刊");
        JButton mb6 = new JButton("删除用户订刊");
        JButton mb7 = new JButton("通过用户订刊");
        JButton mb8 = new JButton("更改用户信息");
        mb1.setFont(f);
        mb1.setBounds(100, 420, 100, 30);
        mp.add(mb1);
        mb2.setFont(f);
        mb2.setBounds(300, 420, 100, 30);
        mp.add(mb2);
        mb3.setFont(f);
        mb3.setBounds(500, 420, 100, 30);
        mp.add(mb3);
        mb4.setFont(f);
        mb4.setBounds(700, 420, 100, 30);
        mp.add(mb4);
        mb5.setFont(f);
        mb5.setBounds(100, 480, 100, 30);
        mp.add(mb5);
        mb6.setFont(f);
        mb6.setBounds(300, 480, 100, 30);
        mp.add(mb6);
        mb7.setFont(f);
        mb7.setBounds(500, 480, 100, 30);
        mp.add(mb7);
        mb8.setFont(f);
        mb8.setBounds(700, 480, 100, 30);
        mp.add(mb8);

        JTextField mt1 = new JTextField(50);
        mt1.setBounds(100, 80, 130, 30);
        JTextField mt2 = new JTextField(50);
        mt2.setBounds(300, 80, 130, 30);
        JTextField mt3 = new JTextField(50);
        mt3.setBounds(500, 80, 130, 30);
        JTextField mt4 = new JTextField(50);
        mt4.setBounds(700, 80, 130, 30);


        mp.add(mt1);
        mp.add(mt2);
        mp.add(mt3);
        mp.add(mt4);

        String[] columnNames=new String[]{"报刊号","报刊名","出版社","订阅状态"};
        String[][]Data1 = new String[16][4];

        JTable jt1 = new JTable(Data1,columnNames);
        jt1.setBounds(100, 140, 700, 256);

        mp.add(jt1);


        final int[] i = {0};

        mb1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    String st1 = mt1.getText();
                    String st2 = mt2.getText();
                    String st3 = mt3.getText();
                    new connect();
                    if (st1.length() != 0 && st2.length() != 0 && st3.length() != 0) {
                        try (Connection conn = connect.getConnection();
                             Statement stmt = conn.createStatement()) {
                            String sql2 = "INSERT INTO press(pressno,pressname,presspress) VALUES(" + st1 + ",'" + st2 + "','" + st3 + "')";
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








        mb2.addMouseListener(new MouseListener() {
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
                        String no = rs.getString("pressno");;
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


        mb3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String st1 = mt1.getText();
                String st2 = mt2.getText();
                String st3 = mt3.getText();

                new connect();
                if (st1.length() != 0 ) {
                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql2 = "UPDATE  press SET pressname='"+st2+"',presspress='"+st3+"'  WHERE pressno="+st1;
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
                String num=mt1.getText();
                String num2=mt2.getText();
                String num3=mt3.getText();
                String a=new String();
                if (num.length()!=0) a=a+" and pressno='"+num+"'";
                if (num2.length()!=0) a=a+" and pressname='"+num2+"'";
                if (num3.length()!=0) a=a+" and presspress='"+num3+"'";
                if(num.length()==0&&num2.length()==0&&num3.length()==0) a="error";
                new connect();

                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql2 = "DELETE FROM press WHERE 1=1 "+ a;
                        stmt.executeUpdate(sql2);


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














        mb5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String user = mt4.getText();
                int[] i = {0};
                jf.repaint();
                new connect();
                if (user.length() != 0) {
                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql = "SELECT * FROM orderer INNER JOIN press ON orderer.pressno=press.pressno WHERE subscriberno=" + user;
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
                        for (; i[0] < 16; i[0]++) {
                            Data1[i[0]][0] = "";
                            Data1[i[0]][1] = "";
                            Data1[i[0]][2] = "";
                            Data1[i[0]][3] = "";

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



        mb6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String st1 = mt1.getText();
                String st4 = mt4.getText();
                new connect();
                if (st1.length() != 0 ) {
                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql2 = "DELETE FROM orderer WHERE pressno="+ st1+" AND subscriberno="+st4;
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



        mb7.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String st1 = mt1.getText();
                String st4 = mt4.getText();
                new connect();
                if (st1.length() != 0 ) {
                    try (Connection conn = connect.getConnection();
                         Statement stmt = conn.createStatement()) {
                        String sql2 = "UPDATE  orderer SET state='审核通过' WHERE subscriberno="+st4 +" AND pressno="+st1;
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







        mb8.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new userdata().create(title);
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

class menu4 extends JPanel
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
        g2.drawString("报刊编号",50,100);
        g2.drawString("报刊名称",250,100);
        g2.drawString("出版社",450,100);
        g2.drawString("用户编号",650,100);

        g2.drawString("报刊号",170,135);
        g2.drawString("报刊名",340,135);
        g2.drawString("出版社",520,135);
        g2.drawString("订阅状态",690,135);


    }
}