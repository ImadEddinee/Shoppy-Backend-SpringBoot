package com.ensas.shoppybackendspring.mappers;

import com.ensas.shoppybackendspring.dtos.StateDto;
import com.ensas.shoppybackendspring.entities.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {

    StateDto stateToStateDto(State state);

    State stateDtoToState(StateDto stateDto);
}
