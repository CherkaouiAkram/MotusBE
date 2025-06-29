package akram.cherkaoui.motusbe.dto;

import java.util.UUID;

public class LeaderboardEntryDTO {
    public UUID id;
    public String username;
    public int totalGames;
    public int wins;
    public double winRate;
    public double averageAttempts;
    public int bestStreak;
    public int currentStreak;
    public int totalScore;
    public int easyWins;
    public int mediumWins;
    public int hardWins;

    public LeaderboardEntryDTO() {
    }

    public UUID getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public int getTotalGames() {
        return this.totalGames;
    }

    public int getWins() {
        return this.wins;
    }

    public double getWinRate() {
        return this.winRate;
    }

    public double getAverageAttempts() {
        return this.averageAttempts;
    }

    public int getBestStreak() {
        return this.bestStreak;
    }

    public int getCurrentStreak() {
        return this.currentStreak;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    public int getEasyWins() {
        return this.easyWins;
    }

    public int getMediumWins() {
        return this.mediumWins;
    }

    public int getHardWins() {
        return this.hardWins;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public void setAverageAttempts(double averageAttempts) {
        this.averageAttempts = averageAttempts;
    }

    public void setBestStreak(int bestStreak) {
        this.bestStreak = bestStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void setEasyWins(int easyWins) {
        this.easyWins = easyWins;
    }

    public void setMediumWins(int mediumWins) {
        this.mediumWins = mediumWins;
    }

    public void setHardWins(int hardWins) {
        this.hardWins = hardWins;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof LeaderboardEntryDTO)) return false;
        final LeaderboardEntryDTO other = (LeaderboardEntryDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        if (this.getTotalGames() != other.getTotalGames()) return false;
        if (this.getWins() != other.getWins()) return false;
        if (Double.compare(this.getWinRate(), other.getWinRate()) != 0) return false;
        if (Double.compare(this.getAverageAttempts(), other.getAverageAttempts()) != 0) return false;
        if (this.getBestStreak() != other.getBestStreak()) return false;
        if (this.getCurrentStreak() != other.getCurrentStreak()) return false;
        if (this.getTotalScore() != other.getTotalScore()) return false;
        if (this.getEasyWins() != other.getEasyWins()) return false;
        if (this.getMediumWins() != other.getMediumWins()) return false;
        if (this.getHardWins() != other.getHardWins()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof LeaderboardEntryDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        result = result * PRIME + this.getTotalGames();
        result = result * PRIME + this.getWins();
        final long $winRate = Double.doubleToLongBits(this.getWinRate());
        result = result * PRIME + (int) ($winRate >>> 32 ^ $winRate);
        final long $averageAttempts = Double.doubleToLongBits(this.getAverageAttempts());
        result = result * PRIME + (int) ($averageAttempts >>> 32 ^ $averageAttempts);
        result = result * PRIME + this.getBestStreak();
        result = result * PRIME + this.getCurrentStreak();
        result = result * PRIME + this.getTotalScore();
        result = result * PRIME + this.getEasyWins();
        result = result * PRIME + this.getMediumWins();
        result = result * PRIME + this.getHardWins();
        return result;
    }

    public String toString() {
        return "LeaderboardEntryDTO(id=" + this.getId() + ", username=" + this.getUsername() + ", totalGames=" + this.getTotalGames() + ", wins=" + this.getWins() + ", winRate=" + this.getWinRate() + ", averageAttempts=" + this.getAverageAttempts() + ", bestStreak=" + this.getBestStreak() + ", currentStreak=" + this.getCurrentStreak() + ", totalScore=" + this.getTotalScore() + ", easyWins=" + this.getEasyWins() + ", mediumWins=" + this.getMediumWins() + ", hardWins=" + this.getHardWins() + ")";
    }
}