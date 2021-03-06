public class Role {
    private String name;
    private String authority;

    public Role(String name, String authority) {
        this.name = name;
        this.authority = authority;
    }

    public String getName() {
        return name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "name = " + name + ',' +
                " authority = " + authority ;
    }


}