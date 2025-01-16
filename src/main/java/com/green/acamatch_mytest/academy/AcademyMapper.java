package com.green.acamatch_mytest.academy;

import com.green.acamatch_mytest.academy.model.PostAcademyReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AcademyMapper {
    int insAcademy(PostAcademyReq req);
}
