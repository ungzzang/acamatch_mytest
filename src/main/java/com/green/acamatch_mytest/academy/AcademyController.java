package com.green.acamatch_mytest.academy;

import com.green.acamatch_mytest.academy.model.AcademyDeleteReq;
import com.green.acamatch_mytest.academy.model.AcademyPostReq;
import com.green.acamatch_mytest.academy.model.AcademyUpdateReq;
import com.green.acamatch_mytest.academy.model.category.CategoryGetAgeRangeRes;
import com.green.acamatch_mytest.academy.model.category.CategoryGetDaysRes;
import com.green.acamatch_mytest.academy.model.category.CategoryGetLevelRes;
import com.green.acamatch_mytest.common.model.ResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("academy")
@RequiredArgsConstructor
@Tag(name = "학원")
public class AcademyController {
    private final AcademyService academyService;

    @GetMapping("age")
    @Operation(summary = "수강연령대 select")
    public ResultResponse<List<CategoryGetAgeRangeRes>> selCategoryAgeRangeList() {
        List<CategoryGetAgeRangeRes> list = academyService.categoryAgeRangeResList();
        return ResultResponse.<List<CategoryGetAgeRangeRes>>builder()
                .resultMsg("수강연령대 select 성공")
                .resultData(list)
                .build();
    }

    @GetMapping("level")
    @Operation(summary = "수준 select")
    public ResultResponse<List<CategoryGetLevelRes>> selCategoryLevelList() {
        List<CategoryGetLevelRes> list = academyService.categoryLevelResList();
        return ResultResponse.<List<CategoryGetLevelRes>>builder()
                .resultMsg("요일 select 성공")
                .resultData(list)
                .build();
    }

    @GetMapping("days")
    @Operation(summary = "요일 select")
    public ResultResponse<List<CategoryGetDaysRes>> selCategoryDaysList() {
        List<CategoryGetDaysRes> list = academyService.categoryDaysResList();
        return ResultResponse.<List<CategoryGetDaysRes>>builder()
                .resultMsg("요일 select 성공")
                .resultData(list)
                .build();
    }

    @PostMapping
    @Operation(summary = "학원정보등록")
    public ResultResponse<Integer> postAcademy(@RequestPart(required = false) MultipartFile pic, @RequestPart AcademyPostReq req) {
        academyService.insAcademy(pic, req);
        academyService.insAcaAgeRange(req);
        academyService.insAcaLevel(req);
        academyService.insAcaDays(req);
        academyService.insAcaTag(req);
        return ResultResponse.<Integer>builder()
                .resultMsg("학원정보등록성공")
                .resultData(1)
                .build();
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
