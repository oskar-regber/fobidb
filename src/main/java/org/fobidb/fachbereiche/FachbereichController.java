package org.fobidb.fachbereiche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API LAYER *******************************************************

@RestController //Die Klasse ist ein Rest-Controller. Dies bedeutet, dass sie HTTP-Anfragen empfängt und HTTP-Antworten zurückgibt. Außerdem: Alle Objekte sind Beans
@RequestMapping(path = "api/v1/Fachbereich") //Pfad im Browser
public class FachbereichController {

    private final FachbereichService FachbereichService;

    @Autowired
    public FachbereichController(FachbereichService FachbereichService) {
        this.FachbereichService = FachbereichService;
    }

    @GetMapping
    public List<Fachbereich> getFachbereich() {
        return FachbereichService.getFachbereich();
    }

    @PostMapping
    public void registerNewFachbereich(@RequestBody Fachbereich Fachbereich){
        FachbereichService.addNewFachbereich(Fachbereich);
    }

    @DeleteMapping(path = "{Fachbereich_Name}")
    public void deleteFachbereich(@PathVariable ("Fachbereich_Name") String Fachbereich_Name){
        FachbereichService.deleteFachbereich(Fachbereich_Name);
    }

    @PutMapping(path = "{Fachbereich_Name}")
    public void updateFachbereich(
            @PathVariable("Fachbereich_Name") String Fachbereich_Name){
        FachbereichService.updateFachbereich(Fachbereich_Name);
    }
}
