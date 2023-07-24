package com.company.dto.commonDTO;

import com.company.dto.entityDTO.EducationAnswerDTO;
import com.company.dto.entityDTO.EducationQuestionDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonQADTO {
    EducationAnswerDTO educationAnswerDTO;
    EducationQuestionDTO educationQuestionDTO;

    public CommonQADTO(CommonEducationDTO commonEducationDTO) {
    }
}
