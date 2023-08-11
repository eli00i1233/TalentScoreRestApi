package com.company.dto.entityDTO;

import com.company.entity.ProgramAnswer;
import com.company.entity.ProgramQuestion;
import com.company.entity.ProgramUser;
import com.company.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProgramUserDTO {
    Integer id;

    UserDTO userId;

    ProgramAnswerDTO programAnswerId;

    ProgramQuestionDTO programQuestionId;

    public ProgramUserDTO(ProgramUser programUser) {
        this.id = programUser.getId();
        this.userId = new UserDTO(programUser.getUserId());
        this.programAnswerId = new ProgramAnswerDTO(programUser.getProgramAnswerId());
        this.programQuestionId = new ProgramQuestionDTO(programUser.getProgramQuestionId());
    }
}
