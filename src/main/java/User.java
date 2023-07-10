public class User {
    private String name;
    private String surname;
    private String username;

    public String getPassword() {
        return password;
    }

    private String password;


    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            if (this.username.equals(((User) o).username) && this.password.equals(((User) o).password)) {
                return true;
            }
        }
        return false;
    }
}

