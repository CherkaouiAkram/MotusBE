package akram.cherkaoui.motusbe.dto;

public class GameStartResponse {
    private String word;
    private String gameId;

    public GameStartResponse() {
    }

    public String getWord() {
        return this.word;
    }

    public String getGameId() {
        return this.gameId;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof GameStartResponse)) return false;
        final GameStartResponse other = (GameStartResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$word = this.getWord();
        final Object other$word = other.getWord();
        if (this$word == null ? other$word != null : !this$word.equals(other$word)) return false;
        final Object this$gameId = this.getGameId();
        final Object other$gameId = other.getGameId();
        if (this$gameId == null ? other$gameId != null : !this$gameId.equals(other$gameId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof GameStartResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $word = this.getWord();
        result = result * PRIME + ($word == null ? 43 : $word.hashCode());
        final Object $gameId = this.getGameId();
        result = result * PRIME + ($gameId == null ? 43 : $gameId.hashCode());
        return result;
    }

    public String toString() {
        return "GameStartResponse(word=" + this.getWord() + ", gameId=" + this.getGameId() + ")";
    }
}
