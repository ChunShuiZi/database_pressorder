import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class error extends JFrame {
    public void create(String title) {

//窗口代码如下
        JFrame jf = new JFrame(title);
        Container container = jf.getContentPane();
        container.setBackground(Color.white);
        jf.setSize(400, 200);
        jf.setLocation(550, 350);
        menu10 mp = new menu10();
        jf.add(mp);
        Font f = new Font(null, Font.PLAIN, 9);



















//窗口结束代码
        mp.setLayout(null);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}

class menu10 extends JPanel {
    @Override
    public void paint(Graphics g) {
        Font f2 = new Font(null, Font.BOLD, 15);
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(f2);
        g2.drawString("密码或账户错误", 135, 75);

    }
}