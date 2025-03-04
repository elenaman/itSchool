package it.school.finalProject.mapper;

import org.springframework.stereotype.Component;

@Component
public interface ObjectMapper<T, R> {

    T mapToDto(R r);

    R mapToEntity(T t);

}
