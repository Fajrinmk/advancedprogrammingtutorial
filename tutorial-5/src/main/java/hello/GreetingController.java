package hello;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", 
        required = false) String name, Model model) {
        if (!name.equals("")) {
            model.addAttribute("name", name);

            List<String> cv = new ArrayList<String>();
            cv.add("Name : Fajrin Maulana K.");
            cv.add("Birthplace, birthdate : Kuningan, 03/07/1998");
            cv.add("Address : Jl. Bintaro Rosalia 3 Blok TD no 12");
            cv.add("Education :");
            cv.add("SD An-Nisaa");
            cv.add("SMPN 19 Jakarta");
            cv.add("SMAN 47 Jakarta");
            cv.add("Universitas Indonesia");
            cv.add("Description : ");
            cv.add("A sophomore year student at Universitas Indonesia");
            cv.add("Majoring computer science, hoping to get my degree in 2 years from now");
            

            model.addAttribute("cv", cv);

        } else {
            model.addAttribute("name", "");
        }

        return "greeting";
    }

}
