import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog1 {
    public static void main(String[] args) {
        double[] a = { 1, 2, 3, 4 };
        double[] b = { 1, 1, 1, 1 };
        double[] c = { 2, 2, 2, 2 };
        DoubleVector v1 = new DoubleVector(a);
        DoubleVector v2 = new DoubleVector(b);
        DoubleVector v3 = new DoubleVector(c);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        JFrame frm = new JFrame("Перше візуальне застосування");
        frm.setSize(300, 200);
        Container container = frm.getContentPane();
        container.setLayout(new FlowLayout());

        container.add(new JLabel("Hello, привіт"));

        container.add(new JLabel("v1*v2=" + v1.mult(v2)));
        container.add(new JLabel("v1*v2=" + DoubleVector.mult(v1, v2)));
        container.add(new JLabel("v1*v3=" + v1.mult(v3)));

        container.add(new JLabel("v1+v2=" + v1.sum(v2)));
        container.add(new JLabel("v1+v2=" + DoubleVector.sum(v1, v2)));
        container.add(new JLabel("v1+v3=" + v1.sum(v3)));

        container.add(new JLabel("v1-v2=" + v1.diff(v2)));
        container.add(new JLabel("v1-v2=" + DoubleVector.diff(v1, v2)));
        container.add(new JLabel("v1-v3=" + v1.diff(v3)));

        container.add(new JLabel("v1*3=" + v1.mult(3)));
        container.add(new JLabel("v2*3=" + DoubleVector.mult(v2, 3)));
        container.add(new JLabel("v3*3=" + v3.mult(3)));
        // фрагмент as is (2)
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        frm.addWindowListener(wndCloser);
        frm.setVisible(true);
    }
}