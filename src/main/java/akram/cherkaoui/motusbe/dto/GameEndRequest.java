package akram.cherkaoui.motusbe.dto;

public class GameEndRequest {

    private String nbAttempts;
    private String gameId;

    public GameEndRequest() {
    }

    public String getNbAttempts() {
        return this.nbAttempts;
    }

    public String getGameId() {
        return this.gameId;
    }

    public void setNbAttempts(String nbAttempts) {
        this.nbAttempts = nbAttempts;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String toString() {
        return "GameEndRequest(nbAttempts=" + this.getNbAttempts() + ", gameId=" + this.getGameId() + ")";
    }
}
