import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class lab16 {
    private JButton openButton;
    private JButton saveButton;
    private JTextArea TextArea;
    private JTabbedPane tab_pane;
    private JTextField surname;
    private JTextField name;
    private JTextField pib;
    private JTextField nickname;
    private JTextField email;
    private JTextField sex;
    private JTextField count_of_pages_field;
    private JLabel count_contacts;
    private JPanel main_1;
    private JLabel surname_l;
    private JLabel name_l;
    private JLabel pib_l;
    private JLabel nickname_l;
    private JLabel email_l;
    private JLabel sex_l;
    private JPanel main_2;
    private JPanel main_3;
    private JPanel myPanel;
    private JLabel bday_l;
    private JTextField bday;
    private JTextField phone;
    private JLabel phone_l;
    private JLabel city_l;
    private JTextField city;
    private JLabel address_l;
    private JTextField address;
    private JTextArea all_contacts_info;
    private JScrollPane all_contacts;
    private JTextArea zamitka_f;

    private long contacts_count;

    private long get_line_count(String file_name){
        File file = new File(System.getProperty("user.dir")+"//src//"+file_name);
        long lines_count=0;
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                if (sc.nextLine().contains("Додаткова інформація")) lines_count++;
            sc.close();
        }
        catch(Exception e){
            System.out.println("File error!");
            System.exit(-1);
        }
        return lines_count;
    }

    private void printFile(String file_name){
        File file = new File(System.getProperty("user.dir")+"//src//"+file_name);
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                all_contacts_info.append(sc.nextLine()+'\n');
            sc.close();
        }
        catch(Exception e){
            System.out.println("File error!");
        }
    }

    private void file_write(String file_name, String item){
        try(FileWriter fw = new FileWriter(System.getProperty("user.dir")+"//src//"+file_name, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(item);
        } catch (IOException e) {
            System.out.println("Writing error!");
        }
    }
    public lab16() {
        contacts_count=get_line_count("result.txt");
        count_of_pages_field.setText(Long.toString(contacts_count));
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( surname.getText().isEmpty() || name.getText().isEmpty() ||
                    pib.getText().isEmpty() || nickname.getText().isEmpty() ||
                    email.getText().isEmpty() || !(sex.getText().toLowerCase().equals("ч") || sex.getText().toLowerCase().equals("ж")) ||
                    bday.getText().isEmpty() || phone.getText().isEmpty() ||
                    city.getText().isEmpty() || address.getText().isEmpty()) {
                    System.out.println("Заповніть усі поля! (Зверніть увагу на поле Стать)");
                    return;
                }
                try{
                    Person _temp=new Person();
                    _temp.setName(name.getText());
                    _temp.setSurname(surname.getText());
                    _temp.setPib(pib.getText());
                    _temp.setNickname(nickname.getText());
                    _temp.setEmail(email.getText());
                    String gender=sex.getText().toLowerCase().equals("ч") ? "чоловіча" : "жіноча";
                    _temp.setSex(gender);
                    _temp.setBday(new SimpleDateFormat("dd/MM/yyyy").parse(bday.getText()));
                    _temp.setPhone(phone.getText());
                    _temp.setAddress(address.getText());
                    _temp.setCity(city.getText());
                    if (!zamitka_f.getText().isEmpty()) _temp.setMemo(zamitka_f.getText());
                    file_write("result.txt",_temp.toString());
                    if(openButton.getText().equals("Закрити")){
                        all_contacts_info.append(_temp.toString());
                    }
                } catch (Exception ex) {
                    System.out.println("Перевірте правильність введених данних!");
                    return;

                }
                finally {
                    surname.setText("");
                    name.setText("");
                    pib.setText("");
                    nickname.setText("");
                    email.setText("");
                    sex.setText("");
                    bday.setText("");
                    phone.setText("");
                    city.setText("");
                    address.setText("");
                    zamitka_f.setText("");
                }
                contacts_count++;
                count_of_pages_field.setText(Long.toString(contacts_count));
                System.out.println("Запис успішно доданий!");
            }
        });
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btext=openButton.getText();
                if(btext.equals("Відкрити")){
                    printFile("result.txt");
                    openButton.setText("Закрити");
                }
                else{
                    all_contacts_info.setText("");
                    openButton.setText("Відкрити");
                }
            }
        });
    }

    public static void main(String[] args){
        JFrame frame=new JFrame("Записна книга");
        frame.setContentPane(new lab16().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
