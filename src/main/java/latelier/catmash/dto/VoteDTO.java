package latelier.catmash.dto;

public class VoteDTO {

    private String winnerId;
    private String loserId;

    public VoteDTO() {
    }

    public VoteDTO(String winnerId, String loserId) {
        this.winnerId = winnerId;
        this.loserId = loserId;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public String getLoserId() {
        return loserId;
    }

    public void setLoserId(String loserId) {
        this.loserId = loserId;
    }

}
