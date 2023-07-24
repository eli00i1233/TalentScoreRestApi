package com.company.dto.commonDTO;

import com.company.dto.entityDTO.StageDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonForeignLanguageDTO {
    List foreignLanguageHasList;
    List foreignLanguageList;
    List certificateList;
    List ieltsResultList;
    List toeflResultList;
    List englishLanguagelevelList;
    List russianLanguagelevelList;
    List additionalLanguageList;

    public CommonForeignLanguageDTO(List foreignLanguageHasList, List foreignLanguageList, List certificateList, List ieltsResultList, List toeflResultList, List englishLanguagelevelList, List russianLanguagelevelList) {
        this.foreignLanguageHasList = foreignLanguageHasList;
        this.foreignLanguageList = foreignLanguageList;
        this.certificateList = certificateList;
        this.ieltsResultList = ieltsResultList;
        this.toeflResultList = toeflResultList;
        this.englishLanguagelevelList = englishLanguagelevelList;
        this.russianLanguagelevelList = russianLanguagelevelList;
    }

    public CommonForeignLanguageDTO(List additionalLanguageList) {
        this.additionalLanguageList = additionalLanguageList;
    }


}
