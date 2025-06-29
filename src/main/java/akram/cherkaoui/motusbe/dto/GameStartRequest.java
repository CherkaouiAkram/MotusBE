package akram.cherkaoui.motusbe.dto;

public class GameStartRequest {
    private String difficulty;

    public GameStartRequest() {
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GameStartRequest)) return false;
        final GameStartRequest other = (GameStartRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$difficulty = this.getDifficulty();
        final Object other$difficulty = other.getDifficulty();
        if (this$difficulty == null ? other$difficulty != null : !this$difficulty.equals(other$difficulty))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GameStartRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $difficulty = this.getDifficulty();
        result = result * PRIME + ($difficulty == null ? 43 : $difficulty.hashCode());
        return result;
    }

    public String toString() {
        return "GameStartRequest(difficulty=" + this.getDifficulty() + ")";
    }
}
