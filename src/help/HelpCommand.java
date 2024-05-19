package help;

public class HelpCommand {
    /**
     * prints the methods
     */
    public void help() {
        System.out.println("The following commands are supported:\n" +
                "open <file>              opens <file>\n" +
                "close                    closes currently opened file\n" +
                "save                     saves the currently open file\n" +
                "saveas <file>            saves the currently open file in <file>\n" +
                "help                     prints this information\n" +
                "exit                     exists the program\n" +
                "login                    sign in the user\n" +
                "logout                   sign out the user\n" +
                "books all                show the information about the books\n" +
                "books info <isbn_value>  search a book by isbn\n" +
                "books find \t<option> <option_string>  option is one of the following\n" +
                "                                        {title,author,tag}\n " +
                "                                        <option_string> is the criteria\n" +
                "books sort <option> [desc]\n " +
                "                          <option> ={title,author,year,rating} by default asc\n" +
                "users add <user> <password>\n " +
                "                           add a new user\n" +
                "users remove <user_name> \n" +
                "                           remove a user by given user_name\n" +
                "books add                  add a new book\n" +
                "books remove               remove a book\n"
        );
    }
}
