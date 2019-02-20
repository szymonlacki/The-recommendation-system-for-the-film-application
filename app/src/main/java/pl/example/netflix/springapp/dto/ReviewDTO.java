package pl.example.netflix.springapp.dto;

public class ReviewDTO {

    private Long reviewId;
    private String reviewDescription;
    private Long accountId;
    private MovieDTO movie;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public void setMovie(MovieDTO movie) {
        this.movie = movie;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "reviewId=" + reviewId +
                ", reviewDescription='" + reviewDescription + '\'' +
                ", accountId=" + accountId +
                ", movie=" + movie +
                '}';
    }
}
