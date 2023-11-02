package case_studyTest.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static List<String> readFile(String pathname) {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        List<String> data = new ArrayList<>();
        try {
            File file = new File(pathname);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                data.add(str);
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void writeFile(String pathname, List<String> data, boolean flag){
        FileWriter fileWriter= null;
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(pathname);
            fileWriter = new FileWriter(file,flag);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(String str : data){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        } finally {
            try {
                if(bufferedWriter!= null){
                    bufferedWriter.close();
                }
                if(fileWriter!= null){
                    fileWriter.close();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }
}
