package clinic.medical_clinic.controller;

import clinic.medical_clinic.model.dtos.PatientDto;
import clinic.medical_clinic.service.ServicePatient;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    private PatientRestController patientRestController;
    private ServicePatient servicePatient;

    public HomeController(PatientRestController patientRestController, ServicePatient servicePatient) {
        this.patientRestController = patientRestController;
        this.servicePatient = servicePatient;
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
        patientRestController.addPatient(patientDto);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String name, String surname) {
        try {
        servicePatient.deletePatient(name, surname);
        return "redirect:/";}
        catch(Exception e){
            return "redirect:/";
        }
    }

}