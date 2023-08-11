package com.company.dto.entityDTO;

import com.company.entity.ProgramQuestion;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProgramQuestionDTO {
    Integer id;
    String programQuestions;

    public ProgramQuestionDTO(ProgramQuestion programQuestion) {
        this.id = programQuestion.getId();
        this.programQuestions = programQuestion.getProgramQuestions();
    }
}
