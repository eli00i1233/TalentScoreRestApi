package com.company.dto.entityDTO;


import com.company.entity.ForeignLanguageUser;
import com.company.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForeignLanguageUserDTO {
    Integer id;
    ForeignLanguageAnswerDTO foreignLanguageAnswersId;
    ForeignLanguageQuestionDTO foreignLanguageQuestionsId;
    UserDTO userId;

    public ForeignLanguageUserDTO(ForeignLanguageUser foreignLanguageUsers) {
        this.id = foreignLanguageUsers.getId();
        this.foreignLanguageAnswersId = new ForeignLanguageAnswerDTO(foreignLanguageUsers.getForeignLanguageAnswerId());
        this.foreignLanguageQuestionsId = new ForeignLanguageQuestionDTO(foreignLanguageUsers.getForeignLanguageQuestionId());
        this.userId = new UserDTO(foreignLanguageUsers.getUserId());
    }

}
