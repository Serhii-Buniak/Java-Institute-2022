import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;

public class App {
    private static List<Person> persons = new ArrayList<Person>();

    private static List<Person> filterPersons(String name) {
        List<Person> temp = new ArrayList<Person>();
        persons.forEach(person -> {
            if (person.getName().contains(name)) {
                temp.add(person);
            }
        });
        return temp;
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(340, 180);
        jf.setLayout(new BorderLayout());
        jf.setResizable(false);

        Container contentPane = jf.getContentPane();

        JPanel form = new JPanel(new GridLayout(3, 1));

        JPanel nameWrapper = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("Прізвище");

        JPanel nameFieldWrapper = new JPanel();
        JTextField nameField = new JTextField(20);

        nameFieldWrapper.add(nameField, BorderLayout.LINE_END);
        nameWrapper.add(nameLabel, BorderLayout.LINE_START);
        nameWrapper.add(nameFieldWrapper, BorderLayout.LINE_END);

        JPanel phoneWrapper = new JPanel(new BorderLayout());
        JLabel phoneLabel = new JLabel("Телефон");

        JPanel phoneFieldWrapper = new JPanel();
        JTextField phoneField = new JTextField(20);

        phoneFieldWrapper.add(phoneField, BorderLayout.LINE_END);
        phoneWrapper.add(phoneLabel, BorderLayout.LINE_START);
        phoneWrapper.add(phoneFieldWrapper, BorderLayout.LINE_END);

        JPanel btnWrapper = new JPanel(new FlowLayout());
        JButton printBtn = new JButton("Друк");
        JButton resetBtn = new JButton("Очистити");
        JButton createBtn = new JButton("Створити");

        btnWrapper.add(printBtn);
        btnWrapper.add(resetBtn);
        btnWrapper.add(createBtn);

        form.add(nameWrapper);
        form.add(phoneWrapper);
        form.add(btnWrapper);

        form.setBackground(Color.LIGHT_GRAY);
        form.setBorder(BorderFactory.createRaisedBevelBorder());

        JPanel counter = new JPanel(new FlowLayout());
        counter.setSize(400, 50);
        counter.setBackground(Color.LIGHT_GRAY);
        counter.setBorder(BorderFactory.createRaisedBevelBorder());

        JLabel counterLabel = new JLabel("Кількість всіх записів");
        JTextField counterField = new JTextField(5);
        counterField.setText(String.valueOf(persons.size()));
        counterField.setEnabled(false);
        counter.add(counterLabel);
        counter.add(counterField);

        contentPane.add(form, BorderLayout.CENTER);
        contentPane.add(counter, BorderLayout.SOUTH);

        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                phoneField.setText("");
                counterField.setText(String.valueOf(persons.size()));
                counterLabel.setText("Кількість всіх записів");
            }
        });

        createBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                persons.add(new Person(nameField.getText(), phoneField.getText()));
                counterField.setText(String.valueOf(persons.size()));
                nameField.setText("");
                phoneField.setText("");
                counterField.setText(String.valueOf(persons.size()));
                counterLabel.setText("Кількість всіх записів");
            }
        });

        printBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Person> temp = filterPersons(nameField.getText());
                temp.forEach(person -> {
                    System.out.println(person);
                });
                System.out.println();
            }
        });

        nameField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                if (nameField.getText() == "") {
                    counterLabel.setText("Кількість всіх записів");
                } else {
                    counterLabel.setText("Кількість знайдених записів");
                }
                List<Person> temp = filterPersons(nameField.getText());
                counterField.setText(String.valueOf(temp.size()));
            }

            public void removeUpdate(DocumentEvent e) {
                if (nameField.getText().isEmpty()) {
                    counterLabel.setText("Кількість всіх записів");
                } else {
                    counterLabel.setText("Кількість знайдених записів");
                }
                List<Person> temp = filterPersons(nameField.getText());
                counterField.setText(String.valueOf(temp.size()));
            }

            public void insertUpdate(DocumentEvent e) {
                if (nameField.getText() == "") {
                    counterLabel.setText("Кількість всіх записів");
                } else {
                    counterLabel.setText("Кількість знайдених записів");
                }

                List<Person> temp = filterPersons(nameField.getText());
                counterField.setText(String.valueOf(temp.size()));
            }
        });

        jf.setVisible(true);
    }
}