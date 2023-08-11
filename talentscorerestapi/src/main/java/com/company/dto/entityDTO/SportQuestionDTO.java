package com.company.dto.entityDTO;

import com.company.entity.SportQuestion;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportQuestionDTO {
    Integer id;
    String sportQuestions;

    public SportQuestionDTO(SportQuestion sportQuestion) {
        this.id = sportQuestion.getId();
        this.sportQuestions = sportQuestion.getSportQuestions();
    }
}
