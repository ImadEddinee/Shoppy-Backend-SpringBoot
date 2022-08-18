package com.ensas.shoppybackendspring.mappers;

import com.ensas.shoppybackendspring.dtos.CountryDto;
import com.ensas.shoppybackendspring.entities.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    Country countryDtoToCountry(CountryDto countryDto);

    CountryDto countryToCountryDto(Country country);
}
