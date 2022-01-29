public class Main {
    public static void main(String[] args) {
        User user = new User(12345, "Denis", "qwerty123");

        user.setRole(new Role[]{new Role("role1", "ROLE_1"), new Role("fdgdfg", "fdgdfg")});

        System.out.println(user.toString());
    }
}