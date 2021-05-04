package com.covidmanage.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VaccineSituationDataDTO {
    private String country;
    private String date;
    private String vaccinations;
    private Integer totalVaccinations;
    private Double totalVaccinationsPerHundred;
}
