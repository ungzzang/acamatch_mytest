package com.green.acamatch_mytest.academy;

import com.green.acamatch_mytest.academy.model.PostAcademyReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AcademyService {
    private final AcademyMapper academyMapper;

    public int insAcademy(PostAcademyReq req) {
        academyMapper.insAcademy(req);
        return 1;
    }
}
