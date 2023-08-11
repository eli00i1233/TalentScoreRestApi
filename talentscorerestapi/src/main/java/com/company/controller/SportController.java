package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.commonDTO.CommonEducationDTO;
import com.company.dto.commonDTO.CommonSportDTO;
import com.company.dto.entityDTO.EducationAnswerDTO;
import com.company.dto.entityDTO.EducationQuestionDTO;
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
import java.util.List;

@RestController
public class SportController {
    @Autowired
    private SportQuestionRepository sportQuestionRepository;
    @Autowired
    private SportAnswerRepository sportAnswerRepository;
    @Autowired
    private SportUserRepository sportUserRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/sport")
    public ResponseEntity<ResponseDTO> sport() {
        List<SportQuestion> sportQuestions = sportQuestionRepository.findAll();
        List<SportAnswer> sportAnswers = sportAnswerRepository.findAll();

        List<SportQuestionDTO> sportQuestionDTOS = new ArrayList<>();
        List<SportAnswerDTO> sportAnswerDTOS = new ArrayList<>();
        for (SportQuestion u : sportQuestions) {
            sportQuestionDTOS.add(new SportQuestionDTO(u));
        }
        for (SportAnswer u : sportAnswers) {
            sportAnswerDTOS.add(new SportAnswerDTO(u));
        }
        List sportName = new ArrayList<>();
        sportName.add(sportQuestionDTOS.get(0));
        sportName.add(sportAnswerDTOS.get(0));
        sportName.add(sportAnswerDTOS.get(1));


        List whichSport = new ArrayList();
        whichSport.add(sportQuestionDTOS.get(1));
        whichSport.add(sportAnswerDTOS.get(2));
        whichSport.add(sportAnswerDTOS.get(3));
        whichSport.add(sportAnswerDTOS.get(4));
        whichSport.add(sportAnswerDTOS.get(5));

        List footballSportDo = new ArrayList();
        footballSportDo.add(sportQuestionDTOS.get(2));
        footballSportDo.add(sportAnswerDTOS.get(6));
        footballSportDo.add(sportAnswerDTOS.get(7));
        footballSportDo.add(sportAnswerDTOS.get(8));
        footballSportDo.add(sportAnswerDTOS.get(9));
        footballSportDo.add(sportAnswerDTOS.get(10));
        footballSportDo.add(sportAnswerDTOS.get(11));
        footballSportDo.add(sportAnswerDTOS.get(12));
        footballSportDo.add(sportAnswerDTOS.get(13));

        List basketballSportDo = new ArrayList();
        basketballSportDo.add(sportQuestionDTOS.get(2));
        basketballSportDo.add(sportAnswerDTOS.get(6));
        basketballSportDo.add(sportAnswerDTOS.get(7));
        basketballSportDo.add(sportAnswerDTOS.get(8));
        basketballSportDo.add(sportAnswerDTOS.get(9));
        basketballSportDo.add(sportAnswerDTOS.get(10));
        basketballSportDo.add(sportAnswerDTOS.get(11));
        basketballSportDo.add(sportAnswerDTOS.get(12));
        basketballSportDo.add(sportAnswerDTOS.get(13));

        List tennisSportDo = new ArrayList();
        tennisSportDo.add(sportQuestionDTOS.get(2));
        tennisSportDo.add(sportAnswerDTOS.get(6));
        tennisSportDo.add(sportAnswerDTOS.get(7));
        tennisSportDo.add(sportAnswerDTOS.get(8));
        tennisSportDo.add(sportAnswerDTOS.get(9));
        tennisSportDo.add(sportAnswerDTOS.get(10));
        tennisSportDo.add(sportAnswerDTOS.get(11));
        tennisSportDo.add(sportAnswerDTOS.get(12));
        tennisSportDo.add(sportAnswerDTOS.get(13));

        List athleticSportDo = new ArrayList();
        athleticSportDo.add(sportQuestionDTOS.get(2));
        athleticSportDo.add(sportAnswerDTOS.get(6));
        athleticSportDo.add(sportAnswerDTOS.get(7));
        athleticSportDo.add(sportAnswerDTOS.get(8));
        athleticSportDo.add(sportAnswerDTOS.get(9));
        athleticSportDo.add(sportAnswerDTOS.get(10));
        athleticSportDo.add(sportAnswerDTOS.get(11));
        athleticSportDo.add(sportAnswerDTOS.get(12));
        athleticSportDo.add(sportAnswerDTOS.get(13));

        CommonSportDTO commonSportDTO = new CommonSportDTO(sportName, whichSport, footballSportDo, basketballSportDo, tennisSportDo, athleticSportDo);
        return ResponseEntity.ok(ResponseDTO.of(commonSportDTO));
    }

