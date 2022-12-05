package ReadAndWrite;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadAndWriteAccount {
     static String url = "acount.txt";
    public static void writeAccount(Map<String, String> manageAccount) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(url);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(manageAccount);
            outputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Map<String, String> readAccount() {
        try {
            FileInputStream fileInputStream = new FileInputStream(url);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, String>) objectInputStream.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
