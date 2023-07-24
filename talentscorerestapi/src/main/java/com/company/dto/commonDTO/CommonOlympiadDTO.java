package com.company.dto.commonDTO;

import com.company.dto.entityDTO.StageDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonOlympiadDTO {


    List olympiadWinList;
    List olympiadSubjectList;
    List olympiadStageList;

    List winPlaceList;

    public CommonOlympiadDTO(List olympiadWinList, List olympiadSubjectList, List olympiadStageList, List winPlaceList) {
        this.olympiadWinList = olympiadWinList;
        this.olympiadSubjectList = olympiadSubjectList;
        this.olympiadStageList = olympiadStageList;
        this.winPlaceList = winPlaceList;
    }


}
