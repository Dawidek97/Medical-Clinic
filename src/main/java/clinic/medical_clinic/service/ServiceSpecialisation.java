package clinic.medical_clinic.service;

import clinic.medical_clinic.mapper.SpecjalisationMapper;
import clinic.medical_clinic.model.Specjalisation;
import clinic.medical_clinic.model.dtos.SpecjalisationDto;
import clinic.medical_clinic.repository.SpecjalisationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceSpecialisation {

    private SpecjalisationRepository specjalisationRepository;
    private SpecjalisationMapper specjalisationMapper;

    public ServiceSpecialisation(SpecjalisationRepository specjalisationRepository, SpecjalisationMapper specjalisationMapper) {
        this.specjalisationRepository = specjalisationRepository;
        this.specjalisationMapper = specjalisationMapper;
    }

    // ---------------------------------

    // FOR HOME CONTROLLER

    public List<Specjalisation> getAllSpecialisation() {
        return specjalisationRepository.findAll();
    }

    // ----------------------------------

    // FOR SPECJALISATION REST CONTROLLER

    public List<SpecjalisationDto> getSpecjalisationDto() {
        return specjalisationRepository
                .findAll()
                .stream()
                .map(specjalisationMapper::map)
                .collect(Collectors.toList());
    }

}
