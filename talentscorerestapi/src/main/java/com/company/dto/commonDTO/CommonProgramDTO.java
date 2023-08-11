package com.company.dto.commonDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonProgramDTO {
    List programNameList;
    List msOfficeExperienceList;
    List experienceList;
    List programmingLanguageList;
    List designProgramList;
    List additionalProgramLanguageList;

    public CommonProgramDTO(List programNameList, List msOfficeExperienceList, List experienceList, List programmingLanguageList, List designProgramList, List additionalProgramLanguageList) {
        this.programNameList = programNameList;
        this.msOfficeExperienceList = msOfficeExperienceList;
        this.experienceList = experienceList;
        this.programmingLanguageList = programmingLanguageList;
        this.designProgramList = designProgramList;
        this.additionalProgramLanguageList = additionalProgramLanguageList;
    }
}
