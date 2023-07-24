package com.company.dto.entityDTO;

import com.company.entity.EducationAnswer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationAnswerDTO {
    Integer id;
    String educationAnswers;

    public EducationAnswerDTO(EducationAnswer educationAnswer) {
        this.id = educationAnswer.getId();
        this.educationAnswers = educationAnswer.getEducationAnswers();
    }


}
