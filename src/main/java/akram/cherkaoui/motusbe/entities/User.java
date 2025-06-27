package akram.cherkaoui.motusbe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String pseudo;
    private String email;
    private String password;
    private int bestStrike;
    private int currentStrike;

    public User() {
    }


    public UUID getId() {
        return this.id;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public int getBestStrike() {
        return this.bestStrike;
    }

    public int getCurrentStrike() {
        return this.currentStrike;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBestStrike(int bestStrike) {
        this.bestStrike = bestStrike;
    }

    public void setCurrentStrike(int currentStrike) {
        this.currentStrike = currentStrike;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        final User other = (User) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$pseudo = this.getPseudo();
        final Object other$pseudo = other.getPseudo();
        if (this$pseudo == null ? other$pseudo != null : !this$pseudo.equals(other$pseudo)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        if (this.getBestStrike() != other.getBestStrike()) return false;
        if (this.getCurrentStrike() != other.getCurrentStrike()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof User;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $pseudo = this.getPseudo();
        result = result * PRIME + ($pseudo == null ? 43 : $pseudo.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        result = result * PRIME + this.getBestStrike();
        result = result * PRIME + this.getCurrentStrike();
        return result;
    }

    public String toString() {
        return "User(id=" + this.getId() + ", pseudo=" + this.getPseudo() + ", email=" + this.getEmail() + ", password=" + this.getPassword() + ", bestStrike=" + this.getBestStrike() + ", currentStrike=" + this.getCurrentStrike() + ")";
    }
}

