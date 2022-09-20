import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class Dialog4 extends JFrame {
    JTextField tOutput = new JTextField();
    JTextField tInput = new JTextField();
    JButton btn = new JButton("Скопіювати");
    JLabel lbl = new JLabel(" ");

    Dialog4() {
        super("Слухачі (listeners) полів та кнопок");
        setResizable(false);
        setLayout(null);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        setSize(400, 200);
        Container c = getContentPane();

        lbl.setLocation(50, 10);
        lbl.setSize(250, 20);
        c.add(lbl);

        JLabel inputLabel = new JLabel("Поле ввода:");
        inputLabel.setSize(100, 20);
        inputLabel.setLocation(50, 40);
        c.add(inputLabel);

        tInput = new JTextField();
        tInput.setSize(190, 20);
        tInput.setLocation(140, 40);
        c.add(tInput);

        JLabel outputLabel = new JLabel("Поле вивода:");
        outputLabel.setSize(100, 20);
        outputLabel.setLocation(50, 70);
        c.add(outputLabel);

        tOutput = new JTextField();
        tOutput.setSize(190, 20);
        tOutput.setLocation(140, 70);
        tOutput.setEnabled(false);
        c.add(tOutput);

        btn.setSize(120, 25);
        btn.setLocation(140, 100);
        c.add(btn);

        tInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Введений текст:" + tInput.getText());
                tOutput.setText(tInput.getText());
            }
        });
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(tInput.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);

                lbl.setText("Текст скопійований в буфер обміну");
            }
        });
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dialog4();
    }
}