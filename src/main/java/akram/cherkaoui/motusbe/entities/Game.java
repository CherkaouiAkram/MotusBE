package akram.cherkaoui.motusbe.entities;

import akram.cherkaoui.motusbe.enums.Difficulty;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
public class Game {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    private User user;

    private int numberOfAttempts;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    public Game() {
    }

    public UUID getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public int getNumberOfAttempts() {
        return this.numberOfAttempts;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Game)) return false;
        final Game other = (Game) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$numberOfAttempts = this.getNumberOfAttempts();
        final Object other$numberOfAttempts = other.getNumberOfAttempts();
        if (this$numberOfAttempts == null ? other$numberOfAttempts != null : !this$numberOfAttempts.equals(other$numberOfAttempts))
            return false;
        final Object this$difficulty = this.getDifficulty();
        final Object other$difficulty = other.getDifficulty();
        if (this$difficulty == null ? other$difficulty != null : !this$difficulty.equals(other$difficulty))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Game;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $numberOfAttempts = this.getNumberOfAttempts();
        result = result * PRIME + ($numberOfAttempts == null ? 43 : $numberOfAttempts.hashCode());
        final Object $difficulty = this.getDifficulty();
        result = result * PRIME + ($difficulty == null ? 43 : $difficulty.hashCode());
        return result;
    }

    public String toString() {
        return "Game(id=" + this.getId() + ", user=" + this.getUser() + ", numberOfAttempts=" + this.getNumberOfAttempts() + ", difficulty=" + this.getDifficulty() + ")";
    }
}