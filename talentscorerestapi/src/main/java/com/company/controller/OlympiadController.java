package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.commonDTO.CommonOlympiadDTO;
import com.company.dto.entityDTO.*;
import com.company.entity.*;
import com.company.inter.*;
import lombok.RequiredArgsConstructor;
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
public class OlympiadController {
    @Autowired
    private OlympiadQuestionRepository olympiadQuestionRepository;
    @Autowired
    private OlympiadAnswerRepository olympiadAnswerRepository;
    @Autowired
    private OlympiadUserRepository olympiadUserRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/tehsil/olimpiada-suallar")
    public ResponseEntity olympiad() {
        List<OlympiadQuestion> olympiadQuestions = olympiadQuestionRepository.findAll();
        List<OlympiadAnswer> olympiadAnswers = olympiadAnswerRepository.findAll();

        List<OlympiadQuestionDTO> olympiadQuestionDTOS = new ArrayList<>();
        List<OlympiadAnswerDTO> olympiadAnswerDTOS = new ArrayList<>();

        for (OlympiadQuestion u : olympiadQuestions) {
            olympiadQuestionDTOS.add(new OlympiadQuestionDTO(u));
        }
        for (OlympiadAnswer u : olympiadAnswers) {
            olympiadAnswerDTOS.add(new OlympiadAnswerDTO(u));
        }


        List olympiadWinList = new ArrayList<>();
        olympiadWinList.add(olympiadQuestionDTOS.get(0));
        olympiadWinList.add(olympiadAnswerDTOS.get(0));
        olympiadWinList.add(olympiadAnswerDTOS.get(1));


        List olympiadSubjectList = new ArrayList();
        olympiadSubjectList.add(olympiadQuestionDTOS.get(1));
        olympiadSubjectList.add(olympiadAnswerDTOS.get(2));
        olympiadSubjectList.add(olympiadAnswerDTOS.get(3));
        olympiadSubjectList.add(olympiadAnswerDTOS.get(4));
        olympiadSubjectList.add(olympiadAnswerDTOS.get(5));
        olympiadSubjectList.add(olympiadAnswerDTOS.get(6));
        olympiadSubjectList.add(olympiadAnswerDTOS.get(7));
        olympiadSubjectList.add(olympiadAnswerDTOS.get(8));
        olympiadSubjectList.add(olympiadAnswerDTOS.get(9));

        List olympiadStageList = new ArrayList();
        olympiadStageList.add(olympiadQuestionDTOS.get(2));
        olympiadStageList.add(olympiadAnswerDTOS.get(10));
        olympiadStageList.add(olympiadAnswerDTOS.get(11));
        olympiadStageList.add(olympiadAnswerDTOS.get(12));
        olympiadStageList.add(olympiadAnswerDTOS.get(13));

        List winPlaceList = new ArrayList();
        winPlaceList.add(olympiadQuestionDTOS.get(3));
        winPlaceList.add(olympiadAnswerDTOS.get(14));
        winPlaceList.add(olympiadAnswerDTOS.get(15));
        winPlaceList.add(olympiadAnswerDTOS.get(16));
        winPlaceList.add(olympiadAnswerDTOS.get(17));

        CommonOlympiadDTO commonOlympiadDTO = new CommonOlympiadDTO(olympiadWinList, olympiadSubjectList, olympiadStageList, winPlaceList);
        return ResponseEntity.ok(ResponseDTO.of(commonOlympiadDTO));
    }

    @Transactional
    @PostMapping("/tehsil/olimpiada-suallar")
    public String olympiad(@RequestParam Integer userId,
                           @RequestParam Integer winQuestionId,
                           @RequestParam Integer winAnswerId,
                           @RequestParam Integer winSubjectQuestionId,
                           @RequestParam Integer winSubjectAnswerId,
                           @RequestParam Integer winStageQuestionId,
                           @RequestParam Integer winStageAnswerId,
                           @RequestParam Integer winPlaceQuestionId,
                           @RequestParam Integer winPlaceAnswerId) {
        User user = userRepository.findById(userId).get();
        if (user != null) {
            OlympiadUser userWin = new OlympiadUser();
            OlympiadUser userWinSubject = new OlympiadUser();
            OlympiadUser userWinStage = new OlympiadUser();
            OlympiadUser userWinPlace = new OlympiadUser();

            List<OlympiadUser> olympiadUserList = new ArrayList<>();

            if (winAnswerId != null && winAnswerId != 0) {
                OlympiadAnswer olympiadWinAnswer = olympiadAnswerRepository.findById(winAnswerId).get();
                userWin.setOlympiadAnswerId(olympiadWinAnswer);
            }
            if (winQuestionId != null && winQuestionId != 0) {
                OlympiadQuestion olympiadWinQuestion = olympiadQuestionRepository.findById(winQuestionId).get();
                if (winAnswerId != null && winAnswerId != 0) {
                    userWin.setUserId(user);
                    userWin.setOlympiadQuestionId(olympiadWinQuestion);
                    olympiadUserList.add(userWin);
                }
            }
            if (winSubjectAnswerId != null && winSubjectAnswerId != 0) {
                OlympiadAnswer olympiadWinSubjectAnswer = olympiadAnswerRepository.findById(winSubjectAnswerId).get();
                userWinSubject.setOlympiadAnswerId(olympiadWinSubjectAnswer);
            }
            if (winSubjectQuestionId != null && winSubjectQuestionId != 0) {
                OlympiadQuestion olympiadWinSubjectQuestion = olympiadQuestionRepository.findById(winSubjectQuestionId).get();
                if (winSubjectAnswerId != null && winSubjectAnswerId != 0) {
                    userWinSubject.setUserId(user);
                    userWinSubject.setOlympiadQuestionId(olympiadWinSubjectQuestion);
                    olympiadUserList.add(userWinSubject);
                }
            }
            if (winStageAnswerId != null && winStageAnswerId != 0) {
                OlympiadAnswer olympiadWinStageAnswer = olympiadAnswerRepository.findById(winStageAnswerId).get();
                userWinStage.setOlympiadAnswerId(olympiadWinStageAnswer);
            }
            if (winStageQuestionId != null && winStageQuestionId != 0) {
                OlympiadQuestion olympiadWinStageQuestion = olympiadQuestionRepository.findById(winStageQuestionId).get();
                if (winStageAnswerId != null && winStageAnswerId != 0) {
                    userWinStage.setUserId(user);
                    userWinStage.setOlympiadQuestionId(olympiadWinStageQuestion);
                    olympiadUserList.add(userWinStage);
                }
            }
            if (winPlaceAnswerId != null && winPlaceAnswerId != 0) {
                OlympiadAnswer olympiadWinPlaceAnswer = olympiadAnswerRepository.findById(winPlaceAnswerId).get();
                userWinPlace.setOlympiadAnswerId(olympiadWinPlaceAnswer);
            }
            if (winPlaceQuestionId != null && winPlaceQuestionId != 0) {
                OlympiadQuestion olympiadWinPlaceQuestion = olympiadQuestionRepository.findById(winPlaceQuestionId).get();
                if (winPlaceAnswerId != null && winPlaceAnswerId != 0) {
                    userWinPlace.setUserId(user);
                    userWinPlace.setOlympiadQuestionId(olympiadWinPlaceQuestion);
                    olympiadUserList.add(userWinPlace);
                }
            }

            olympiadUserRepository.saveAll(olympiadUserList);
        }
        return "olimpiada-suallar";
    }

}

