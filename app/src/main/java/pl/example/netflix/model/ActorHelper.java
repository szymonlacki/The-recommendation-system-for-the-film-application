package pl.example.netflix.model;

import pl.example.netflix.springapp.dto.ActorDTO;

import java.util.List;

public class ActorHelper {

    private ActorDTO actorDTO;
    private List<Actor> actorList;


    public ActorDTO getActorDTO() {
        return actorDTO;
    }

    public void setActorDTODTO(ActorDTO actorDTODTO) {
        this.actorDTO = actorDTODTO;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    @Override
    public String toString() {
        return "ActorHelper{" +
                "actorDTODTO=" + actorDTO +
                ", actorList=" + actorList +
                '}';
    }
}
