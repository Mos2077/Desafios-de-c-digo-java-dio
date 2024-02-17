import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class UserManager {
    private static UserManager instance;
    private List<User> users;

    private UserManager() {
        users = new ArrayList<>();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(String name) {
        int id = users.size() + 1;
        users.add(new User(id, name));
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user.getId() + " - " + user.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numUsers = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        UserManager userManager = UserManager.getInstance();
        for (int i = 0; i < numUsers; i++) {
            String name = scanner.nextLine();
            userManager.addUser(name);
        }
        userManager.listUsers();
    }
}
