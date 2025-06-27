package akram.cherkaoui.motusbe.dto;

public class UserInfoResponse {
    private String email;
    private String pseudo;

    public UserInfoResponse() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserInfoResponse)) return false;
        final UserInfoResponse other = (UserInfoResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$pseudo = this.getPseudo();
        final Object other$pseudo = other.getPseudo();
        if (this$pseudo == null ? other$pseudo != null : !this$pseudo.equals(other$pseudo)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserInfoResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $pseudo = this.getPseudo();
        result = result * PRIME + ($pseudo == null ? 43 : $pseudo.hashCode());
        return result;
    }

    public String toString() {
        return "UserInfoResponse(email=" + this.getEmail() + ", pseudo=" + this.getPseudo() + ")";
    }
}