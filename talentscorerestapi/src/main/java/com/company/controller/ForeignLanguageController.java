package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.commonDTO.CommonForeignLanguageDTO;
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
public class ForeignLanguageController {
    @Autowired
    private ForeignLanguageQuestionRepository foreignLanguageQuestionsRepository;
    @Autowired
    private ForeignLanguageAnswerRepository foreignLanguageAnswersRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ForeignLanguageUserRepository foreignLanguageUserRepository;

    @GetMapping("/dil-bilikleri/dil-bilikleri-substage")
    public ResponseEntity<ResponseDTO> foreignLanguages() {
        List<ForeignLanguageQuestion> foreignLanguageQuestions = foreignLanguageQuestionsRepository.findAll();
        List<ForeignLanguageAnswer> foreignLanguageAnswers = foreignLanguageAnswersRepository.findAll();

        List<ForeignLanguageQuestionDTO> foreignLanguageQuestionDTOS = new ArrayList<>();
        List<ForeignLanguageAnswerDTO> foreignLanguageAnswerDTOS = new ArrayList<>();

        for (ForeignLanguageQuestion u : foreignLanguageQuestions) {
            foreignLanguageQuestionDTOS.add(new ForeignLanguageQuestionDTO(u));
        }
        for (ForeignLanguageAnswer u : foreignLanguageAnswers) {
            foreignLanguageAnswerDTOS.add(new ForeignLanguageAnswerDTO(u));
        }


        List foreignLanguageHasList = new ArrayList<>();
        foreignLanguageHasList.add(foreignLanguageQuestionDTOS.get(0));
        foreignLanguageHasList.add(foreignLanguageAnswerDTOS.get(0));
        foreignLanguageHasList.add(foreignLanguageAnswerDTOS.get(1));


        List foreignLanguageList = new ArrayList();
        foreignLanguageList.add(foreignLanguageQuestionDTOS.get(1));
        foreignLanguageList.add(foreignLanguageAnswerDTOS.get(2));
        foreignLanguageList.add(foreignLanguageAnswerDTOS.get(3));

        List certificateList = new ArrayList();
        certificateList.add(foreignLanguageQuestionDTOS.get(2));
        certificateList.add(foreignLanguageAnswerDTOS.get(4));
        certificateList.add(foreignLanguageAnswerDTOS.get(5));
        certificateList.add(foreignLanguageAnswerDTOS.get(6));

        List ieltsResultList = new ArrayList();
        ieltsResultList.add(foreignLanguageQuestionDTOS.get(3));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(7));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(8));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(9));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(10));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(11));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(12));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(13));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(14));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(15));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(16));
        ieltsResultList.add(foreignLanguageAnswerDTOS.get(17));

        List toeflResultList = new ArrayList();
        toeflResultList.add(foreignLanguageQuestionDTOS.get(4));

        List englishLanguagelevelList = new ArrayList();
        englishLanguagelevelList.add(foreignLanguageQuestionDTOS.get(5));
        englishLanguagelevelList.add(foreignLanguageAnswerDTOS.get(18));
        englishLanguagelevelList.add(foreignLanguageAnswerDTOS.get(19));
        englishLanguagelevelList.add(foreignLanguageAnswerDTOS.get(20));
        englishLanguagelevelList.add(foreignLanguageAnswerDTOS.get(21));
        englishLanguagelevelList.add(foreignLanguageAnswerDTOS.get(22));
        englishLanguagelevelList.add(foreignLanguageAnswerDTOS.get(23));

        List russianLanguagelevelList = new ArrayList();
        russianLanguagelevelList.add(foreignLanguageQuestionDTOS.get(6));
        russianLanguagelevelList.add(foreignLanguageAnswerDTOS.get(18));
        russianLanguagelevelList.add(foreignLanguageAnswerDTOS.get(19));
        russianLanguagelevelList.add(foreignLanguageAnswerDTOS.get(20));
        russianLanguagelevelList.add(foreignLanguageAnswerDTOS.get(21));
        russianLanguagelevelList.add(foreignLanguageAnswerDTOS.get(22));
        russianLanguagelevelList.add(foreignLanguageAnswerDTOS.get(23));


        CommonForeignLanguageDTO commonForeignLanguageDTO = new CommonForeignLanguageDTO(foreignLanguageHasList, foreignLanguageList, certificateList, ieltsResultList, toeflResultList, englishLanguagelevelList, russianLanguagelevelList);
        return ResponseEntity.ok(ResponseDTO.of(commonForeignLanguageDTO));
    }

    @GetMapping("/dil-bilikleri/elave-dil-bilikleri-substage")
    public ResponseEntity<ResponseDTO> additionalLanguages() {
        List<ForeignLanguageQuestion> foreignLanguageQuestions = foreignLanguageQuestionsRepository.findAll();
        List<ForeignLanguageAnswer> foreignLanguageAnswers = foreignLanguageAnswersRepository.findAll();

        List<ForeignLanguageQuestionDTO> foreignLanguageQuestionDTOS = new ArrayList<>();
        List<ForeignLanguageAnswerDTO> foreignLanguageAnswerDTOS = new ArrayList<>();

        for (ForeignLanguageQuestion u : foreignLanguageQuestions) {
            foreignLanguageQuestionDTOS.add(new ForeignLanguageQuestionDTO(u));
        }
        for (ForeignLanguageAnswer u : foreignLanguageAnswers) {
            foreignLanguageAnswerDTOS.add(new ForeignLanguageAnswerDTO(u));
        }

        List additionalLanguageList = new ArrayList();
        additionalLanguageList.add(foreignLanguageQuestionDTOS.get(7));
        additionalLanguageList.add(foreignLanguageAnswerDTOS.get(24));
        additionalLanguageList.add(foreignLanguageAnswerDTOS.get(25));
        additionalLanguageList.add(foreignLanguageAnswerDTOS.get(26));
        additionalLanguageList.add(foreignLanguageAnswerDTOS.get(27));
        additionalLanguageList.add(foreignLanguageAnswerDTOS.get(28));
        additionalLanguageList.add(foreignLanguageAnswerDTOS.get(29));
        CommonForeignLanguageDTO commonForeignLanguageDTO = new CommonForeignLanguageDTO(additionalLanguageList);
        return ResponseEntity.ok(ResponseDTO.of(commonForeignLanguageDTO));
    }


    @Transactional
    @PostMapping("/dil-bilikleri/dil-bilikleri-substage")
    public String olympiad(@RequestParam Integer userId,
                           @RequestParam Integer languageQuestionId,
                           @RequestParam Integer languageAnswerId,
                           @RequestParam Integer whichLanguageQuestionId,
                           @RequestParam Integer whichLanguageAnswerId,
                           @RequestParam Integer certificateQuestionId,
                           @RequestParam Integer certificateAnswerId,
                           @RequestParam(required = false) Integer certificateResultQuestionId,
                           @RequestParam(required = false) Integer certificateResultAnswerId,
                           @RequestParam(required = false) Integer languageLevelEnglishQuestionId,
                           @RequestParam(required = false) Integer languageLevelEnglishAnswerId,
                           @RequestParam(required = false) Integer languageLevelRussianQuestionId,
                           @RequestParam(required = false) Integer languageLevelRussianAnswerId) {
        User user = userRepository.findById(userId).get();
        if (user != null) {

            ForeignLanguageUser userLanguage = new ForeignLanguageUser();
            ForeignLanguageUser userWhichLanguageKnow = new ForeignLanguageUser();
            ForeignLanguageUser userCertificate = new ForeignLanguageUser();
            ForeignLanguageUser userCertificateResult = new ForeignLanguageUser();
            ForeignLanguageUser userEnglishLanguageLevel = new ForeignLanguageUser();
            ForeignLanguageUser userRussianLanguageLevel = new ForeignLanguageUser();

            List<ForeignLanguageUser> foreignLanguageUsersList = new ArrayList<>();

            if (languageAnswerId != null && languageAnswerId != 0) {
                ForeignLanguageAnswer languageAnswer = foreignLanguageAnswersRepository.findById(languageAnswerId).get();
                userLanguage.setForeignLanguageAnswerId(languageAnswer);
            }
            if (languageQuestionId != null && languageQuestionId != 0) {
                ForeignLanguageQuestion languageQuestion = foreignLanguageQuestionsRepository.findById(languageQuestionId).get();
                if (languageAnswerId != null && languageAnswerId != 0) {
                    userLanguage.setUserId(user);
                    userLanguage.setForeignLanguageQuestionId(languageQuestion);
                    foreignLanguageUsersList.add(userLanguage);
                }
            }
            if (whichLanguageAnswerId != null && whichLanguageAnswerId != 0) {
                ForeignLanguageAnswer whichLanguageAnswer = foreignLanguageAnswersRepository.findById(whichLanguageAnswerId).get();
                userWhichLanguageKnow.setForeignLanguageAnswerId(whichLanguageAnswer);
            }
            if (whichLanguageQuestionId != null && whichLanguageQuestionId != 0) {
                ForeignLanguageQuestion whichLanguageQuestion = foreignLanguageQuestionsRepository.findById(whichLanguageQuestionId).get();
                if (whichLanguageAnswerId != null && whichLanguageAnswerId != 0) {
                    userWhichLanguageKnow.setUserId(user);
                    userWhichLanguageKnow.setForeignLanguageQuestionId(whichLanguageQuestion);
                    foreignLanguageUsersList.add(userWhichLanguageKnow);
                }
            }
            if (certificateAnswerId != null && certificateAnswerId != 0) {
                ForeignLanguageAnswer certificateAnswer = foreignLanguageAnswersRepository.findById(certificateAnswerId).get();
                userCertificate.setForeignLanguageAnswerId(certificateAnswer);
            }
            if (certificateQuestionId != null && certificateQuestionId != 0) {
                ForeignLanguageQuestion certificateQuestion = foreignLanguageQuestionsRepository.findById(certificateQuestionId).get();
                if (certificateAnswerId != null && certificateAnswerId != 0) {
                    userCertificate.setUserId(user);
                    userCertificate.setForeignLanguageQuestionId(certificateQuestion);
                    foreignLanguageUsersList.add(userCertificate);
                }
            }
            if (certificateResultAnswerId != null && certificateResultAnswerId != 0) {
                ForeignLanguageAnswer certificateResultAnswer = foreignLanguageAnswersRepository.findById(certificateResultAnswerId).get();
                userCertificateResult.setForeignLanguageAnswerId(certificateResultAnswer);
            }
            if (certificateResultQuestionId != null && certificateResultQuestionId != 0) {
                ForeignLanguageQuestion certificateResultQuestion = foreignLanguageQuestionsRepository.findById(certificateResultQuestionId).get();
                if (certificateResultAnswerId != null && certificateResultAnswerId != 0) {
                    userCertificateResult.setUserId(user);
                    userCertificateResult.setForeignLanguageQuestionId(certificateResultQuestion);
                    foreignLanguageUsersList.add(userCertificateResult);
                }
            }
            if (languageLevelEnglishAnswerId != null && languageLevelEnglishAnswerId != 0) {
                ForeignLanguageAnswer languageLevelEnglishAnswer = foreignLanguageAnswersRepository.findById(languageLevelEnglishAnswerId).get();
                userEnglishLanguageLevel.setForeignLanguageAnswerId(languageLevelEnglishAnswer);
            }
            if (languageLevelEnglishQuestionId != null && languageLevelEnglishQuestionId != 0) {
                ForeignLanguageQuestion languageLevelEnglishQuestion = foreignLanguageQuestionsRepository.findById(languageLevelEnglishQuestionId).get();
                if (languageLevelEnglishAnswerId != null && languageLevelEnglishAnswerId != 0) {
                    userEnglishLanguageLevel.setUserId(user);
                    userEnglishLanguageLevel.setForeignLanguageQuestionId(languageLevelEnglishQuestion);
                    foreignLanguageUsersList.add(userEnglishLanguageLevel);
                }
            }
            if (languageLevelRussianAnswerId != null && languageLevelRussianAnswerId != 0) {
                ForeignLanguageAnswer languageLevelRussianAnswer = foreignLanguageAnswersRepository.findById(languageLevelRussianAnswerId).get();
                userRussianLanguageLevel.setForeignLanguageAnswerId(languageLevelRussianAnswer);
            }
            if (languageLevelRussianQuestionId != null && languageLevelRussianQuestionId != 0) {
                ForeignLanguageQuestion languageLevelRussianQuestion = foreignLanguageQuestionsRepository.findById(languageLevelRussianQuestionId).get();
                if (languageLevelRussianAnswerId != null && languageLevelRussianAnswerId != 0) {
                    userRussianLanguageLevel.setUserId(user);
                    userRussianLanguageLevel.setForeignLanguageQuestionId(languageLevelRussianQuestion);
                    foreignLanguageUsersList.add(userRussianLanguageLevel);
                }
            }
            foreignLanguageUserRepository.saveAll(foreignLanguageUsersList);
        }
        return "foreignLanguage";
    }

    @Transactional
    @PostMapping("/dil-bilikleri/elave-dil-bilikleri-substage")
    public String additionalLanguages(@RequestParam Integer userId,
                                      @RequestParam Integer additionalLanguageQuestionId,
                                      @RequestParam Integer additionalLanguageAnswerId,
                                      @RequestParam Integer additionalLanguageLevelQuestionId,
                                      @RequestParam Integer additionalLanguageLevelAnswerId) {
        User user = userRepository.findById(userId).get();
        if (user != null) {

            ForeignLanguageUser userlanguage = new ForeignLanguageUser();
            ForeignLanguageUser userEnglishLanguageLevel = new ForeignLanguageUser();

            List<ForeignLanguageUser> foreignLanguageUsersList = new ArrayList<>();
            if (additionalLanguageAnswerId != null && additionalLanguageAnswerId != 0) {
                ForeignLanguageAnswer additionalLanguageAnswer = foreignLanguageAnswersRepository.findById(additionalLanguageAnswerId).get();
                userlanguage.setForeignLanguageAnswerId(additionalLanguageAnswer);
            }
            if (additionalLanguageQuestionId != null && additionalLanguageQuestionId != 0) {
                ForeignLanguageQuestion additionalLanguageQuestion = foreignLanguageQuestionsRepository.findById(additionalLanguageQuestionId).get();
                if (additionalLanguageAnswerId != null && additionalLanguageAnswerId != 0) {
                    userlanguage.setUserId(user);
                    userlanguage.setForeignLanguageQuestionId(additionalLanguageQuestion);
                    foreignLanguageUsersList.add(userlanguage);
                }
            }
            if (additionalLanguageLevelAnswerId != null && additionalLanguageLevelAnswerId != 0) {
                ForeignLanguageAnswer additionalLanguageLevel = foreignLanguageAnswersRepository.findById(additionalLanguageLevelAnswerId).get();
                userEnglishLanguageLevel.setForeignLanguageAnswerId(additionalLanguageLevel);
            }
            if (additionalLanguageLevelQuestionId != null && additionalLanguageLevelQuestionId != 0) {
                ForeignLanguageQuestion additionalLanguageLevelQuestion = foreignLanguageQuestionsRepository.findById(additionalLanguageLevelQuestionId).get();
                if (additionalLanguageLevelAnswerId != null && additionalLanguageLevelAnswerId != 0) {
                    userEnglishLanguageLevel.setUserId(user);
                    userEnglishLanguageLevel.setForeignLanguageQuestionId(additionalLanguageLevelQuestion);
                    foreignLanguageUsersList.add(userEnglishLanguageLevel);
                }
            }

            foreignLanguageUserRepository.saveAll(foreignLanguageUsersList);
        }
        return "əlavə dil bilikləri";
    }
}
