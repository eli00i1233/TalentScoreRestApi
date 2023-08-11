package com.company.dto.entityDTO;

import com.company.entity.SpecialSkillQuestion;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpecialSkillQuestionDTO {
    Integer id;
    String specialSkillQuestions;

    public SpecialSkillQuestionDTO(SpecialSkillQuestion specialSkillsQuestions) {
        this.id = specialSkillsQuestions.getId();
        this.specialSkillQuestions = specialSkillsQuestions.getSpecialSkillQuestion();
    }

}
