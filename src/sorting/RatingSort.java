package sorting;

import books.Books;
import sorting.GnomeSort;

import java.util.List;

public class RatingSort implements GnomeSort {
    @Override
    public void gnomeSort(List<Books> books) {
        int index= 0;
        while (index<books.size()){
            if(index==0){
                index++;
            }
            if(books.get(index).getRating()>=books.get(index-1).getRating()){
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
