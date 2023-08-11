package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.commonDTO.CommonEducationDTO;
import com.company.dto.commonDTO.CommonExperienceDTO;
import com.company.dto.entityDTO.ExperienceAnswerDTO;
import com.company.dto.entityDTO.ExperienceQuestionDTO;
import com.company.dto.entityDTO.SportAnswerDTO;
import com.company.dto.entityDTO.SportQuestionDTO;
import com.company.entity.*;
import com.company.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ExperienceController {
    @Autowired
    private ExperienceQuestionRepository experienceQuestionRepository;
    @Autowired
    private ExperienceAnswerRepository experienceAnswerRepository;
    @Autowired
    private ExperienceUserRepository experienceUserRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/experience")
    public ResponseEntity<ResponseDTO> experience() {
        List<ExperienceQuestion> experienceQuestions = experienceQuestionRepository.findAll();
        List<ExperienceAnswer> experienceAnswers = experienceAnswerRepository.findAll();

        List<ExperienceQuestionDTO> experienceQuestionDTOS = new ArrayList<>();
        List<ExperienceAnswerDTO> experienceAnswerDTOS = new ArrayList<>();
        for (ExperienceQuestion u : experienceQuestions) {
            experienceQuestionDTOS.add(new ExperienceQuestionDTO(u));
        }
        for (ExperienceAnswer u : experienceAnswers) {
            experienceAnswerDTOS.add(new ExperienceAnswerDTO(u));
        }
        List experienceList = new ArrayList<>();
        experienceList.add(experienceQuestionDTOS.get(0));
        experienceList.add(experienceAnswerDTOS.get(0));
        experienceList.add(experienceAnswerDTOS.get(1));


        List workPlaceList = new ArrayList();
        workPlaceList.add(experienceQuestionDTOS.get(1));

        List positionList = new ArrayList();
        positionList.add(experienceQuestionDTOS.get(2));

        List laborActivityList = new ArrayList();
        laborActivityList.add(experienceQuestionDTOS.get(3));

        List professionalizmList = new ArrayList();
        professionalizmList.add(experienceQuestionDTOS.get(4));

        List specialityList = new ArrayList();
        specialityList.add(experienceQuestionDTOS.get(5));

        List startDateList = new ArrayList();
        startDateList.add(experienceQuestionDTOS.get(6));
        List finishDateList = new ArrayList();
        finishDateList.add(experienceQuestionDTOS.get(7));

        CommonExperienceDTO commonExperienceDTO = new CommonExperienceDTO(experienceList, workPlaceList, positionList, laborActivityList, professionalizmList, startDateList, finishDateList, specialityList);
        return ResponseEntity.ok(ResponseDTO.of(commonExperienceDTO));
    }

    @Transactional
    @PostMapping("/tecrube")
    public String experience(@RequestParam Integer userId,
                             @RequestParam Integer experienceQuestionId,
                             @RequestParam Integer experienceAnswerId,
                             @RequestParam Integer workPlaceQuestionId,
                             @RequestParam String workPlaceAnswer,
                             @RequestParam Integer jobPositionQuestionId,
                             @RequestParam String jobPositionAnswer,
                             @RequestParam Integer laborQuestionId,
                             @RequestParam String laborAnswer,
                             @RequestParam Integer proQuestionId,
                             @RequestParam String proAnswer,
                             @RequestParam Integer specialityQuestionId,
                             @RequestParam String specialityAnswer,
                             @RequestParam Integer dateStartQuestionId,
                             @RequestParam Date dateStartAnswer,
                             @RequestParam Integer dateFinishQuestionId,
                             @RequestParam(required = false) Date dateFinishAnswer) {
        User user = userRepository.findById(userId).get();
        if (user != null) {
            ExperienceUser experienceUser = new ExperienceUser();
            ExperienceUser workPlace = new ExperienceUser();
            ExperienceUser speciality = new ExperienceUser();
            ExperienceUser jobPosition = new ExperienceUser();
            ExperienceUser labor = new ExperienceUser();
            ExperienceUser pro = new ExperienceUser();
            ExperienceUser dateStart = new ExperienceUser();
            ExperienceUser dateFinish = new ExperienceUser();

            List<ExperienceUser> experienceUsersList = new ArrayList<>();

            if (experienceAnswerId != null && experienceAnswerId != 0) {
                ExperienceAnswer experienceAnswer = experienceAnswerRepository.findById(experienceAnswerId).get();
                experienceUser.setExperienceAnswerId(experienceAnswer);
            }
            if (experienceQuestionId != null && experienceQuestionId != 0) {
                ExperienceQuestion experienceQuestion = experienceQuestionRepository.findById(experienceQuestionId).get();
                if (experienceAnswerId != null && experienceAnswerId != 0) {
                    experienceUser.setUserId(user);
                    experienceUser.setExperienceQuestionId(experienceQuestion);
                    experienceUsersList.add(experienceUser);
                }
            }

            if (workPlaceAnswer != null) {
                workPlace.setExperienceAnswerString(workPlaceAnswer);
            }
            if (workPlaceQuestionId != null && workPlaceQuestionId != 0) {
                ExperienceQuestion experienceQuestion = experienceQuestionRepository.findById(workPlaceQuestionId).get();

                if (workPlaceAnswer != null) {
                    workPlace.setUserId(user);
                    workPlace.setExperienceQuestionId(experienceQuestion);
                    experienceUsersList.add(workPlace);
                }
            }

            if (specialityAnswer != null) {
                speciality.setExperienceAnswerString(specialityAnswer);
            }
            if (specialityQuestionId != null && specialityQuestionId != 0) {
                ExperienceQuestion experienceQuestion = experienceQuestionRepository.findById(specialityQuestionId).get();

                if (specialityAnswer != null) {
                    speciality.setUserId(user);
                    speciality.setExperienceQuestionId(experienceQuestion);
                    experienceUsersList.add(speciality);
                }
            }

            if (jobPositionAnswer != null) {

                jobPosition.setExperienceAnswerString(jobPositionAnswer);
            }

            if (jobPositionQuestionId != null && jobPositionQuestionId != 0) {
                ExperienceQuestion experienceQuestion = experienceQuestionRepository.findById(jobPositionQuestionId).get();
                if (jobPositionAnswer != null) {
                    jobPosition.setUserId(user);
                    jobPosition.setExperienceQuestionId(experienceQuestion);
                    experienceUsersList.add(jobPosition);
                }
            }

            if (laborAnswer != null) {
                labor.setExperienceAnswerString(laborAnswer);
            }

            if (laborQuestionId != null && laborQuestionId != 0) {
                ExperienceQuestion experienceQuestion = experienceQuestionRepository.findById(laborQuestionId).get();
                if (laborAnswer != null) {
                    labor.setUserId(user);
                    labor.setExperienceQuestionId(experienceQuestion);
                    experienceUsersList.add(labor);
                }
            }

            if (proAnswer != null) {
                pro.setExperienceAnswerString(proAnswer);
            }

            if (proQuestionId != null && proQuestionId != 0) {
                ExperienceQuestion experienceQuestion = experienceQuestionRepository.findById(proQuestionId).get();
                if (proAnswer != null) {
                    pro.setUserId(user);
                    pro.setExperienceQuestionId(experienceQuestion);
                    experienceUsersList.add(pro);
                }
            }

            if (dateStartAnswer != null) {
                dateStart.setExperienceAnswerDate(dateStartAnswer);
            }

            if (dateStartQuestionId != null && dateStartQuestionId != 0) {
                ExperienceQuestion experienceQuestion = experienceQuestionRepository.findById(dateStartQuestionId).get();
                if (dateStart != null) {
                    dateStart.setUserId(user);
                    dateStart.setExperienceQuestionId(experienceQuestion);
                    experienceUsersList.add(dateStart);
                }
            }

            if (dateFinishAnswer != null) {
                dateFinish.setExperienceAnswerDate(dateFinishAnswer);
            }

            if (dateFinishQuestionId != null && dateFinishQuestionId != 0) {
                ExperienceQuestion experienceQuestion = experienceQuestionRepository.findById(dateFinishQuestionId).get();
                if (dateFinish != null) {
                    dateFinish.setUserId(user);
                    dateFinish.setExperienceQuestionId(experienceQuestion);
                    experienceUsersList.add(dateFinish);
                }
            }
            experienceUserRepository.saveAll(experienceUsersList);
        }
        return "experience";
    }
}

