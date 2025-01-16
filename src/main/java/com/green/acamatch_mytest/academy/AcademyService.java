package com.green.acamatch_mytest.academy;

import com.green.acamatch_mytest.academy.model.AcademyDeleteReq;
import com.green.acamatch_mytest.academy.model.AcademyPostReq;
import com.green.acamatch_mytest.academy.model.AcademyUpdateReq;
import com.green.acamatch_mytest.academy.model.UserMessage;
import com.green.acamatch_mytest.common.MyFileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcademyService {
    private final AcademyMapper academyMapper;
    private final MyFileUtils myFileUtils;
    private final UserMessage userMessage;

    public int insAcademy(MultipartFile pic, AcademyPostReq req) {



        String savedPicName = (pic != null ? myFileUtils.makeRandomFileName(pic) : null);

        req.setAcaPic(savedPicName);

        int result = academyMapper.insAcademy(req);
        if(pic == null){
            userMessage.setMessage("학원정보등록이 완료되었습니다.");
            return result;
        }

        long acaId = req.getAcaId();
        String middlePath = String.format("academy/%d", acaId);
        myFileUtils.makeFolders(middlePath);
        String filePath = String.format("%s/%s", middlePath, savedPicName);

        try{
            myFileUtils.transferTo(pic, filePath);
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    public int updAcademy(MultipartFile pic, AcademyUpdateReq req) {
        // 프로필 사진 처리
        if (pic != null && !pic.isEmpty()) {
            String targetDir = String.format("%s/%d", "academy", req.getAcaId());
            myFileUtils.makeFolders(targetDir);

            String savedFileName = myFileUtils.makeRandomFileName(pic);
            req.setAcaPic(savedFileName);

            // 기존 파일 삭제
            String deletePath = String.format("%s/academy/%d", myFileUtils.getUploadPath(), req.getAcaId());
            myFileUtils.deleteFolder(deletePath, false);

            // 파일 저장
            String filePath = String.format("%s/%s", targetDir, savedFileName);

            try{
                myFileUtils.transferTo(pic, filePath);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        academyMapper.updAcademy(req);
        return 1;
    }

    public int delAcademy(AcademyDeleteReq req) {
        academyMapper.delAcademy(req);
        return 1;
    }
}
