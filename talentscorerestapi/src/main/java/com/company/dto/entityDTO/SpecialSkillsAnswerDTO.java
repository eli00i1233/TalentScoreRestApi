package com.company.dto.entityDTO;

import com.company.entity.SpecialSkillAnswer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpecialSkillsAnswerDTO {
    Integer id;
    String specialSkillsAnswers;

    public SpecialSkillsAnswerDTO(SpecialSkillAnswer specialSkillsAnswers) {
        this.id = specialSkillsAnswers.getId();
        this.specialSkillsAnswers = specialSkillsAnswers.getSpecialSkillsAnswer();
    }


}
