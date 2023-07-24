package com.company.dto.entityDTO;

import com.company.entity.SpecialSkillUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpecialSkillsUserDTO {
    Integer id;
    SpecialSkillsAnswerDTO specialSkillsAnswersId;
    SpecialSkillsQuestionDTO specialSkillsQuestionsId;
    UserDTO userId;

    public SpecialSkillsUserDTO(SpecialSkillUser specialSkillsUser) {
        this.id = specialSkillsUser.getId();
        this.specialSkillsAnswersId = new SpecialSkillsAnswerDTO(specialSkillsUser.getSpecialSkillAnswerId());
        this.specialSkillsQuestionsId = new SpecialSkillsQuestionDTO(specialSkillsUser.getSpecialSkillQuestionId());
        this.userId = new UserDTO(specialSkillsUser.getUserId());
    }


}
