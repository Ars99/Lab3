package Entities;

import javax.persistence.*;

@Entity
@Table(name = "login_hash", schema = "public", catalog = "login_password")
public class LoginHashEntity {
    private int id;
    private String login;
    private String hash;

    public LoginHashEntity(){}
    public LoginHashEntity(String login, String hash){
        this.login = login;
        this.hash = hash;
        this.id = this.hashCode();
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "hash", nullable = false, length = 50)
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginHashEntity that = (LoginHashEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        return result;
    }
}
