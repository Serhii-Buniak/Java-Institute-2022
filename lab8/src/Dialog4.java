import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class Dialog4 extends JFrame {
    JTextField tOutput = new JTextField();
    JTextField tInput = new JTextField();
    JButton btnCopy = new JButton("Скопіювати");
    JButton btnPrint = new JButton("Друк");
    JLabel lbl = new JLabel(" ");
    LinkedList<String> list = new LinkedList<String>();

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

        btnPrint.setSize(120, 25);
        btnPrint.setLocation(50, 100);
        c.add(btnPrint);

        btnCopy.setSize(120, 25);
        btnCopy.setLocation(210, 100);
        c.add(btnCopy);

        tInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lbl.setText("Введений текст:" + tInput.getText());
                tOutput.setText(tInput.getText());
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (String item : list) {
                    System.out.println(item);
                }
                System.out.println();
            }
        });

        btnCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tInput.getText();
                StringSelection stringSelection = new StringSelection(text);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                lbl.setText("Текст скопійований в буфер обміну");
                list.add(text);
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