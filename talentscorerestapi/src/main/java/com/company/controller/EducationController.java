package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.commonDTO.CommonEducationDTO;
import com.company.dto.entityDTO.*;
import com.company.entity.*;
import com.company.inter.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequiredArgsConstructor
public class EducationController {
    @Autowired
    private EducationQuestionRepository educationQuestionRepository;
    @Autowired
    private EducationAnswerRepository educationAnswerRepository;
    @Autowired
    private EducationUserRepository educationUserRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tehsil/umumisuallar")
    public ResponseEntity<ResponseDTO> tehsil() {
        List<EducationQuestion> educationQuestions = educationQuestionRepository.findAll();
        List<EducationAnswer> educationAnswers = educationAnswerRepository.findAll();

        List<EducationQuestionDTO> educationQuestionDTOS = new ArrayList<>();
        List<EducationAnswerDTO> educationAnswerDTOS = new ArrayList<>();
        for (EducationQuestion u : educationQuestions) {
            educationQuestionDTOS.add(new EducationQuestionDTO(u));
        }
        for (EducationAnswer u : educationAnswers) {
            educationAnswerDTOS.add(new EducationAnswerDTO(u));
        }
        List experienceList = new ArrayList<>();
        experienceList.add(educationQuestionDTOS.get(0));
        experienceList.add(educationAnswerDTOS.get(0));
        experienceList.add(educationAnswerDTOS.get(1));


        List occupationList = new ArrayList();
        occupationList.add(educationQuestionDTOS.get(1));
        occupationList.add(educationAnswerDTOS.get(2));
        occupationList.add(educationAnswerDTOS.get(3));
        occupationList.add(educationAnswerDTOS.get(4));
        occupationList.add(educationAnswerDTOS.get(5));

        List educationList = new ArrayList();
        educationList.add(educationQuestionDTOS.get(2));
        educationList.add(educationAnswerDTOS.get(6));
        educationList.add(educationAnswerDTOS.get(7));
        educationList.add(educationAnswerDTOS.get(8));
        educationList.add(educationAnswerDTOS.get(9));
        educationList.add(educationAnswerDTOS.get(10));

        List rateList = new ArrayList();
        rateList.add(educationQuestionDTOS.get(3));
        rateList.add(educationAnswerDTOS.get(11));
        rateList.add(educationAnswerDTOS.get(12));
        rateList.add(educationAnswerDTOS.get(13));


        CommonEducationDTO commonEducationDTO = new CommonEducationDTO(experienceList, occupationList, educationList, rateList);
        return ResponseEntity.ok(ResponseDTO.of(commonEducationDTO));
    }

    @Transactional
    @PostMapping("/tehsil/umumisuallar")
    public String tehsil(@RequestParam Integer userId,
                         @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam Integer experienceQuestionId,
                         @RequestParam Integer experienceAnswerId,
                         @RequestParam Integer occupationQuestionId,
                         @RequestParam Integer occupationAnswerId,
                         @RequestParam Integer educationQuestionId,
                         @RequestParam Integer educationAnswerId,
                         @RequestParam Integer universityRateQuestionId,
                         @RequestParam Integer universityRateAnswerId) {
        User user = userRepository.findById(userId).get();
        if (user != null) {
            user.setName(name);
            user.setSurname(surname);

            EducationUser userExperience = new EducationUser();
            EducationUser userOccupation = new EducationUser();
            EducationUser userEducation = new EducationUser();
            EducationUser userUniversityRate = new EducationUser();

            List<EducationUser> educationUserList = new ArrayList<>();

            if (experienceAnswerId != null && experienceAnswerId != 0) {
                EducationAnswer educationAnswerExperience = educationAnswerRepository.findById(experienceAnswerId).get();
                userExperience.setEducationAnswerId(educationAnswerExperience);
            }
            if (experienceQuestionId != null && experienceQuestionId != 0) {
                EducationQuestion educationQuestionExperience = educationQuestionRepository.findById(experienceQuestionId).get();
                if (experienceAnswerId != null && experienceAnswerId != 0) {
                    userExperience.setUserId(user);
                    userExperience.setEducationQuestionId(educationQuestionExperience);
                    educationUserList.add(userExperience);
                }
            }

            if (occupationAnswerId != null && occupationAnswerId != 0) {
                EducationAnswer educationAnswerOccupation = educationAnswerRepository.findById(occupationAnswerId).get();
                userOccupation.setEducationAnswerId(educationAnswerOccupation);
            }

            if (occupationQuestionId != null && occupationQuestionId != 0) {
                EducationQuestion educationQuestionOccupation = educationQuestionRepository.findById(occupationQuestionId).get();

                if (occupationAnswerId != null && occupationAnswerId != 0) {
                    userOccupation.setUserId(user);
                    userOccupation.setEducationQuestionId(educationQuestionOccupation);
                    educationUserList.add(userOccupation);
                }
            }

            if (educationAnswerId != null && educationAnswerId != 0) {
                EducationAnswer educationAnswerEducation = educationAnswerRepository.findById(educationAnswerId).get();
                userEducation.setEducationAnswerId(educationAnswerEducation);
            }

            if (educationQuestionId != null && educationQuestionId != 0) {
                EducationQuestion educationQuestionEducation = educationQuestionRepository.findById(educationQuestionId).get();

                if (educationAnswerId != null && educationAnswerId != 0) {
                    userEducation.setUserId(user);
                    userEducation.setEducationQuestionId(educationQuestionEducation);
                    educationUserList.add(userEducation);
                }
            }

            if (universityRateAnswerId != null && universityRateAnswerId != 0) {
                EducationAnswer educationAnswerUniversityRate = educationAnswerRepository.findById(universityRateAnswerId).get();
                userUniversityRate.setEducationAnswerId(educationAnswerUniversityRate);
            }

            if (universityRateQuestionId != null && universityRateQuestionId != 0) {
                EducationQuestion educationQuestionUniversityRate = educationQuestionRepository.findById(universityRateQuestionId).get();
                if (universityRateAnswerId != null && universityRateAnswerId != 0) {
                    userUniversityRate.setUserId(user);
                    userUniversityRate.setEducationQuestionId(educationQuestionUniversityRate);
                    educationUserList.add(userUniversityRate);
                }
            }

            educationUserRepository.saveAll(educationUserList);
        }
        return "umumi-suallar";
    }

}
