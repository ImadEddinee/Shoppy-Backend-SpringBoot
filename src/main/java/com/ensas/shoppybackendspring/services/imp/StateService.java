package com.ensas.shoppybackendspring.services.imp;

import com.ensas.shoppybackendspring.dtos.StateDto;
import com.ensas.shoppybackendspring.exceptions.CountryNotFoundException;
import com.ensas.shoppybackendspring.mappers.StateMapper;
import com.ensas.shoppybackendspring.repositories.CountryRepository;
import com.ensas.shoppybackendspring.repositories.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;
    private final StateMapper stateMapper;
    private final CountryRepository countryRepository;

    public List<StateDto> findByCountryCode(String code){
        countryRepository.findByCode(code).orElseThrow(
                () -> new CountryNotFoundException("There is no country with code : " + code));
        return stateRepository.findByCountryCode(code).stream()
                .map(stateMapper::stateToStateDto)
                .collect(Collectors.toList());
    }

}
