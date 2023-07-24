package com.company.dto.entityDTO;

import com.company.entity.OlympiadQuestion;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OlympiadQuestionDTO {
    Integer id;
    String olympiadQuestions;

    public OlympiadQuestionDTO(OlympiadQuestion olympiadQuestions) {
        this.id = olympiadQuestions.getId();
        this.olympiadQuestions = olympiadQuestions.getOlympiadQuestion();
    }
}
