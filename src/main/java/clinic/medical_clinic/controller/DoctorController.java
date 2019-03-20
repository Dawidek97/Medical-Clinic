package clinic.medical_clinic.controller;

import clinic.medical_clinic.repository.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

   private DoctorRepository doctorRepository;
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @GetMapping("/")
    public String allDoctors(ModelMap modelMap) {
        modelMap.put("doctors", doctorRepository.findAll());
        return "home";
    }
}