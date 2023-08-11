package com.company.dto.commonDTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommonSportDTO {
    List sportName;
    List whichSport;

    List footballSportDo;

    List basketballSportDo;
    List tennisSportDo;
    List athleticSportDo;

    public CommonSportDTO(List sportName, List whichSport, List footballSportDo, List basketballSportDo, List tennisSportDo, List athleticSportDo) {
        this.sportName = sportName;
        this.whichSport = whichSport;
        this.footballSportDo = footballSportDo;
        this.basketballSportDo = basketballSportDo;
        this.tennisSportDo = tennisSportDo;
        this.athleticSportDo = athleticSportDo;
    }
}
