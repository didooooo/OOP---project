import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Library {
    List<Books> books = new ArrayList<>();
    public void booksAll(){
        if(!books.isEmpty()) {
            for (Books b : books){
                System.out.printf("%s %s %s %s%n",b.getTitle(),b.getAuthor().toString(),b.getGenre(),b.getIsbn());
            }
        }
    }
    public void booksInfo(String isbn){
        if(!books.isEmpty()){
            for (Books b : books){
                if(b.getIsbn().equalsIgnoreCase(isbn)){
                    System.out.printf("%s %s %s %s%n Description:%n %s%n",b.getTitle(),b.getAuthor(),b.getIsbn(),b.getGenre(),b.getDescription());
                }
            }
        }
    }

    public void booksFindTitle(String title){
        if(!books.isEmpty()){
            for (Books b : books){
                if(b.getTitle().equalsIgnoreCase(title)){
                    System.out.printf("%s %s %s %s%n Description:%n %s%n",b.getTitle(),b.getAuthor(),b.getIsbn(),b.getGenre(),b.getDescription());

                }
            }
        }
    }
    public void booksFindTag(String tag){
        if(!books.isEmpty()){
            for (Books b : books){
                if(b.getTags().contains(tag.toLowerCase())){
                    System.out.printf("%s %s %s %s%n Description:%n %s%n",b.getTitle(),b.getAuthor(),b.getIsbn(),b.getGenre(),b.getDescription());

                }
            }
        }
    }
    public void booksFindAuthor(Author author){
        if(!books.isEmpty()){
            for (Books b : books){
                if(b.getAuthor().equals(author)){
                    System.out.printf("%s %s %s %s%n Description:%n %s%n",b.getTitle(),b.getAuthor(),b.getIsbn(),b.getGenre(),b.getDescription());

                }
            }
        }
    }

    public void booksSort(int year){

    }
    public void booksSort(int year, String desc){

    }
}
