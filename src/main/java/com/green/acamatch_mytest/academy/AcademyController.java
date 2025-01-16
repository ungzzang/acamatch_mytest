package com.green.acamatch_mytest.academy;

import com.green.acamatch_mytest.academy.model.PostAcademyReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class AcademyController {
    private final AcademyService academyService;

    @PostMapping
    @Operation(summary = "학원정보등록")
    public int postAcademy(@RequestBody PostAcademyReq req) {
        academyService.insAcademy(req);
        return 1;
    }
}
