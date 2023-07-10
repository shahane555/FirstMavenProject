import java.util.ArrayList;
import java.util.List;

public class Application {

    private static List<String> users = new ArrayList<>();

    public static List<String> getUsers() {
        return users;
    }

    public User register(String name, String surname, String username, String password) {
        if (username.contains("@") && password.length() == 8) {
            for (String s : users) {
                if (s.equals(username)) {
                    throw new IllegalArgumentException();
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        users.add(username);
        return new User(name, surname, username, password);
    }

    public User login(String username, String password) {
        return new User(username, password);
    }

    public void deleteUsers() {
        users.clear();
    }
}
