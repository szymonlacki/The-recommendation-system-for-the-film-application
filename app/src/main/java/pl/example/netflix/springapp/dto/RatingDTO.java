package pl.example.netflix.springapp.dto;

public class RatingDTO {


    private Long rateId;
    private Long accountId;
    private double rateValue;
    private MovieDTO movie;

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getRateValue() {
        return rateValue;
    }

    public void setRateValue(double rateValue) {
        this.rateValue = rateValue;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "RatingDTO{" +
                "rateId=" + rateId +
                ", accountId=" + accountId +
                ", rateValue=" + rateValue +
                ", movie=" + movie +
                '}';
    }
}
