package author;

public class Author implements Comparable<Author>{
    private String firstName;
    private String secondName;
    private String lastName;

    public Author(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Author o) {
        int result = this.getFirstName().compareTo(o.getFirstName());
        if(result==0){
            result = this.getSecondName().compareTo(o.getSecondName());
            if(result==0){
                return this.getLastName().compareTo(o.getLastName());
            }
            return result;
        }
        return  result;
    }

    @Override
    public String toString() {
        return "firstName= " + firstName +" lastName= " + lastName;
    }
}
