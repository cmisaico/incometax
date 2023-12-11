package com.incometax.services.services.impl;

import com.incometax.models.dto.IncometaxDTO;
import com.incometax.models.dto.SalaryAnnualDTO;
import com.incometax.models.dto.TypeTax;
import com.incometax.services.services.IncometaxService;
import com.incometax.utils.IncometaxUtil;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class IncometaxServiceImpl implements IncometaxService {
    @Override
    public Mono<IncometaxDTO> calculateIncomeTax(String typeTax, SalaryAnnualDTO salaryAnnualDTO) {
        IncometaxDTO incometaxDTO;
        if(typeTax.equals(TypeTax.FOURTH_CATEGORY.getTypeTax())) {
            incometaxDTO = calculate4Category(salaryAnnualDTO.getAnnualSalary());
        } else if (typeTax.equals(TypeTax.FIFTH_CATEGORY.getTypeTax())) {
            incometaxDTO = calculate5Category(salaryAnnualDTO.getAnnualSalary());
        } else {
            incometaxDTO = new IncometaxDTO();
            incometaxDTO.setTypeTax("No existe categoría");
            incometaxDTO.setAmount(0);
        }
        return Mono.just(incometaxDTO);
    }

    private IncometaxDTO calculate4Category(float salary){
        // Discount 20%
        float discount20 = salary - (salary * IncometaxUtil.DISCOUNT_INITIAL);
        // Discount 7 UIT
        float discountUITs = discount20 - (IncometaxUtil.UIT * IncometaxUtil.DISCOUNT_UIT);
        float discountFirstSection = 0;
        float discountSecondSection = 0;
        float discountThirdSection = 0;
        float discountFourthSection = 0;
        float discountFifthSection = 0;
        // Discount 8%
        if(discountUITs <= IncometaxUtil.UIT * 5 && discountUITs > 0 * IncometaxUtil.UIT) {
            discountFirstSection = (discountUITs - (0 * IncometaxUtil.UIT)) * IncometaxUtil.FIRST_SECTION_DISCOUNT;
        } else if(discountUITs <= IncometaxUtil.UIT * 20 && discountUITs > 5 * IncometaxUtil.UIT) {
            discountFirstSection = (5 * IncometaxUtil.UIT) * IncometaxUtil.FIRST_SECTION_DISCOUNT;
            discountSecondSection = (discountUITs - (5 * IncometaxUtil.UIT)) * IncometaxUtil.SECOND_SECTION_DISCOUNT;
        } else if(discountUITs <= IncometaxUtil.UIT * 35 && discountUITs > 20 * IncometaxUtil.UIT) {
            discountFirstSection = (5 * IncometaxUtil.UIT) * IncometaxUtil.FIRST_SECTION_DISCOUNT;
            discountSecondSection = (15 * IncometaxUtil.UIT) * IncometaxUtil.SECOND_SECTION_DISCOUNT;
            discountThirdSection = (discountUITs - (20 * IncometaxUtil.UIT)) * IncometaxUtil.THIRD_SECTION_DISCOUNT;
        } else if(discountUITs <= IncometaxUtil.UIT * 45 && discountUITs > 35 * IncometaxUtil.UIT) {
            discountFirstSection = (5 * IncometaxUtil.UIT) * IncometaxUtil.FIRST_SECTION_DISCOUNT;
            discountSecondSection = (15 * IncometaxUtil.UIT) * IncometaxUtil.SECOND_SECTION_DISCOUNT;
            discountThirdSection = (15 * IncometaxUtil.UIT) * IncometaxUtil.THIRD_SECTION_DISCOUNT;
            discountFourthSection = (discountUITs - (35 * IncometaxUtil.UIT)) * IncometaxUtil.FOURTH_SECTION_DISCOUNT;
        } else if(discountUITs > 45 * IncometaxUtil.UIT) {
            discountFirstSection = (5 * IncometaxUtil.UIT) * IncometaxUtil.FIRST_SECTION_DISCOUNT;
            discountSecondSection = (15 * IncometaxUtil.UIT) * IncometaxUtil.SECOND_SECTION_DISCOUNT;
            discountThirdSection = (15 * IncometaxUtil.UIT) * IncometaxUtil.THIRD_SECTION_DISCOUNT;
            discountFourthSection = (10 * IncometaxUtil.UIT) * IncometaxUtil.FOURTH_SECTION_DISCOUNT;
            discountFifthSection = (discountUITs - (45 * IncometaxUtil.UIT)) * IncometaxUtil.FIFTH_SECTION_DISCOUNT;
        }

        float amount = discountFirstSection + discountSecondSection + discountThirdSection + discountFourthSection + discountFifthSection;

        return new IncometaxDTO.Builder()
                .firstDiscount(discountFirstSection)
                .secondDiscount(discountSecondSection)
                .thirdDiscount(discountThirdSection)
                .fourthDiscount(discountFourthSection)
                .fifthDiscount(discountFifthSection)
                .amount(amount)
                .typeTax(TypeTax.FOURTH_CATEGORY.getTypeTax())
                .build();
    }

    private IncometaxDTO calculate5Category(float salary){
        return null;
    }


}
