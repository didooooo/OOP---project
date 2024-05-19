package sorting;

import books.Books;

import java.util.List;

/**
 * The Sorter class provides methods for sorting a list of books using different sorting algorithms.
 */
public class Sorter {
    private SortingAlgorithm sortingAlgorithm;

    /**
     * Constructs a Sorter object with the specified sorting algorithm.
     *
     * @param sortingAlgorithm The sorting algorithm to be used by the Sorter.
     */
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

    /**
     * Sets the sorting algorithm to be used by the Sorter.
     *
     * @param sortingAlgorithm The sorting algorithm to be set.
     */
    public void setSortingAlgorithm(SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
}
