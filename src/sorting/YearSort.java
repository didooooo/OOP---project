package sorting;

import books.Books;
import sorting.GnomeSort;

import java.util.List;

public class YearSort implements GnomeSort {
    @Override
    public void gnomeSort(List<Books> books) {
        int index= 0;
        while (index<books.size()){
            if(index==0){
                index++;
            }
            if(books.get(index).getYear()>=books.get(index-1).getYear()){
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
