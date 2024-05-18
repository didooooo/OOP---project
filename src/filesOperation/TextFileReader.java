package filesOperation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TextFileReader implements Reader {
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
