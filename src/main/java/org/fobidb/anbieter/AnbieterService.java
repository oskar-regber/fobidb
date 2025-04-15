package org.fobidb.anbieter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


// Service LAYER *******************************************************

@Service
public class  AnbieterService {

    private final AnbieterRepository AnbieterRepository;

    @Autowired
    public AnbieterService(AnbieterRepository AnbieterRepository) {
        this.AnbieterRepository = AnbieterRepository;
    }

    public List<Anbieter> getAnbieter() {
        return AnbieterRepository.findAll();
    }

    public void addNewAnbieter(Anbieter Anbieter) {
        Optional<Anbieter> AnbieterOptional = AnbieterRepository.findByName(Anbieter.getAnbieter_Name());
        if (AnbieterOptional.isPresent()) {
            throw new IllegalStateException("Anbieter Name already in use");
        }
        AnbieterRepository.save(Anbieter);
    }

    public void deleteAnbieter(String Anbieter_Name) {
        boolean exists = AnbieterRepository.existsById(Anbieter_Name);
        if (!exists) {
            throw new IllegalStateException("Anbieter with Id "+ Anbieter_Name + " does not exist");
        }
        AnbieterRepository.deleteById(Anbieter_Name);
    }

    @Transactional
    public void updateAnbieter(String Anbieter_Name) {
        Anbieter Anbieter = AnbieterRepository.findById(Anbieter_Name)
                .orElseThrow(() -> new IllegalStateException("Anbieter with Id " + Anbieter_Name + " does not exist"));

        if (Anbieter_Name != null && Anbieter_Name.length() > 0 && !Objects.equals(Anbieter.getAnbieter_Name(), Anbieter_Name)) {
            Anbieter.setAnbieter_Name(Anbieter_Name);
        }
    }
}
