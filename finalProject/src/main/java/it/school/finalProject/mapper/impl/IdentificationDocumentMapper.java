package it.school.finalProject.mapper.impl;

import it.school.finalProject.dto.IndividualDto;
import it.school.finalProject.mapper.ObjectMapper;
import it.school.finalProject.persistence.entity.IdentificationDocument;
import org.springframework.stereotype.Component;

@Component
public class IdentificationDocumentMapper implements ObjectMapper<IndividualDto.IdentificationDocumentDto, IdentificationDocument> {


    @Override
    public IndividualDto.IdentificationDocumentDto mapToDto(IdentificationDocument identificationDocument) {
        return new IndividualDto.IdentificationDocumentDto(
                identificationDocument.getIdSeries(),
                identificationDocument.getIdType(),
                identificationDocument.getIdNumber(),
                identificationDocument.getIssueDate(),
                identificationDocument.getExpirationDate()
        );
    }

    @Override
    public IdentificationDocument mapToEntity(IndividualDto.IdentificationDocumentDto identificationDocumentDto) {
        IdentificationDocument identificationDocument = new IdentificationDocument();

        identificationDocument.setIdSeries(identificationDocumentDto.getIdSeries());
        identificationDocument.setIdNumber(identificationDocumentDto.getIdNumber());
        identificationDocument.setIdType(identificationDocumentDto.getIdType());
        identificationDocument.setIssueDate(identificationDocumentDto.getIssueDate());
        identificationDocument.setExpirationDate(identificationDocumentDto.getExpirationDate());

        return identificationDocument;

    }
}
