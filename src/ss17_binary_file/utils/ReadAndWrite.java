package ss17_binary_file.utils;

import ss17_binary_file.model.Spend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    //    public static List<String> read(String path) {
//        List<String> strings = new ArrayList<>();
//        BufferedReader bufferedReader = null;
//        try {
//            bufferedReader = new BufferedReader(new FileReader(path));
//            String line = "";
//            while ((line = bufferedReader.readLine()) != null) {
//                strings.add(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Lỗi ngoại lệ");
//        } finally {
//            try {
//                if (bufferedReader != null) {
//                    bufferedReader.close();
//                }
//            } catch (IOException e) {
//                System.out.println("Lỗi ngoại lệ");
//            }
//        }
//        return strings;
//    }
//
//    public static void write(List<String> strings, String path) {
//        BufferedWriter bufferedWriter = null;
//        try {
//            bufferedWriter = new BufferedWriter(new FileWriter(path));
//            for (String str : strings) {
//                bufferedWriter.write(str);
//                bufferedWriter.newLine();
//            }
//        } catch (IOException e) {
//            System.out.println("Lỗi ngoại lệ");
//        } finally {
//            try {
//                if (bufferedWriter != null) {
//                    bufferedWriter.close();
//                }
//            } catch (IOException e) {
//                System.out.println("Lỗi ngoại lệ");
//            }
//        }
//    }
    public static void writeFile(List<Spend> spendings, String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Spend spending : spendings) {
                oos.writeObject(spending);
            }
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<Spend> readFile(String path) {
        List<Spend> spendings = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                Spend spending = (Spend) ois.readObject();
                spendings.add(spending);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return spendings;
    }
}