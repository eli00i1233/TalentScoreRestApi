package com.company.dto.entityDTO;

import com.company.entity.EducationUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationUserDTO {
    Integer id;
    EducationAnswerDTO educationAnswerId;
    EducationQuestionDTO educationQuestionId;
    UserDTO userId;

    public EducationUserDTO() {
    }

    public EducationUserDTO(EducationUser educationUsers) {
        this.id = educationUsers.getId();
        this.educationAnswerId = new EducationAnswerDTO(educationUsers.getEducationAnswerId());
        this.educationQuestionId = new EducationQuestionDTO(educationUsers.getEducationQuestionId());
        this.userId = new UserDTO(educationUsers.getUserId());
    }


}