    @Transactional
    @PostMapping("/sport")
    public String sport(@RequestParam Integer userId,
                         @RequestParam Integer sportQuestionId,
                         @RequestParam Integer sportAnswerId,
                         @RequestParam Integer whichSportQuestionId,
                         @RequestParam Integer whichSportAnswerId,
                         @RequestParam(required = false) Integer winStage1QuestionId,
                         @RequestParam(required = false) Integer winStage1AnswerId,
                         @RequestParam(required = false) Integer whichPlace1QuestionId,
                         @RequestParam(required = false) Integer whichPlace1RateAnswerId,
                         @RequestParam(required = false) Integer winStage2QuestionId,
                         @RequestParam(required = false) Integer winStage2AnswerId,
                         @RequestParam(required = false) Integer whichPlace2QuestionId,
                         @RequestParam(required = false) Integer whichPlace2RateAnswerId,
                         @RequestParam(required = false) Integer winStage3QuestionId,
                         @RequestParam(required = false) Integer winStage3AnswerId,
                         @RequestParam(required = false) Integer whichPlace3QuestionId,
                         @RequestParam(required = false) Integer whichPlace3RateAnswerId,
                         @RequestParam(required = false) Integer winStage4QuestionId,
                         @RequestParam(required = false) Integer winStage4AnswerId,
                         @RequestParam(required = false) Integer whichPlace4QuestionId,
                         @RequestParam(required = false) Integer whichPlace4RateAnswerId) {
        User user = userRepository.findById(userId).get();
        if (user != null) {
            SportUser userSport = new SportUser();
            SportUser userSportName = new SportUser();
            SportUser userStage1 = new SportUser();
            SportUser userPlace1 = new SportUser();
            SportUser userStage2 = new SportUser();
            SportUser userPlace2 = new SportUser();
            SportUser userStage3 = new SportUser();
            SportUser userPlace3 = new SportUser();
            SportUser userStage4 = new SportUser();
            SportUser userPlace4 = new SportUser();

            List<SportUser> sportUserList = new ArrayList<>();

            if (sportAnswerId != null && sportAnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(sportAnswerId).get();
                userSport.setSportAnswerId(sportAnswer);
            }
            if (sportQuestionId != null && sportQuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(sportQuestionId).get();
                if (sportAnswerId != null && sportAnswerId != 0) {
                    userSport.setUserId(user);
                    userSport.setSportQuestionId(sportQuestion);
                    sportUserList.add(userSport);
                }
            }

            if (whichSportAnswerId != null && whichSportAnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(whichSportAnswerId).get();
                userSportName.setSportAnswerId(sportAnswer);
            }

            if (whichSportQuestionId != null && whichSportQuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(whichSportQuestionId).get();

                if (whichSportAnswerId != null && whichSportAnswerId != 0) {
                    userSportName.setUserId(user);
                    userSportName.setSportQuestionId(sportQuestion);
                    sportUserList.add(userSportName);
                }
            }

            if (winStage1AnswerId != null && winStage1AnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(winStage1AnswerId).get();
                userStage1.setSportAnswerId(sportAnswer);
            }

            if (winStage1QuestionId != null && winStage1QuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(winStage1QuestionId).get();

                if (winStage1AnswerId != null && winStage1AnswerId != 0) {
                    userStage1.setUserId(user);
                    userStage1.setSportQuestionId(sportQuestion);
                    sportUserList.add(userStage1);
                }
            }

            if (whichPlace1RateAnswerId != null && whichPlace1RateAnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(whichPlace1RateAnswerId).get();
                userPlace1.setSportAnswerId(sportAnswer);
            }

            if (whichPlace1QuestionId != null && whichPlace1QuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(whichPlace1QuestionId).get();
                if (whichPlace1RateAnswerId != null && whichPlace1RateAnswerId != 0) {
                    userPlace1.setUserId(user);
                    userPlace1.setSportQuestionId(sportQuestion);
                    sportUserList.add(userPlace1);
                }
            }
            if (winStage2AnswerId != null && winStage2AnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(winStage2AnswerId).get();
                userStage2.setSportAnswerId(sportAnswer);
            }

            if (winStage2QuestionId != null && winStage2QuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(winStage2QuestionId).get();

                if (winStage2AnswerId != null && winStage2AnswerId != 0) {
                    userStage2.setUserId(user);
                    userStage2.setSportQuestionId(sportQuestion);
                    sportUserList.add(userStage2);
                }
            }

            if (whichPlace2RateAnswerId != null && whichPlace2RateAnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(whichPlace2RateAnswerId).get();
                userPlace2.setSportAnswerId(sportAnswer);
            }

            if (whichPlace2QuestionId != null && whichPlace2QuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(whichPlace2QuestionId).get();
                if (whichPlace2RateAnswerId != null && whichPlace2RateAnswerId != 0) {
                    userPlace2.setUserId(user);
                    userPlace2.setSportQuestionId(sportQuestion);
                    sportUserList.add(userPlace2);
                }
            }


            if (winStage3AnswerId != null && winStage3AnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(winStage3AnswerId).get();
                userStage3.setSportAnswerId(sportAnswer);
            }

            if (winStage3QuestionId != null && winStage3QuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(winStage3QuestionId).get();

                if (winStage3AnswerId != null && winStage3AnswerId != 0) {
                    userStage3.setUserId(user);
                    userStage3.setSportQuestionId(sportQuestion);
                    sportUserList.add(userStage3);
                }
            }

            if (whichPlace3RateAnswerId != null && whichPlace3RateAnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(whichPlace3RateAnswerId).get();
                userPlace3.setSportAnswerId(sportAnswer);
            }

            if (whichPlace3QuestionId != null && whichPlace3QuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(whichPlace3QuestionId).get();
                if (whichPlace3RateAnswerId != null && whichPlace3RateAnswerId != 0) {
                    userPlace3.setUserId(user);
                    userPlace3.setSportQuestionId(sportQuestion);
                    sportUserList.add(userPlace3);
                }
            }

            if (winStage4AnswerId != null && winStage4AnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(winStage4AnswerId).get();
                userStage4.setSportAnswerId(sportAnswer);
            }

            if (winStage4QuestionId != null && winStage4QuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(winStage4QuestionId).get();

                if (winStage4AnswerId != null && winStage4AnswerId != 0) {
                    userStage4.setUserId(user);
                    userStage4.setSportQuestionId(sportQuestion);
                    sportUserList.add(userStage4);
                }
            }

            if (whichPlace4RateAnswerId != null && whichPlace4RateAnswerId != 0) {
                SportAnswer sportAnswer = sportAnswerRepository.findById(whichPlace4RateAnswerId).get();
                userPlace4.setSportAnswerId(sportAnswer);
            }

            if (whichPlace4QuestionId != null && whichPlace4QuestionId != 0) {
                SportQuestion sportQuestion = sportQuestionRepository.findById(whichPlace4QuestionId).get();
                if (whichPlace4RateAnswerId != null && whichPlace4RateAnswerId != 0) {
                    userPlace4.setUserId(user);
                    userPlace4.setSportQuestionId(sportQuestion);
                    sportUserList.add(userPlace4);
                }
            }

            sportUserRepository.saveAll(sportUserList);
        }
        return "sport";
    }
}
