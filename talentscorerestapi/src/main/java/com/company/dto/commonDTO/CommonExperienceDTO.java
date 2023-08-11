package com.company.dto.commonDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonExperienceDTO {
    List experienceList;
    List workPlaceList;
    List positionList;
    List laborActivityList;
    List professionalizmList;
    List startDateList;
    List finishDateList;
    List specialityList;

    public CommonExperienceDTO(List experienceList, List workPlaceList, List positionList, List laborActivityList, List professionalizmList, List startDateList, List finishDateList, List specialityList) {
        this.experienceList = experienceList;
        this.workPlaceList = workPlaceList;
        this.positionList = positionList;
        this.laborActivityList = laborActivityList;
        this.professionalizmList = professionalizmList;
        this.startDateList = startDateList;
        this.finishDateList = finishDateList;
        this.specialityList = specialityList;
    }
}
