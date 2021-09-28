package registration;

public class User {
    private Long id;
    private String name;
    private int age;
    private String password;

    public void setId(Long d) {
        id=d;
    }

    public Long getId() {
        return id;
    }

    public void setName(String nm) {
        name=nm;
    }

    public String getName() {
        return name;
    }

    public void setAge(int n) {
        age=n;
    }

    public int getAge() {
        return age;
    }

    public void setPass(String ps) {
        password=ps;
    }

    public String getPass() {
        return password;
    }
}
