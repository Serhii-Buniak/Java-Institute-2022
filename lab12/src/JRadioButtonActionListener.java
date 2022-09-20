import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JRadioButtonActionListener {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Grouping Example");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

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

        JLabel titleLabel = new JLabel("Test");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        testWrapper.add(titleLabel);
        panel.add(testWrapper, BorderLayout.CENTER);

        ButtonGroup group = new ButtonGroup();
        JRadioButton aRadioButton = new JRadioButton("A");
        JRadioButton bRadioButton = new JRadioButton("B");
        JRadioButton cRadioButton = new JRadioButton("С");
        JRadioButton dRadioButton = new JRadioButton("d");
        JRadioButton eRadioButton = new JRadioButton("e");

        testWrapper.add(aRadioButton);
        testWrapper.add(bRadioButton);
        testWrapper.add(cRadioButton);
        testWrapper.add(dRadioButton);
        testWrapper.add(eRadioButton);

        group.add(aRadioButton);
        group.add(bRadioButton);
        group.add(cRadioButton);
        group.add(bRadioButton);
        group.add(eRadioButton);

        JPanel btnWrapper = new JPanel();
        btnWrapper.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(5, 5, 5, 5),
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createRaisedSoftBevelBorder(),
                                BorderFactory.createEmptyBorder(15, 15, 15, 15))));

        JButton btnNext = new JButton("Далі");
        btnWrapper.add(btnNext);
        panel.add(btnWrapper, BorderLayout.SOUTH);

        ActionListener sliceActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton aButton = (AbstractButton) actionEvent.getSource();
                System.out.println("Selected: " + aButton.getText());
            }
        };

        aRadioButton.addActionListener(sliceActionListener);
        bRadioButton.addActionListener(sliceActionListener);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}