package org.fobidb.anbieter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// API LAYER *******************************************************

@RestController //Die Klasse ist ein Rest-Controller. Dies bedeutet, dass sie HTTP-Anfragen empfängt und HTTP-Antworten zurückgibt. Außerdem: Alle Objekte sind Beans
@RequestMapping(path = "api/v1/anbieter") //Pfad im Browser
public class AnbieterController {

    private final AnbieterService AnbieterService;

    @Autowired
    public AnbieterController(AnbieterService AnbieterService) {
        this.AnbieterService = AnbieterService;
    }

    @GetMapping
    public List<Anbieter> getAnbieter() {
        return AnbieterService.getAnbieter();
    }

    @PostMapping
    public void registerNewAnbieter(@RequestBody Anbieter Anbieter){
        System.out.println("Arrived" + Anbieter.toString());
        AnbieterService.addNewAnbieter(Anbieter);
    }

    @DeleteMapping(path = "{Anbieter_Name}")
    public void deleteAnbieter(@PathVariable ("Anbieter_Name") String Anbieter_Name){
        AnbieterService.deleteAnbieter(Anbieter_Name);
    }

    @PutMapping(path = "{Anbieter_Name}")
    public void updateAnbieter(
            @PathVariable("Anbieter_Name") String Anbieter_Name){
        AnbieterService.updateAnbieter(Anbieter_Name);
    }
}
