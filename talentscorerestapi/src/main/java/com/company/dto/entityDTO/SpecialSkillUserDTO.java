package com.company.dto.entityDTO;

import com.company.entity.SpecialSkillUser;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpecialSkillUserDTO {
    Integer id;
    SpecialSkillAnswerDTO specialSkillsAnswersId;
    SpecialSkillQuestionDTO specialSkillsQuestionsId;
    UserDTO userId;

    public SpecialSkillUserDTO(SpecialSkillUser specialSkillsUser) {
        this.id = specialSkillsUser.getId();
        this.specialSkillsAnswersId = new SpecialSkillAnswerDTO(specialSkillsUser.getSpecialSkillAnswerId());
        this.specialSkillsQuestionsId = new SpecialSkillQuestionDTO(specialSkillsUser.getSpecialSkillQuestionId());
        this.userId = new UserDTO(specialSkillsUser.getUserId());
    }


}
