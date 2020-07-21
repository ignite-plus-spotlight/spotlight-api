package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.Nominations;
import spring.spot.Exception.NominationsException;
import spring.spot.Repository.NominationsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NominationsService {

    @Autowired
    private NominationsRepository nominationsRepository;

    public NominationsService(NominationsRepository nominationsRepository) {
        this.nominationsRepository =nominationsRepository;
    }


    public Nominations createNominations(Nominations nominee) {
        return nominationsRepository.save(nominee);
    }


    public List<Nominations> getAllNominations() {
        return nominationsRepository.findAll();
    }

    public Nominations getNominationsById(int id) {
        Optional<Nominations> optionalNominations = nominationsRepository.findById(id);
        if (!optionalNominations.isPresent())
            throw new NominationsException("No such employee found");
        return nominationsRepository.findById(id).get();
    }


    public Nominations updateNominationsById(int id, Nominations nominee) {
        Optional<Nominations> optionalNominations = nominationsRepository.findById(id);
        if (!optionalNominations.isPresent())
            throw new NominationsException("No such nominee found");
        nominee.setNominee(id);
        return nominationsRepository.save(nominee);
    }

    public void deleteNominationsById(int id) {
        Optional<Nominations> optionalUser = nominationsRepository.findById(id);
        if (!optionalUser.isPresent())
            throw new NominationsException("No such nominee found");
        nominationsRepository.deleteById(id);
    }
}
