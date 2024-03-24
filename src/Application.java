import author.Author;
import books.Book;
import books.Books;
import library.Library;
import logger.Logger;
import user.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();
        Logger logger = new Logger();
        User user = new User();
        logger.login(user,username,password);
        Author author = new Author("Diyan","Radoslavov","Dimitrov");
        Set<String> tags= new HashSet<>();
        tags.add("jsj");
        Books books = new Book(author,"Nz","Horar","jjds",tags,4.3,"djdjs",2012);
        Books books1 = new Book(author,"fsdfsz","Hordfsdar","jjds",tags,4.3,"djdjs",2002);
        Library library = new Library();
        library.addBook(books);
        library.addBook(books1);
        Supplier<Void> sort = ()-> {
            library.booksSort(201);
            return null;
        };
        Supplier<Void> show = ()-> {
            library.booksAll();
            return null;
        };
        HashMap<String,Supplier<Void>> function = new HashMap<>();
        function.put("sort",sort);
        function.put("show",show);
        while (user.getUsername()!=null){
            String sc = scanner.nextLine();
            function.get(sc).get();
        }

    }
}
