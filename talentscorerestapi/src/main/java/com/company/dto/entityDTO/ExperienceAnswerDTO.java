package com.company.dto.entityDTO;

import com.company.entity.ExperienceAnswer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExperienceAnswerDTO {
    Integer id;
    String experienceAnswers;

    public ExperienceAnswerDTO(ExperienceAnswer experienceAnswer) {
        this.id = experienceAnswer.getId();
        this.experienceAnswers = experienceAnswer.getExperienceAnswers();
    }
}
