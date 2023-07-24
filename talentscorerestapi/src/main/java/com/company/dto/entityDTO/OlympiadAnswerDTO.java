package com.company.dto.entityDTO;

import com.company.entity.OlympiadAnswer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OlympiadAnswerDTO {
    Integer id;
    String olympiadAnswers;

    public OlympiadAnswerDTO(OlympiadAnswer olympiadAnswers) {
        this.id = olympiadAnswers.getId();
        this.olympiadAnswers = olympiadAnswers.getOlympiadAnswer();
    }

}
