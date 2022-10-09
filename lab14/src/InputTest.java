import java.util.*;
import java.io.*;

public class InputTest {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Нужен параметр вызова: имя файла");
            return;
        }
        String thisLine;
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader fin = null;
        try {
            fin = new BufferedReader(new InputStreamReader(
                    new FileInputStream(args[0])));
            while ((thisLine = fin.readLine()) != null) {
                System.out.println("==Введена строка:" + thisLine);
                list.add(thisLine);
            }
            System.out.println("===Tokens===");
            for (String str : list) {
                System.out.println("=======");
                StringTokenizer st = new StringTokenizer(str);
                while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    
                    String out;
                    try {
                        double tokenDouble = Double.parseDouble(token);
                        out = "Double: " + tokenDouble;
                    } catch (NumberFormatException e) {
                        out = "String: " + token;
                    }

                    System.out.println(out);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + args[0]);
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода. Файл " + args[0]);
            System.out.println("Error: " + e);
        } finally {
            if (fin != null)
                try {
                    fin.close(); // !!! Закрыть файл
                } catch (IOException ex) {
                    System.out.println("Ошибка закрытия файла " + args[0]);
                    System.out.println("Error: " + ex);
                }
            fin = null;
        }
    }
}