package clinic.medical_clinic.controller;

import clinic.medical_clinic.model.dtos.SpecjalisationDto;
import clinic.medical_clinic.service.ServiceSpecialisation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecjalisationRestController {

    private ServiceSpecialisation serviceSpecialisation;

    public SpecjalisationRestController(ServiceSpecialisation serviceSpecialisation) {
        this.serviceSpecialisation = serviceSpecialisation;
    }

    @GetMapping("/dto/specjalisation")
    public List<SpecjalisationDto> getSpecjalisationDto() {
        return serviceSpecialisation.getSpecjalisationDto();
    }
}
