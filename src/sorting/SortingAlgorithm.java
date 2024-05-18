package sorting;

import books.Books;

import java.util.List;

public interface SortingAlgorithm {
    void sortAuthor(List<Books> books);
    void sortRating(List<Books> books);
    void sortTitle(List<Books> books);
    void sortYear(List<Books> books);
}
