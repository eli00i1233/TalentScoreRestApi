package com.company.dto.entityDTO;

import com.company.entity.SportAnswer;
import com.company.entity.SportQuestion;
import com.company.entity.SportUser;
import com.company.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportUserDTO {
    Integer id;
    UserDTO userId;
    SportAnswerDTO sportAnswerId;
    SportQuestionDTO sportQuestionId;

    public SportUserDTO(SportUser sportUser) {
        this.id = sportUser.getId();
        this.userId = new UserDTO(sportUser.getUserId());
        this.sportAnswerId = new SportAnswerDTO(sportUser.getSportAnswerId());
        this.sportQuestionId = new SportQuestionDTO(sportUser.getSportQuestionId());
    }
}
