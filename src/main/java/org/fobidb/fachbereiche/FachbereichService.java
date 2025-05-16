package org.fobidb.fachbereiche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


// Service LAYER *******************************************************

@Service
public class  FachbereichService {

    private final FachbereichRepository FachbereichRepository;

    @Autowired
    public FachbereichService(FachbereichRepository FachbereichRepository) {
        this.FachbereichRepository = FachbereichRepository;
    }

    public List<Fachbereich> getFachbereich() {
        return FachbereichRepository.findAll();
    }

    public void addNewFachbereich(Fachbereich Fachbereich) {
        Optional<Fachbereich> FachbereichOptional = FachbereichRepository.findByName(Fachbereich.getFachbereich_Name());
        if (FachbereichOptional.isPresent()) {
            throw new IllegalStateException("Fachbereich Name already in use");
        }
        FachbereichRepository.save(Fachbereich);
    }

    public void deleteFachbereich(String Fachbereich_Name) {
        boolean exists = FachbereichRepository.existsById(Fachbereich_Name);
        if (!exists) {
            throw new IllegalStateException("Fachbereich with Id "+ Fachbereich_Name + " does not exist");
        }
        FachbereichRepository.deleteById(Fachbereich_Name);
    }

    @Transactional
    public void updateFachbereich(String Fachbereich_Name) {
        Fachbereich Fachbereich = FachbereichRepository.findById(Fachbereich_Name)
                .orElseThrow(() -> new IllegalStateException("Fachbereich with Id " + Fachbereich_Name + " does not exist"));

        if (Fachbereich_Name != null && Fachbereich_Name.length() > 0 && !Objects.equals(Fachbereich.getFachbereich_Name(), Fachbereich_Name)) {
            Fachbereich.setFachbereich_Name(Fachbereich_Name);
        }
    }
}
