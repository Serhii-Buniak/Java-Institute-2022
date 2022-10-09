import java.io.*;

public class InputTest {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Нужен параметр вызова: имя папки");
            return;
        }
        File folder = new File(args[0]);

        if (!folder.isDirectory()) {
            System.out.println(args[0] + " is not Directory");
            return;
        }

        do {
            File[] files = folder.listFiles();
            if (files.length == 0) {
                System.out.println(args[0] + " this Directory is empty");
                return;
            }

            System.out.println("===Files===");
            for (File file : files) {
                System.out.println(file.getName());
            }

            System.out.println("Write filename (exit 0):");
            String filename = System.console().readLine();
            if (filename.equals("0")) {
                return;
            }

            String confirm;
            do {
                System.out.println("Confirm (Y/N)");
                confirm = System.console().readLine();
                if (confirm.equals("N")) {
                    break;
                }
                if (!confirm.equals("Y")) {
                    continue;
                }

                for (File file : files) {
                    if (file.getName().equals(filename)) {
                        file.delete();
                    }
                }
                break;
            } while (true);

        } while (true);
    }
}