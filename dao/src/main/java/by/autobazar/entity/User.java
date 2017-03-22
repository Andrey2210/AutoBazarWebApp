package by.autobazar.entity;

/**
 * Created by Andrey on 21.02.2017.
 */
public class User implements Entity{
    private long id;
    private String login;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String role;

    public User() {
    }

    public User(long id, String login, String email, String password, String name, String phone, String role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.role = role;
    }

    public User(String login, String email, String password, String name, String phone) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
