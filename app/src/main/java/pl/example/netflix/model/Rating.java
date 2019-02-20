package pl.example.netflix.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RATING")
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RATE_ID", nullable = true)
    private Long rateId;

    @Column(name = "RATE_VALUE")
    private double rateValue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "MOVIE_ID", referencedColumnName="MOVIE_ID",  nullable=true)
    @JsonIgnore
    private Movie movie ;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    @JsonIgnore
    private Account account;

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public double getRateValue() {
        return rateValue;
    }

    public void setRateValue(double rateValue) {
        this.rateValue = rateValue;
    }





    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rateId=" + rateId +
                ", rateValue='" + rateValue + '\'' +
                ", movie=" + movie +
                '}';
    }
}
