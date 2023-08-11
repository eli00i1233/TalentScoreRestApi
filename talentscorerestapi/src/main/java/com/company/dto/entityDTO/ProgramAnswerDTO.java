package com.company.dto.entityDTO;

import com.company.entity.ProgramAnswer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProgramAnswerDTO {
    Integer id;
    String programAnswers;

    public ProgramAnswerDTO(ProgramAnswer programAnswer) {
        this.id = programAnswer.getId();
        this.programAnswers = programAnswer.getProgramAnswers();
    }
}
