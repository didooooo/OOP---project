package sorting;

import author.Author;
import books.Book;
import books.Books;

import java.util.List;

public class AuthorSort implements GnomeSort {
    @Override
    public void gnomeSort(List<Books> books) {
        int index= 0;
        while (index<books.size()){
            if(index==0){
                index++;
            }
            if(books.get(index).getAuthor().compareTo(books.get(index-1).getAuthor())>0){
                index++;
            }else {
                Books temp;
                temp = books.get(index);
                books.set(index,books.get(index-1));
                books.set(index-1,temp);
                index--;
            }
        }
    }
}
