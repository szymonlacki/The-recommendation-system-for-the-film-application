package pl.example.netflix.model;

import java.util.List;

public class MovieListHelper {
    private String name, description;
    private UserDetail user;
    private List<String> listOfNamesMovies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDetail getUser() {
        return user;
    }

    public void setUser(UserDetail user) {
        this.user = user;
    }

    public List<String> getListOfNamesMovies() {
        return listOfNamesMovies;
    }

    public void setListOfNamesMovies(List<String> listOfNamesMovies) {
        this.listOfNamesMovies = listOfNamesMovies;
    }

    @Override
    public String toString() {
        return "MovieListHelper{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", listOfNamesMovies=" + listOfNamesMovies +
                '}';
    }
}
