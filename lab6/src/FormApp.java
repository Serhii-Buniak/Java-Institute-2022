import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormApp {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 300);
        JPanel p = new JPanel();
        jf.add(p);
        p.setLayout(null);

        JLabel name = new JLabel("Name:");
        name.setSize(100, 20);
        name.setLocation(50, 20);
        p.add(name);

        JTextField tname = new JTextField();
        tname.setSize(190, 20);
        tname.setLocation(120, 20);
        p.add(tname);

        JLabel password = new JLabel("Password:");
        password.setSize(100, 20);
        password.setLocation(50, 50);
        p.add(password);

        JTextField tPassword = new JTextField();
        tPassword.setSize(190, 20);
        tPassword.setLocation(120, 50);
        p.add(tPassword);

        JButton reset = new JButton("Reset");
        reset.setSize(100, 20);
        reset.setLocation(209, 80);
        p.add(reset);

        JButton submit = new JButton("Submit");
        submit.setSize(100, 20);
        submit.setLocation(50, 80);
        p.add(submit);

        jf.setVisible(true);
    }
}
