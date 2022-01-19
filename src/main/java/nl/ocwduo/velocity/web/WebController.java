package nl.ocwduo.velocity.web;

import nl.ocwduo.velocity.model.Persoon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @RequestMapping(value = "/opdracht1", method = RequestMethod.GET)
    public String test(@ModelAttribute("model") ModelMap model, @RequestParam(name = "body", defaultValue = "Default waarde") String body) {

        model.addAttribute("title", "De titel");
        model.addAttribute("body", body);

        return "opdr1";
    }

    @RequestMapping(value = "/opdracht2", method = RequestMethod.GET)
    public String lijstje(@ModelAttribute("model") ModelMap model) {
        ArrayList<String> lijst = new ArrayList<String>();
        lijst.add("Eén");
        lijst.add("Twee");
        lijst.add("Drie");
        lijst.add("Vier");
        lijst.add("Vijf");
        model.addAttribute("lijst", lijst);
        return "opdr2";
    }

    @RequestMapping(value = "/opdracht3", method = RequestMethod.GET)
    public String personenLijst(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("lijst", maakPersoonlijst());
        return "opdr3";
    }

    @RequestMapping(value = "/opdracht4", method = RequestMethod.GET)
    public String brief(@ModelAttribute("model") ModelMap model, @RequestParam(name = "id", defaultValue = "") String id) {
        int intId = 0;
        try {
            intId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            System.err.println("Geen valide int!");
        }
        List<Persoon> personen = maakPersoonlijst();
        Persoon persoon = null;

        for (Persoon p: personen) {
            if (p.getId() == intId) {
                persoon = p;
            }
        }

        model.addAttribute("persoon", persoon);

        return "opdr4";
    }

    private List<Persoon> maakPersoonlijst() {
        ArrayList<Persoon> lijstje = new ArrayList<Persoon>();

        Persoon p1 = new Persoon();
        p1.setId(1);
        p1.setFirstname("Henkie");
        p1.setLastname("de Boer");
        p1.setAge(20);
        p1.setBetaald(true);

        Persoon p2 = new Persoon();
        p2.setId(2);
        p2.setFirstname("Sjonnie");
        p2.setLastname("de Vries");
        p2.setAge(20);
        p2.setBetaald(false);

        Persoon p3 = new Persoon();
        p3.setId(3);
        p3.setFirstname("Jantje");
        p3.setLastname("Janssen");
        p3.setAge(20);
        p3.setBetaald(true);

        Persoon p4 = new Persoon();
        p4.setId(4);
        p4.setFirstname("Pietje");
        p4.setLastname("de Jong");
        p4.setAge(20);
        p4.setBetaald(false);

        lijstje.add(p1);
        lijstje.add(p2);
        lijstje.add(p3);
        lijstje.add(p4);

        return lijstje;
    }


}
