package com.company.dto.commonDTO;

import com.company.dto.entityDTO.StageDTO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonSpecialSkillsDTO {
    List specialSkillsHasList;

    List specialSkillsList;

    List specialSkillsLevelList;


    public CommonSpecialSkillsDTO(List specialSkillsHasList, List specialSkillsList, List specialSkillsLevelList) {
        this.specialSkillsHasList = specialSkillsHasList;
        this.specialSkillsList = specialSkillsList;
        this.specialSkillsLevelList = specialSkillsLevelList;
    }

}
