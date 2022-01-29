import java.util.Arrays;

public class User {
    private int id;
    private String username;
    private String password;
    private Role[] role;

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role[] getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role[] role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "id = " + id + '\n' +
                "username = " + username + '\n' +
                "password = " + password + '\n' +
                "role = " + Arrays.toString(role);
    }
}