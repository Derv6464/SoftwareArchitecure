package com.darkplace.DarkplaceHospital;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AddContoller {

    @GetMapping("/")
    public String home(Model model) {
        // Add any data you want to pass to the template
        model.addAttribute("pageTitle", "Darkplace Hospital");

        // Return the template name
        return "index";
    }

    @PostMapping("/processForm")
    public String processForm(@RequestParam("action") String action) {
        if (action.equals("addpatient")) {
            // Code to handle adding a new patient
            return "addpatient";
        } else if (action.equals("patientLookup")) {
            // Code to handle searching the patient database
            // Redirect or process the search based on your requirements
            return "patientLookup";
        }

        // Default redirect if no matching action is found
        return "index";
    }

    @GetMapping("/addpatient")
    public String add() {
        return "add";
    }
}
