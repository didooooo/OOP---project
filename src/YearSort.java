import java.util.List;

public class YearSort implements GnomeSort{
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
                int temp=0;
                temp = books.get(index).getYear();
                books.get(index).setYear(books.get(index-1).getYear());
                books.get(index-1).setYear(temp);
                index--;
            }
        }
    }
}
