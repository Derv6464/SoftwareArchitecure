import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddControllerTest {

    @Test
    void testLogin() {
        AddContoller controller = new AddContoller();
        Model model = mock(Model.class);

        String result = controller.login(model, null);

        assertEquals("login", result);
        assertNull(model.getAttribute("errorMessage"));

        String error = "Invalid credentials";
        result = controller.login(model, error);

        assertEquals("login", result);
        assertEquals(error, model.getAttribute("errorMessage"));
    }

    @Test
    void testLoginSubmit() {
        AddContoller controller = new AddContoller();
        String validUsername = "admin";
        String validPassword = "password";
        String invalidUsername = "user";
        String invalidPassword = "pass";
        RedirectView expectedRedirect = new RedirectView("/home");
        RedirectView errorRedirect = new RedirectView("/login?error=Invalid Username and Password");

        // Mock the UsersRepository to return a valid user for the valid credentials
        UsersRepository usersRepository = mock(UsersRepository.class);
        Users validUser = new Users(validUsername, validPassword);
        when(usersRepository.findAll()).thenReturn(List.of(validUser));
        controller.whitelist = usersRepository;

        RedirectView result = controller.login(validUsername, validPassword);

        assertEquals(expectedRedirect.getUrl(), result.getUrl());

        result = controller.login(invalidUsername, invalidPassword);

        assertEquals(errorRedirect.getUrl(), result.getUrl());
    }

    @Test
    void testSearchSpecificPatient() {
        AddContoller controller = new AddContoller();
        String existingSurname = "Smith";
        String nonExistingSurname = "Doe";
        RedirectView expectedRedirect = new RedirectView("/searchpatient?surname=" + existingSurname);
        RedirectView errorRedirect = new RedirectView("/searchpatient?error=No patients with that surname found.");

        // Mock the PatientsRepository to return a list of patients with the given surname
        PatientsRepository patientsRepository = mock(PatientsRepository.class);
        when(patientsRepository.findBySECONDNAME(existingSurname)).thenReturn(List.of(new Patients()));
        when(patientsRepository.findBySECONDNAME(nonExistingSurname)).thenReturn(null);
        controller.repository = patientsRepository;

        RedirectView result = controller.searchSpecificPatient(existingSurname);

        assertEquals(expectedRedirect.getUrl(), result.getUrl());

        result = controller.searchSpecificPatient(nonExistingSurname);

        assertEquals(errorRedirect.getUrl(), result.getUrl());
    }

    // You can continue writing tests for other methods in the AddController class

    @Test
    void testAddPatientToDB() {
        AddContoller controller = new AddContoller();
        String firstname = "John";
        String lastname = "Doe";
        String dob = "1990-01-01";
        String medInfo = "Medical Information";
        Boolean dead = false;

        // Mock the PatientsRepository to verify that save() method is called
        PatientsRepository patientsRepository = mock(PatientsRepository.class);
        controller.repository = patientsRepository;

        String result = controller.addPatientToDB(firstname, lastname, dob, medInfo, dead);

        assertEquals("home", result);
        // Verify that the save() method is called with the expected patient
        Patients expectedPatient = new Patients(firstname, lastname, dob, medInfo, dead, null);
        // Use the Mockito verify() method to check if the save() method is called with the expected patient
        Mockito.verify(patientsRepository).save(expectedPatient);
    }
}
