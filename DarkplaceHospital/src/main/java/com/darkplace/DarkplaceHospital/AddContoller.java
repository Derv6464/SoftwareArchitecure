package com.darkplace.DarkplaceHospital;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AddContoller {

    @Autowired
    private PatientsRepository repository;

    @GetMapping("/")
    public String index(Model model) {
        return "login";
    }

    @PostMapping("/loginSubmit")
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return "home";
        } else {
            return "login";
        }

    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/processForm")
    public String processForm(@RequestParam("action") String action) {
        if (action.equals("addpatient")) {
            // Code to handle adding a new patient
            return "addpatient";
        } else if (action.equals("patientlookup")) {
            // Code to handle searching the patient database
            // Redirect or process the search based on your requirements
            return "searchpatient";
        }

        // Default redirect if no matching action is found
        return "home";
    }

    @GetMapping("/addpatient")
    public String add() {
        return "addpatient";
    }

    @PostMapping("/addPatientToDB")
    public String addPatientToDB(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
            @RequestParam("dob") String dob, @RequestParam("medInfo") String medInfo,
            @RequestParam("dead") Boolean dead) {

        Patients submittedPatient = new Patients(firstname, lastname, dob, medInfo, dead);
        repository.save(submittedPatient);
        return "home";
    }

    @GetMapping("/searchpatient")
    public String search() {
        return "searchpatient";
    }

}
