package sorting;

import books.Books;

import java.util.List;

/**
 * The GnomeSort class implements the SortingAlgorithm interface and provides
 * methods to perform Gnome Sort on a list of books based on different criteria.
 */
public class GnomeSort implements SortingAlgorithm {
    @Override
    public void sortAuthor(List<Books> books) {
        int index = 0;
        while (index < books.size()) {
            if (index == 0) {
                index++;
            }
            if (books.get(index).getAuthor().compareTo(books.get(index - 1).getAuthor()) > 0) {
                index++;
            } else {
                Books temp;
                temp = books.get(index);
                books.set(index, books.get(index - 1));
                books.set(index - 1, temp);
                index--;
            }
        }
    }

    @Override
    public void sortRating(List<Books> books) {
        int index = 0;
        while (index < books.size()) {
            if (index == 0) {
                index++;
            }
            if (books.get(index).getRating() >= books.get(index - 1).getRating()) {
                index++;
            } else {
                Books temp;
                temp = books.get(index);
                books.set(index, books.get(index - 1));
                books.set(index - 1, temp);
                index--;
            }
        }
    }

    @Override
    public void sortTitle(List<Books> books) {
        int index = 0;
        while (index < books.size()) {
            if (index == 0) {
                index++;
            }
            if (books.get(index).getTitle().compareTo(books.get(index - 1).getTitle()) > 0) {
                index++;
            } else {
                Books temp;
                temp = books.get(index);
                books.set(index, books.get(index - 1));
                books.set(index - 1, temp);
                index--;
            }
        }
    }

    @Override
    public void sortYear(List<Books> books) {
        int index = 0;
        while (index < books.size()) {
            if (index == 0) {
                index++;
            }
            if (books.get(index).getYear() >= books.get(index - 1).getYear()) {
                index++;
            } else {
                Books temp;
                temp = books.get(index);
                books.set(index, books.get(index - 1));
                books.set(index - 1, temp);
                index--;
            }
        }
    }
}
