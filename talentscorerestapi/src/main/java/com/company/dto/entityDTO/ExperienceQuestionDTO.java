package com.company.dto.entityDTO;

import com.company.entity.ExperienceQuestion;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExperienceQuestionDTO {
    Integer id;
    String experienceQuestions;

    public ExperienceQuestionDTO(ExperienceQuestion experienceQuestion) {
        this.id = experienceQuestion.getId();
        this.experienceQuestions = experienceQuestion.getExperienceQuestions();
    }
}
