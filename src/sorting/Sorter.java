package sorting;

import books.Books;

import java.util.List;

public class Sorter {
    private SortingAlgorithm sortingAlgorithm;

    public Sorter(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    public void sortAuthor(List<Books> books) {
        this.sortingAlgorithm.sortAuthor(books);
    }

    public void sortTitle(List<Books> books) {
        this.sortingAlgorithm.sortTitle(books);
    }

    public void sortRating(List<Books> books) {
        this.sortingAlgorithm.sortRating(books);
    }

    public void sortYear(List<Books> books) {
        this.sortingAlgorithm.sortYear(books);
    }

    public void setSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
}
