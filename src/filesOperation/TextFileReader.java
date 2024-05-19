package filesOperation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * The TextFileReader class implements the Reader interface and is responsible for reading
 * key-value pairs from a text file where each line
 * contains a key and a value separated by whitespace.
 */
public class TextFileReader implements Reader {
    /**
     * Reads a text file from the specified path and returns a map of key-value pairs.
     * Each line in the file should contain a key and a value separated by whitespace.
     *
     * @param path the path of the text file to read.
     * @return a map containing the key-value pairs read from the file.
     */
    @Override
    public Map<String,String> read(String path) {
        
        HashMap<String, String> users = new HashMap<>();
        try(FileReader fileReader = new FileReader(path)){
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] tokens = line.split("\\s+");
                users.put(tokens[0],tokens[1]);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return users;
    }
}
