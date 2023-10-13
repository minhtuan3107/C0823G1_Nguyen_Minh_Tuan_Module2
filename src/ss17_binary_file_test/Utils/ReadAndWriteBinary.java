package ss17_binary_file_test.Utils;

import ss17_binary_file_test.model.Spend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteBinary {
    public static void writeFile(List<Spend> spendList,String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            for (Spend spend :spendList ) {
                oos.writeObject(spend);
            }
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static List<Spend> readFile(String path) {
        List<Spend> spendList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                Spend spending = (Spend) ois.readObject();
                spendList.add(spending);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return spendList;
    }
}