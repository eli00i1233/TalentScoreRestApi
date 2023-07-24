package com.company.dto.entityDTO;

import com.company.entity.ForeignLanguageAnswer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForeignLanguageAnswerDTO {
    Integer id;
    String foreignLanguageAnswers;

    public ForeignLanguageAnswerDTO(ForeignLanguageAnswer foreignLanguageAnswers) {
        this.id = foreignLanguageAnswers.getId();
        this.foreignLanguageAnswers = foreignLanguageAnswers.getForeignLanguageAnswers();
    }


}
