import filesOperation.TextFileReader;
import filesOperation.TextFileWriter;
import library.Library;
import logger.LogOperation;
import logger.Logger;
import menu.*;
import register.Register;
import register.RegisterOperation;
import sorting.GnomeSort;
import sorting.Sorter;
import sorting.SortingAlgorithm;
import user.User;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SortingAlgorithm sorter = new GnomeSort();
        Sorter sorter1 = new Sorter(sorter);
        Library library= new Library(sorter1,new User());
        LogOperation logOperation = new Logger(new TextFileReader());
        RegisterOperation registerOperation = new Register(new TextFileWriter(),new TextFileReader());
        Engine engine = new EngineImpl(new Scanner(System.in),library,logOperation,registerOperation);
        engine.run();
    }
}
