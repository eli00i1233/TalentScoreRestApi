package com.company.dto.entityDTO;

import com.company.entity.ExperienceAnswer;
import com.company.entity.ExperienceQuestion;
import com.company.entity.ExperienceUser;
import com.company.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExperienceUserDTO {
    Integer id;
    UserDTO userId;
    ExperienceAnswerDTO experienceAnswerId;
    ExperienceQuestionDTO experienceQuestionId;
    String experienceAnswerString;
    Date experienceAnswerDate;

    public ExperienceUserDTO(ExperienceUser experienceUser) {
        this.id = experienceUser.getId();
        this.userId = new UserDTO(experienceUser.getUserId());
        this.experienceAnswerId = new ExperienceAnswerDTO(experienceUser.getExperienceAnswerId());
        this.experienceQuestionId = new ExperienceQuestionDTO(experienceUser.getExperienceQuestionId());
        experienceAnswerString = experienceUser.getExperienceAnswerString();
        this.experienceAnswerDate = experienceUser.getExperienceAnswerDate();
    }
}
