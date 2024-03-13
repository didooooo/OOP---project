import java.util.List;

public class TitleSort implements GnomeSort{
    @Override
    public void gnomeSort(List<Books> books) {
        int index= 0;
        while (index<books.size()){
            if(index==0){
                index++;
            }
            if(books.get(index).getTitle().compareTo(books.get(index-1).getTitle())>0){
                index++;
            }else {
                String temp;
                temp = books.get(index).getTitle();
                books.get(index).setTitle(books.get(index-1).getTitle());
                books.get(index-1).setTitle(temp);
                index--;
            }
        }
    }
}
