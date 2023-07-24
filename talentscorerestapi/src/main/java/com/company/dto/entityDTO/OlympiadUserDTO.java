package com.company.dto.entityDTO;

import com.company.entity.OlympiadUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OlympiadUserDTO {
    Integer id;
    OlympiadAnswerDTO olympiadAnswerId;
    OlympiadQuestionDTO olympiadQuestionId;
    UserDTO userId;

    public OlympiadUserDTO(OlympiadUser olympiadUsers) {
        this.id = olympiadUsers.getId();
        this.olympiadAnswerId = new OlympiadAnswerDTO(olympiadUsers.getOlympiadAnswerId());
        this.olympiadQuestionId = new OlympiadQuestionDTO(olympiadUsers.getOlympiadQuestionId());
        this.userId = new UserDTO(olympiadUsers.getUserId());
    }

}
