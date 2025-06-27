package akram.cherkaoui.motusbe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
public class WallOfFame {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    private User user;

    private int score;

    public WallOfFame() {
    }

    public UUID getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public int getScore() {
        return this.score;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof WallOfFame)) return false;
        final WallOfFame other = (WallOfFame) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        if (this.getScore() != other.getScore()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof WallOfFame;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        result = result * PRIME + this.getScore();
        return result;
    }

    public String toString() {
        return "WallOfFame(id=" + this.getId() + ", user=" + this.getUser() + ", score=" + this.getScore() + ")";
    }
}
