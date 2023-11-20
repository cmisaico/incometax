package com.incometax.services.services;

import com.incometax.models.dto.IncometaxDTO;
import com.incometax.models.dto.SalaryAnnualDTO;
import reactor.core.publisher.Mono;

public interface IncometaxService {

    public Mono<IncometaxDTO> calculateIncomeTax(String typeTax, SalaryAnnualDTO salaryAnnualDTO);

}
