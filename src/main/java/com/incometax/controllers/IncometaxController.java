package com.incometax.controllers;

import com.incometax.models.dto.IncometaxDTO;
import com.incometax.models.dto.SalaryAnnualDTO;
import com.incometax.services.services.IncometaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class IncometaxController {
    @Autowired
    IncometaxService incometaxService;

    @QueryMapping
    public Mono<IncometaxDTO> calculateIncomeTax(@Argument String typeTax, @Argument SalaryAnnualDTO salaryAnnualDTO) {
        return incometaxService.calculateIncomeTax(typeTax, salaryAnnualDTO);
    }

}
