package com.ensas.shoppybackendspring.services.imp;

import com.ensas.shoppybackendspring.dtos.CountryDto;
import com.ensas.shoppybackendspring.mappers.CountryMapper;
import com.ensas.shoppybackendspring.repositories.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public List<CountryDto> getAllCountries(){
        return countryRepository.findAll().stream()
                .map(countryMapper::countryToCountryDto)
                .collect(Collectors.toList());
    }

}
