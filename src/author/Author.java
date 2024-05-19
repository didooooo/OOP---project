package author;

import java.util.Objects;

/**
 * The Author class represents an author with a first name and a last name.
 * It implements the Comparable interface to allow for comparison based on the author's name.
 */
public class Author implements Comparable<Author> {
    private String firstName;
    private String lastName;

    /**
     * Constructs an Author instance with the specified first name and last name.
     *
     * @param firstName the first name of the author.
     * @param lastName  the last name of the author.
     */
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Compares this author to another author based on their first and last names.
     *
     * @param o the other author to compare to.
     * @return a negative integer, zero, or a positive integer as this author is less than, equal to,
     * or greater than the specified author.
     */
    @Override
    public int compareTo(Author o) {
        int result = this.getFirstName().compareTo(o.getFirstName());
        if (result == 0) {
            return this.getLastName().compareTo(o.getLastName());
        }
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "firstName= " + firstName + " lastName= " + lastName;
    }
}
