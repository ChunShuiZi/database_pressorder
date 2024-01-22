import javax.swing.*;
import com.formdev.flatlaf.*;
import javax.swing.UIManager;
//主函数
public class Main extends JFrame {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new login().create("数据库课程设计");
    }
}
