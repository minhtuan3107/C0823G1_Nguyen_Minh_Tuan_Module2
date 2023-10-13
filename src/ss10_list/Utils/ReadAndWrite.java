package ss10_list.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<String> read(String path) {
        BufferedReader bufferedReader = null;
        List<String> stringList = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringList.add(str);
            }
        } catch (IOException e) {
            System.out.println("Lỗi ngoại lệ");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Lỗi ngoại lệ");
            }
        }
        return stringList;
    }

    public static void write(List<String> stringList, String path) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (String str : stringList) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ngoại lệ");
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            }catch (FileNotFoundException e){
                System.out.println("Không tìm thấy FILE");
            } catch (IOException e) {
                System.out.println("Lỗi ngoại lệ");
            }
        }
    }
}
