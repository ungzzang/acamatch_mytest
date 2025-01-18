package com.green.acamatch_mytest.academy;

import com.green.acamatch_mytest.academy.model.AcademyDeleteReq;
import com.green.acamatch_mytest.academy.model.AcademyPostReq;
import com.green.acamatch_mytest.academy.model.AcademyUpdateReq;
import com.green.acamatch_mytest.academy.model.category.CategoryGetAgeRangeRes;
import com.green.acamatch_mytest.academy.model.category.CategoryGetDaysRes;
import com.green.acamatch_mytest.academy.model.category.CategoryGetLevelRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AcademyMapper {
    List<CategoryGetAgeRangeRes> selAgeRangeList();
    List<CategoryGetLevelRes> selLevelList();
    List<CategoryGetDaysRes> selDaysList();

    int insAcaAgeRange(AcademyPostReq req);
    int insAcaLevel(AcademyPostReq req);
    int insAcaDays(AcademyPostReq req);
    int insAcaTag(AcademyPostReq req);

    int insAcademy(AcademyPostReq req);
    int updAcademy(AcademyUpdateReq req);
    int delAcademy(AcademyDeleteReq req);
}
