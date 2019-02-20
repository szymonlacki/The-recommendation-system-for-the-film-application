package pl.example.netflix.springapp.mapper;

import pl.example.netflix.model.Actor;
import pl.example.netflix.springapp.dto.ActorDTO;

public class ActorMapper {

    public static Actor toActor(ActorDTO actorDTO) {
        Actor actor = new Actor();
        actor.setActorId(actorDTO.getActorId());
        actor.setActorName(actorDTO.getActorName());
        actor.setActorBirthday(actorDTO.getActorBirthday());
        actor.setActorPlaceOfBirth(actorDTO.getActorPlaceOfBirth());
        actor.setActorGender(actorDTO.getActorGender());
        actor.setActor_biography(actorDTO.getActor_biography());
        actor.setImageName(actorDTO.getImage());
        return actor;
    }


    public static ActorDTO toActorDTO(Actor actor) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setActorId(actor.getActorId());
        actorDTO.setActorName(actor.getActorName());
        actorDTO.setActorBirthday(actor.getActorBirthday());
        actorDTO.setActorPlaceOfBirth(actor.getActorPlaceOfBirth());
        actorDTO.setActorGender(actor.getActorGender());
        actorDTO.setImage(actor.getImageName());
        actorDTO.setActor_biography(actor.getActor_biography());
        return actorDTO;
    }
}
