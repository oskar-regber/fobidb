package org.fobidb.fortbildungen;

import org.fobidb.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API LAYER *******************************************************

@RestController //Die Klasse ist ein Rest-Controller. Dies bedeutet, dass sie HTTP-Anfragen empfängt und HTTP-Antworten zurückgibt. Außerdem: Alle Objekte sind Beans
@RequestMapping(path = "api/v1/fortbildung") //Pfad im Browser
public class FortbildungController {

    private final FortbildungService FortbildungService;
    private final FortbildungService fortbildungService;

    @Autowired
    public FortbildungController(FortbildungService FortbildungService, FortbildungService fortbildungService) {
        this.FortbildungService = FortbildungService;
        this.fortbildungService = fortbildungService;
    }

    @GetMapping
    public List<Fortbildung> getFortbildung() {
        return FortbildungService.getFortbildungen();
    }

    /*@PostMapping
    public void registerNewFortbildung(
            @RequestParam(required = false) String fortbildungstitel,
            @RequestParam(required = false) String datum,
            @RequestParam(required = false) String kursleiter,
            @RequestParam(required = false) int dauer_min,
            @RequestParam(required = false) String anbieter_name){
        Fortbildung fortbildung = new Fortbildung(fortbildungstitel, datum, kursleiter, dauer_min, anbieter_name);
        FortbildungService.addNewFortbildung(fortbildung);
    }*/

    @PostMapping
    public void registerNewFortbildung(@RequestBody Fortbildung fortbildung){
        System.out.println(fortbildung.Anbieter_Name);
        fortbildungService.addNewFortbildung(fortbildung);
    }

    @DeleteMapping(path = "{Fortbildung_ID}")
    public void deleteFortbildung(@PathVariable ("Fortbildung_ID") Long Fortbildung_ID){
        FortbildungService.deleteFortbildung(Fortbildung_ID);
    }


//
//    @PutMapping(path = "{Fortbildung_Name}")
//    public void updateFortbildung(
//            @PathVariable("Fortbildung_Name") String Fortbildung_Name){
//        FortbildungService.updateFortbildung(Fortbildung_Name);
//    }
}
