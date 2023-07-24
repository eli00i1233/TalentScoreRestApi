package com.company.dto.entityDTO;

import com.company.entity.EducationQuestion;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationQuestionDTO {
    Integer id;
    String educationQuestions;

    public EducationQuestionDTO(EducationQuestion educationQuestions) {
        this.id = educationQuestions.getId();
        this.educationQuestions = educationQuestions.getEducationQuestions();
    }

}
