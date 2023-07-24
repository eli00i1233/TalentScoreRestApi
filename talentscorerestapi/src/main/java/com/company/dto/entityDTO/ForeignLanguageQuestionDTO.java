package com.company.dto.entityDTO;

import com.company.entity.ForeignLanguageQuestion;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForeignLanguageQuestionDTO {
    Integer id;
    String foreignLanguageQuestions;

    public ForeignLanguageQuestionDTO(ForeignLanguageQuestion foreignLanguageQuestions) {
        this.id = foreignLanguageQuestions.getId();
        this.foreignLanguageQuestions = foreignLanguageQuestions.getForeignLanguageQuestions();
    }


}
