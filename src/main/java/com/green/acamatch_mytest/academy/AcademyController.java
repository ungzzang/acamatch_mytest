package com.green.acamatch_mytest.academy;

import com.green.acamatch_mytest.academy.model.AcademyDeleteReq;
import com.green.acamatch_mytest.academy.model.AcademyPostReq;
import com.green.acamatch_mytest.academy.model.AcademyUpdateReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("academy")
@RequiredArgsConstructor
@Tag(name = "학원")
public class AcademyController {
    private final AcademyService academyService;

    @PostMapping
    @Operation(summary = "학원정보등록")
    public int postAcademy(@RequestPart(required = false) MultipartFile pic, @RequestPart AcademyPostReq req) {
        academyService.insAcademy(pic, req);
        return 1;
    }

    @PutMapping
    @Operation(summary = "학원정보수정")
    public int putAcademy(@RequestPart(required = false) MultipartFile pic, @RequestPart AcademyUpdateReq req) {
        academyService.updAcademy(pic, req);
        return 1;
    }

    @DeleteMapping
    @Operation(summary = "학원정보삭제")
    public int deleteAcademy(@ModelAttribute AcademyDeleteReq req) {
        academyService.delAcademy(req);
        return 1;
    }

}
