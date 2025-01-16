package com.green.acamatch_mytest.academy;

import com.green.acamatch_mytest.academy.model.AcademyDeleteReq;
import com.green.acamatch_mytest.academy.model.AcademyPostReq;
import com.green.acamatch_mytest.academy.model.AcademyUpdateReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcademyMapper {
    int insAcademy(AcademyPostReq req);
    int updAcademy(AcademyUpdateReq req);
    int delAcademy(AcademyDeleteReq req);
}
