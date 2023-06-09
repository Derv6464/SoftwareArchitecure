package com.darkplace.DarkplaceHospital;

import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;

@Controller
public class AddContoller {

    @Autowired
    private PatientsRepository repository;

    @Autowired
    private UsersRepository whitelist;

    @GetMapping("/")
    public String index(Model model) {
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model, String error) {
        if (error != null) {
            model.addAttribute("errorMessage", error);
        }
        return "login";
    }

    @PostMapping("/loginSubmit")
    public RedirectView login(@RequestParam("username") String username,
            @RequestParam("password") String password) {

        Iterable<Users> users = whitelist.findAll();

        for (Users user : users) {
            if (user.getUSERNAME().equals(username) && user.getPASSWORD().equals(password)) {
                return new RedirectView("/home");
            }
        }
        return new RedirectView("/login?error=Invalid Username and Password");
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/addpatient")
    public String addpatient() {
        return "addpatient";
    }

    @PostMapping("/addPatientToDB")
    public String addPatientToDB(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
            @RequestParam("dob") String dob, @RequestParam("medInfo") String medInfo,
            @RequestParam("dead") Boolean dead) {
        String[] meds = { "Morphine", "Peniectomies", "Oxycotion", "Adderal", "Xanax", "Paracetamol", "Sudafed",
                "Exputex", "Zertec" };
        Patients submittedPatient = new Patients(firstname, lastname, dob, medInfo, dead,
                meds[(int) (Math.random() * meds.length)]);
        repository.save(submittedPatient);
        return "home";
    }

    @RequestMapping("/searchpatient")
    public String searchpatient(Model model, String surname, String error) {
        Iterable<Patients> ids = repository.findAll();
        if (surname != null) {
            ids = repository.findBySECONDNAME(surname);
        }
        if (error != null) {
            model.addAttribute("errorMessage", error);
        }

        List<String> fNames = new ArrayList<String>();
        List<String> lNames = new ArrayList<String>();
        List<Date> dobs = new ArrayList<Date>();
        List<String> medInfos = new ArrayList<String>();
        List<Boolean> deads = new ArrayList<Boolean>();
        List<String> meds = new ArrayList<String>();

        displayTable(model, ids, fNames, lNames, dobs, medInfos, deads, meds);

        return "searchpatient";
    }

    @PostMapping("/searchSpecificPatient")
    public RedirectView searchSpecificPatient(@RequestParam("searchbar") String searchbar) {
        if (searchbar == null || searchbar == "") {
            return new RedirectView("/searchpatient");
        }

        if (repository.findBySECONDNAME(searchbar) == null || repository.findBySECONDNAME(searchbar).isEmpty()) {
            return new RedirectView("/searchpatient?error=No patients with that surname found.");
        }
        String queryParam = "?surname=";
        queryParam += searchbar;

        return new RedirectView("/searchpatient" + queryParam);
    }

    public void displayTable(Model model, Iterable<Patients> ids, List<String> fNames, List<String> lNames,
            List<Date> dobs, List<String> medInfos, List<Boolean> deads, List<String> meds) {
        for (Patients id : ids) {
            fNames.add(id.getNAME());
            lNames.add(id.getSECONDNAME());
            dobs.add(id.getDOB());
            medInfos.add(id.getMEDICALINFORMATION());
            deads.add(id.getISDEAD());
            meds.add(id.getMEDICATION());

        }
        model.addAttribute("fNames", fNames);
        model.addAttribute("lNames", lNames);
        model.addAttribute("dobs", dobs);
        model.addAttribute("medInfos", medInfos);
        model.addAttribute("deads", deads);
        model.addAttribute("meds", meds);
    }

}