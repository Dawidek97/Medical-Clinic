package clinic.medical_clinic.mapper;

import clinic.medical_clinic.model.Specjalisation;
import clinic.medical_clinic.model.dtos.SpecjalisationDto;
import org.springframework.stereotype.Component;

@Component
public class SpecjalisationMapper implements Mapper<Specjalisation, SpecjalisationDto> {

    @Override
    public SpecjalisationDto map(Specjalisation from) {
        return SpecjalisationDto.builder()
                .title(from.getTitle())
                .doctor(from.getDoctor())
                .build();
    }

    @Override
    public Specjalisation reverseMap(SpecjalisationDto to) {
        return Specjalisation.builder()
                .title(to.getTitle())
                .doctor(to.getDoctor())
                .build();
    }
}

