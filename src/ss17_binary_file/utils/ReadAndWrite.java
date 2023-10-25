package ss17_binary_file.utils;

import ss17_binary_file.models.Spend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void write(String path, List<Spend> spendings) {
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            for (Spend spend : spendings) {
                oos.writeObject(spend);
            }
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi ngoại lệ");
            }
        }
    }

    public static List<Spend> read(String path) {
        List<Spend> spendings = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Spend spending = (Spend) ois.readObject();
                spendings.add(spending);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi ngoại lệ");
            }
        }
        return spendings;
    }
}
