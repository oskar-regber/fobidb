package org.fobidb.fortbildungen;

import org.fobidb.fortbildungen.Fortbildung;
import org.fobidb.fortbildungen.FortbildungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FortbildungService {

    private final FortbildungRepository fortbildungRepository;

    @Autowired
    public FortbildungService(FortbildungRepository fortbildungRepository) {
        this.fortbildungRepository = fortbildungRepository;
    }

    public List<Fortbildung> getFortbildungen() {
        return fortbildungRepository.findAll();
    }

    public void addNewFortbildung(Fortbildung fortbildung) {
        Optional<Fortbildung> fortbildungOptional = fortbildungRepository.findByFobid_ID(fortbildung.getFortbildung_ID());
        if (fortbildungOptional.isPresent()) {
            throw new IllegalStateException("Fortbildung already exists");
        }
        fortbildungRepository.save(fortbildung);
    }

    public void deleteFortbildung(Long FortbildungId) {
        boolean exists = fortbildungRepository.existsById(FortbildungId);
        if (!exists) {
            throw new IllegalStateException("Fortbildung with Id "+ FortbildungId + " does not exist");
        }
        fortbildungRepository.deleteById(FortbildungId);
    }

//    public List<Fortbildung> getFortbildung() {
//    }
}