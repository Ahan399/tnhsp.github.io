public class User {
    private String name;
    private  int id;
    private String birth;

    public User() {
    }

    public User(String name, int id, String birth) {
        this.name = name;
        this.id = id;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String toString() {
        return "User.....";
    }
}
