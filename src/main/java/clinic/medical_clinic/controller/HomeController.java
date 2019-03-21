package clinic.medical_clinic.controller;

import clinic.medical_clinic.model.dtos.PatientDto;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private PatientController patientController;

    public HomeController(PatientController patientController) {
        this.patientController = patientController;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }


    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute PatientDto patientDto) {
        patientController.addPatient(patientDto);
        return "redirect:/";
    }

}
