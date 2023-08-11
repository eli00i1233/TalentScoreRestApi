package com.company.dto.entityDTO;

import com.company.entity.SportAnswer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportAnswerDTO {
    Integer id;
    String sportAnswers;

    public SportAnswerDTO(SportAnswer sportAnswer) {
        this.id = sportAnswer.getId();
        this.sportAnswers = sportAnswer.getSportAnswers();
    }
}
