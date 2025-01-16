package com.green.acamatch_mytest.academy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcademyUpdateReq {
    private long acaId;

    @Schema(title = "학원이름")
    private String acaName;
    @Schema(title = "학원전화번호")
    private String acaPhone;
    @Schema(title = "학원내용")
    private String comment;
    @Schema(title = "강사 수")
    private int teacherNum;
    @Schema(title = "학원오픈시간")
    private String openTime;
    @Schema(title = "학원마감시간")
    private String closeTime;
    @Schema(title = "학원주소")
    private String address;
    @Schema(title = "학원사진")
    private String acaPic;
}
