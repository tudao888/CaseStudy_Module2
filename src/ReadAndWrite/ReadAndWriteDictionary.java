package ReadAndWrite;

import ManageDictionary.Word;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadAndWriteDictionary {
    public static void writeDictionary(Map<String, Word> wordList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("WordOfDictionary.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(wordList);
            outputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
        }
    }

    public static Map<String, Word> readDictionary() {
        try {
            FileInputStream fileInputStream = new FileInputStream("WordOfDictionary.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Map<String, Word>) objectInputStream.readObject();
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
