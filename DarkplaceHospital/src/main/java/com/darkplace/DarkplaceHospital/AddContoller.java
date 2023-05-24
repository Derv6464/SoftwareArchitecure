package com.darkplace.DarkplaceHospital;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddContoller {
        @GetMapping("/addpatient")
        public String add() {
            return "add";
        }
}
