package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.commonDTO.CommonExperienceDTO;
import com.company.dto.commonDTO.CommonProgramDTO;
import com.company.dto.entityDTO.ExperienceAnswerDTO;
import com.company.dto.entityDTO.ExperienceQuestionDTO;
import com.company.dto.entityDTO.ProgramAnswerDTO;
import com.company.dto.entityDTO.ProgramQuestionDTO;
import com.company.entity.*;
import com.company.inter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ProgramController {

    @Autowired
    private ProgramQuestionRepository programQuestionRepository;
    @Autowired
    private ProgramAnswerRepository programAnswerRepository;
    @Autowired
    private ProgramUserRepository programUserRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/program-skills")
    public ResponseEntity<ResponseDTO> program() {
        List<ProgramQuestion> programQuestions = programQuestionRepository.findAll();
        List<ProgramAnswer> programAnswers = programAnswerRepository.findAll();

        List<ProgramQuestionDTO> programQuestionDTOS = new ArrayList<>();
        List<ProgramAnswerDTO> programAnswerDTOS = new ArrayList<>();
        for (ProgramQuestion u : programQuestions) {
            programQuestionDTOS.add(new ProgramQuestionDTO(u));
        }
        for (ProgramAnswer u : programAnswers) {
            programAnswerDTOS.add(new ProgramAnswerDTO(u));
        }
        List programNameList = new ArrayList<>();
        programNameList.add(programQuestionDTOS.get(0));
        programNameList.add(programAnswerDTOS.get(0));
        programNameList.add(programAnswerDTOS.get(1));
        programNameList.add(programAnswerDTOS.get(2));
        programNameList.add(programAnswerDTOS.get(3));
        programNameList.add(programAnswerDTOS.get(4));


        List msOfficeExperienceList = new ArrayList();
        msOfficeExperienceList.add(programQuestionDTOS.get(1));
        msOfficeExperienceList.add(programAnswerDTOS.get(0));
        msOfficeExperienceList.add(programAnswerDTOS.get(1));
        msOfficeExperienceList.add(programAnswerDTOS.get(2));
        msOfficeExperienceList.add(programAnswerDTOS.get(3));
        msOfficeExperienceList.add(programAnswerDTOS.get(4));

        List experienceList = new ArrayList();
        experienceList.add(programQuestionDTOS.get(2));
        experienceList.add(programAnswerDTOS.get(5));
        experienceList.add(programAnswerDTOS.get(6));
        experienceList.add(programAnswerDTOS.get(7));

        List programmingLanguageList = new ArrayList();
        programmingLanguageList.add(programQuestionDTOS.get(3));
        programmingLanguageList.add(programAnswerDTOS.get(8));
        programmingLanguageList.add(programAnswerDTOS.get(9));
        programmingLanguageList.add(programAnswerDTOS.get(10));
        programmingLanguageList.add(programAnswerDTOS.get(11));
        programmingLanguageList.add(programAnswerDTOS.get(12));


        List designProgramList = new ArrayList();
        designProgramList.add(programQuestionDTOS.get(4));
        programmingLanguageList.add(programAnswerDTOS.get(13));
        programmingLanguageList.add(programAnswerDTOS.get(14));
        programmingLanguageList.add(programAnswerDTOS.get(15));
        programmingLanguageList.add(programAnswerDTOS.get(16));

        List additionalProgramLanguageList = new ArrayList();
        additionalProgramLanguageList.add(programQuestionDTOS.get(5));
        additionalProgramLanguageList.add(programAnswerDTOS.get(17));

        CommonProgramDTO commonProgramDTO = new CommonProgramDTO(experienceList, programNameList, msOfficeExperienceList, programmingLanguageList, designProgramList, additionalProgramLanguageList);
        return ResponseEntity.ok(ResponseDTO.of(commonProgramDTO));
    }

    @PostMapping("/tecrube")
    public String experience(@RequestParam Integer userId,
                             @RequestParam Integer programTypeQuestionId,
                             @RequestParam Integer programTypeAnswerId,
                             @RequestParam Integer msOfficeProgramExperienceQuestionId,
                             @RequestParam Integer msOfficeProgramExperienceAnswerId,
                             @RequestParam Integer wordExperienceQuestionId,
                             @RequestParam Integer wordExperienceAnswerId,
                             @RequestParam Integer excelExperienceQuestionId,
                             @RequestParam Integer excelExperienceAnswerId,
                             @RequestParam Integer ppExperienceQuestionId,
                             @RequestParam Integer ppExperienceAnswerId,
                             @RequestParam Integer programmingLanguageQuestionId,
                             @RequestParam Integer programmingLanguageAnswerId,
                             @RequestParam Integer pythonExperienceQuestionId,
                             @RequestParam Integer pythonExperienceAnswerId,
                             @RequestParam Integer javaExperienceQuestionId,
                             @RequestParam Integer javaExperienceAnswerId,
                             @RequestParam Integer cExperienceQuestionId,
                             @RequestParam Integer cExperienceAnswerId,
                             @RequestParam Integer cSharpExperienceQuestionId,
                             @RequestParam Integer cSharpExperienceAnswerId) {

        User user = userRepository.findById(userId).get();
        if (user != null) {
            ProgramUser programType = new ProgramUser();
            ProgramUser msOfficeProgramExperience = new ProgramUser();
            ProgramUser wordExperience = new ProgramUser();
            ProgramUser excelExperience = new ProgramUser();
            ProgramUser ppExperience = new ProgramUser();
            ProgramUser programmingLanguage = new ProgramUser();
            ProgramUser pythonExperience = new ProgramUser();
            ProgramUser javaExperience = new ProgramUser();
            ProgramUser cExperience = new ProgramUser();
            ProgramUser cSharpExperience = new ProgramUser();

            List<ProgramUser> programUserList = new ArrayList<>();

            if (programTypeAnswerId != null && programTypeAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(programTypeAnswerId).get();
                programType.setProgramAnswerId(programAnswer);
            }
            if (programTypeQuestionId != null && programTypeQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(programTypeQuestionId).get();
                if (programTypeAnswerId != null && programTypeAnswerId != 0) {
                    programType.setUserId(user);
                    programType.setProgramQuestionId(programQuestion);
                    programUserList.add(programType);
                }
            }

            if (msOfficeProgramExperienceAnswerId != null && msOfficeProgramExperienceAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(msOfficeProgramExperienceAnswerId).get();
                msOfficeProgramExperience.setProgramAnswerId(programAnswer);
            }

            if (msOfficeProgramExperienceQuestionId != null && msOfficeProgramExperienceQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(msOfficeProgramExperienceQuestionId).get();

                if (msOfficeProgramExperienceAnswerId != null && msOfficeProgramExperienceAnswerId != 0) {
                    msOfficeProgramExperience.setUserId(user);
                    msOfficeProgramExperience.setProgramQuestionId(programQuestion);
                    programUserList.add(msOfficeProgramExperience);
                }
            }

            if (wordExperienceAnswerId != null && wordExperienceAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(wordExperienceAnswerId).get();
                wordExperience.setProgramAnswerId(programAnswer);
            }

            if (wordExperienceQuestionId != null && wordExperienceQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(wordExperienceQuestionId).get();

                if (wordExperienceAnswerId != null && wordExperienceAnswerId != 0) {
                    wordExperience.setUserId(user);
                    wordExperience.setProgramQuestionId(programQuestion);
                    programUserList.add(wordExperience);
                }
            }

            if (excelExperienceAnswerId != null && excelExperienceAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(excelExperienceAnswerId).get();
                excelExperience.setProgramAnswerId(programAnswer);
            }

            if (excelExperienceQuestionId != null && excelExperienceQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(excelExperienceQuestionId).get();
                if (excelExperienceAnswerId != null && excelExperienceAnswerId != 0) {
                    excelExperience.setUserId(user);
                    excelExperience.setProgramQuestionId(programQuestion);
                    programUserList.add(excelExperience);
                }
            }
            if (ppExperienceAnswerId != null && ppExperienceAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(ppExperienceAnswerId).get();
                ppExperience.setProgramAnswerId(programAnswer);
            }

            if (ppExperienceQuestionId != null && ppExperienceQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(ppExperienceQuestionId).get();

                if (ppExperienceAnswerId != null && ppExperienceAnswerId != 0) {
                    ppExperience.setUserId(user);
                    ppExperience.setProgramQuestionId(programQuestion);
                    programUserList.add(ppExperience);
                }
            }

            if (programmingLanguageAnswerId != null && programmingLanguageAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(programmingLanguageAnswerId).get();
                programmingLanguage.setProgramAnswerId(programAnswer);
            }

            if (programmingLanguageQuestionId != null && programmingLanguageQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(programmingLanguageQuestionId).get();
                if (programmingLanguageAnswerId != null && programmingLanguageAnswerId != 0) {
                    programmingLanguage.setUserId(user);
                    programmingLanguage.setProgramQuestionId(programQuestion);
                    programUserList.add(programmingLanguage);
                }
            }


            if (pythonExperienceAnswerId != null && pythonExperienceAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(pythonExperienceAnswerId).get();
                pythonExperience.setProgramAnswerId(programAnswer);
            }

            if (pythonExperienceQuestionId != null && pythonExperienceQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(pythonExperienceQuestionId).get();

                if (pythonExperienceAnswerId != null && pythonExperienceAnswerId != 0) {
                    pythonExperience.setUserId(user);
                    pythonExperience.setProgramQuestionId(programQuestion);
                    programUserList.add(pythonExperience);
                }
            }

            if (javaExperienceAnswerId != null && javaExperienceAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(javaExperienceAnswerId).get();
                javaExperience.setProgramAnswerId(programAnswer);
            }

            if (javaExperienceQuestionId != null && javaExperienceQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(javaExperienceQuestionId).get();
                if (javaExperienceAnswerId != null && javaExperienceAnswerId != 0) {
                    javaExperience.setUserId(user);
                    javaExperience.setProgramQuestionId(programQuestion);
                    programUserList.add(javaExperience);
                }
            }

            if (cExperienceAnswerId != null && cExperienceAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(cExperienceAnswerId).get();
                cExperience.setProgramAnswerId(programAnswer);
            }

            if (cExperienceQuestionId != null && cExperienceQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(cExperienceQuestionId).get();

                if (cExperienceAnswerId != null && cExperienceAnswerId != 0) {
                    cExperience.setUserId(user);
                    cExperience.setProgramQuestionId(programQuestion);
                    programUserList.add(cExperience);
                }
            }

            if (cSharpExperienceAnswerId != null && cExperienceAnswerId != 0) {
                ProgramAnswer programAnswer = programAnswerRepository.findById(cExperienceAnswerId).get();
                cSharpExperience.setProgramAnswerId(programAnswer);
            }

            if (cSharpExperienceQuestionId != null && cSharpExperienceQuestionId != 0) {
                ProgramQuestion programQuestion = programQuestionRepository.findById(cSharpExperienceQuestionId).get();
                if (cSharpExperienceAnswerId != null && cSharpExperienceAnswerId != 0) {
                    cSharpExperience.setUserId(user);
                    cSharpExperience.setProgramQuestionId(programQuestion);
                    programUserList.add(cSharpExperience);
                }
            }

            programUserRepository.saveAll(programUserList);
        }
        return "program";
    }

}
