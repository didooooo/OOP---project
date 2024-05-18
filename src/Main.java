import filesOperation.TextFileReader;
import filesOperation.TextFileWriter;
import library.Library;
import logger.Logger;
import menu.*;
import register.Register;
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
        Controller controller = new ControllerImpl(library,new Logger(new TextFileReader()),new Register(new TextFileWriter(),new TextFileReader(),new User(), library.getUser()));
        CommandImpl command = new CommandImpl(controller);
        Engine engine = new EngineImpl(new Scanner(System.in),controller,command,library);
      //  Object booksAll = menu.CommandImpl.class.getMethod("booksAll").invoke(command);
        //Object login = menu.CommandImpl.class.getMethod("login", String[].class, User.class).invoke(command,new String[]{"admin","i<3c++","Users.txt"},new User());
        // method.invoke(command);
        //System.out.println(test);
        engine.run();
    }
}