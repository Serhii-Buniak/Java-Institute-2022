import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JRadioButtonActionListener {
    private static JFrame frame = new JFrame("Grouping Example");
    private static JPanel panel = new JPanel();
    private static JLabel titleLabel = new JLabel();
    private static ButtonGroup group = new ButtonGroup();
    private static JRadioButton aRadioButton = new JRadioButton();
    private static JRadioButton bRadioButton = new JRadioButton();
    private static JRadioButton cRadioButton = new JRadioButton();
    private static JRadioButton dRadioButton = new JRadioButton();
    private static JRadioButton eRadioButton = new JRadioButton();

    private static Test test = new Test(new ArrayList<Task>() {
        {
            add(new Task("First 1", new ArrayList<String>() {
                {
                    add("A-1");
                    add("B-1");
                    add("C-1");
                    add("D-1");
                    add("E-1");
                }
            }, "A-1"));
            add(new Task("First 2", new ArrayList<String>() {
                {
                    add("A-2");
                    add("B-2");
                    add("C-2");
                    add("D-2");
                    add("E-2");
                }
            }, "E-2"));
            add(new Task("First 3", new ArrayList<String>() {
                {
                    add("A-3");
                    add("B-3");
                    add("C-3");
                    add("D-3");
                    add("E-3");
                }
            }, "B-3"));
            add(new Task("First 4", new ArrayList<String>() {
                {
                    add("A-4");
                    add("B-4");
                    add("C-4");
                    add("D-4");
                    add("E-4");
                }
            }, "D-4"));
            add(new Task("First 5", new ArrayList<String>() {
                {
                    add("A-5");
                    add("B-5");
                    add("C-5");
                    add("D-5");
                    add("E-5");
                }
            }, "A-5"));
        }
    });

    private static Task currTask;
    private static String selected = null;
    private static double totalPoint = 0;

    public static void main(String args[]) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout());
        frame.add(panel);

        JPanel testWrapper = new JPanel();
        testWrapper.setLayout(new BoxLayout(testWrapper, BoxLayout.Y_AXIS));

        testWrapper.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(5, 5, 5, 5),
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createRaisedSoftBevelBorder(),
                                BorderFactory.createEmptyBorder(5, 5, 5, 5))));

        titleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        testWrapper.add(titleLabel);
        panel.add(testWrapper, BorderLayout.CENTER);

        group.add(aRadioButton);
        group.add(bRadioButton);
        group.add(cRadioButton);
        group.add(dRadioButton);
        group.add(eRadioButton);
        testWrapper.add(aRadioButton);
        testWrapper.add(bRadioButton);
        testWrapper.add(cRadioButton);
        testWrapper.add(dRadioButton);
        testWrapper.add(eRadioButton);

        nextTask();

        ActionListener sliceActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton aButton = (AbstractButton) actionEvent.getSource();
                String text = aButton.getText();
                System.out.println("Selected: " + text);
                selected = text;
            }
        };

        aRadioButton.addActionListener(sliceActionListener);
        bRadioButton.addActionListener(sliceActionListener);
        cRadioButton.addActionListener(sliceActionListener);
        dRadioButton.addActionListener(sliceActionListener);
        eRadioButton.addActionListener(sliceActionListener);

        JPanel btnWrapper = new JPanel();
        btnWrapper.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(5, 5, 5, 5),
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createRaisedSoftBevelBorder(),
                                BorderFactory.createEmptyBorder(15, 15, 15, 15))));

        JButton btnNext = new JButton("Далі");
        ActionListener btnNextActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (selected == null) {
                    return;
                }

                Boolean isCorrect = currTask.getCorrectAnswer() == selected;
                if (isCorrect) {
                    totalPoint += 5;
                } else {
                    totalPoint += 2;
                }
                group.clearSelection();
                nextTask();
            }
        };
        btnNext.addActionListener(btnNextActionListener);

        btnWrapper.add(btnNext);
        panel.add(btnWrapper, BorderLayout.SOUTH);

        frame.setSize(400, 300);
        frame.setVisible(true);

    }

    private static void nextTask() {
        try {
            currTask = test.Next();
            titleLabel.setText(currTask.getTitle());
            aRadioButton.setText(currTask.getAnswers().get(0));
            bRadioButton.setText(currTask.getAnswers().get(1));
            cRadioButton.setText(currTask.getAnswers().get(2));
            dRadioButton.setText(currTask.getAnswers().get(3));
            eRadioButton.setText(currTask.getAnswers().get(4));
        } catch (Exception e) {
            panel.removeAll();
            frame.setLayout(null);
            panel.setLayout(new FlowLayout());
            JLabel res = new JLabel("Points: " + totalPoint / test.getTasks().size(), JLabel.CENTER);
            res.setFont(new Font("Serif", Font.PLAIN, 30));
            panel.add(res);
        }
    }
}