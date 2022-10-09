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
            Collections.sort(list);
            System.out.println("Отсортированный список строк:");
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                String str = (String) iter.next();
                System.out.println(str);
            }

            if (args.length == 2) {
                System.out.println("Пошук:");
                String search = args[1];
                for (String str : list) {
                    if (str.contains(search)) {
                        System.out.println(str);
                    }
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