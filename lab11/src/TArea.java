import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TArea extends JFrame {
    JTextArea txt = new JTextArea(20, 15);
    MathFunction mathFunction = new MathFunction(0, 0, 0);
    JTextField aField = new JTextField(5);
    JTextField hField = new JTextField(5);
    JTextField nField = new JTextField(5);

    TArea() {
        super("Табличне значення функції");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        setSize(500, 400);
        Container c = getContentPane();

        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        c.add(pane);

        JLabel label = new JLabel("Функція: Y = A*Math.sqrt(X)*Math.sin(A*X)");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(label);

        JPanel dataPanel = new JPanel(new FlowLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Параметри функції"));

        JLabel aLabel = new JLabel("Параметр А:");
        aField.setText(String.valueOf(mathFunction.getA()));
        JLabel hLabel = new JLabel("Крок(h):");
        hField.setText(String.valueOf(mathFunction.getH()));
        JLabel nLabel = new JLabel("Кількість точок:");
        nField.setText(String.valueOf(mathFunction.getN()));

        dataPanel.add(aLabel);
        dataPanel.add(aField);
        dataPanel.add(hLabel);
        dataPanel.add(hField);
        dataPanel.add(nLabel);
        dataPanel.add(nField);

        pane.add(dataPanel);

        Font font = txt.getFont();
        float size = font.getSize() + 1.0f;
        txt.setFont(font.deriveFont(size));
        pane.add(txt);

        JScrollPane scroll = new JScrollPane(txt);
        pane.add(scroll);

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        aField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                String textField = aField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                double a = Double.parseDouble(aField.getText());
                mathFunction.setA(a);
                setTxt();
            }

            public void removeUpdate(DocumentEvent e) {
                String textField = aField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                double a = Double.parseDouble(aField.getText());
                mathFunction.setA(a);
                setTxt();
            }

            public void insertUpdate(DocumentEvent e) {
                String textField = aField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                double a = Double.parseDouble(aField.getText());
                mathFunction.setA(a);
                setTxt();
            }
        });

        hField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                String textField = hField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                double h = Double.parseDouble(hField.getText());
                mathFunction.setH(h);
                setTxt();
            }

            public void removeUpdate(DocumentEvent e) {
                String textField = hField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                double h = Double.parseDouble(hField.getText());
                mathFunction.setH(h);
                setTxt();
            }

            public void insertUpdate(DocumentEvent e) {
                String textField = hField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                double h = Double.parseDouble(hField.getText());
                mathFunction.setH(h);
                setTxt();
            }
        });

        nField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                String textField = nField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                int n = Integer.parseInt(nField.getText());
                mathFunction.setN(n);
                setTxt();
            }

            public void removeUpdate(DocumentEvent e) {
                String textField = nField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                int n = Integer.parseInt(nField.getText());
                mathFunction.setN(n);
                setTxt();
            }

            public void insertUpdate(DocumentEvent e) {
                String textField = nField.getText();
                if (textField.isEmpty()) {
                    setTxt();
                    return;
                }

                int n = Integer.parseInt(nField.getText());
                mathFunction.setN(n);
                setTxt();
            }
        });

        setTxt();
        setVisible(true);
    }

    public void setTxt() {
        txt.setText("");

        double a;
        String aFieldText = aField.getText();
        if (aFieldText.isEmpty()) {
            a = 0;
        } else {
            a = Double.parseDouble(aFieldText);
        }

        double h;
        String hFieldText = hField.getText();
        if (hFieldText.isEmpty()) {
            h = 0;
        } else {
            h = Double.parseDouble(hFieldText);
        }

        int n;
        String nFieldText = nField.getText();
        if (nFieldText.isEmpty()) {
            n = 0;
        } else {
            n = Integer.parseInt(nFieldText);
        }

        mathFunction = new MathFunction(a, h, n);
        List<PointXY> points = mathFunction.getPoints();
        points.forEach(point -> txt.append("   " + point.toString() + "\n"));
    }

    public static void main(String[] args) {
        new TArea();
    }
}