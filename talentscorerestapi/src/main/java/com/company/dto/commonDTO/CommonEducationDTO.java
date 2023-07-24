package com.company.dto.commonDTO;

import com.company.dto.entityDTO.StageDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonEducationDTO {

    List experienceList;
    List occupationList;
    List educationList;
    List rateList;

    public CommonEducationDTO(List experienceList, List occupationList, List educationList, List rateList) {
        this.experienceList = experienceList;
        this.occupationList = occupationList;
        this.educationList = educationList;
        this.rateList = rateList;
    }


}
