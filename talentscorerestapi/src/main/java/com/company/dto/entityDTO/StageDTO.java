package com.company.dto.entityDTO;

import com.company.entity.Stage;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StageDTO {
    Integer id;
    String stageName;

    public StageDTO(Stage stages) {
        this.stageName = stages.getStageName();
        this.id = stages.getId();
    }


}
