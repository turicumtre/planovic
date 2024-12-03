package ch.wiibeeri.planovic.services;

import ch.wiibeeri.planovic.datatypes.Entry;
import ch.wiibeeri.planovic.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepository;

    public Optional<Entry> getByID(String id){
        return entryRepository.findById(id);
    }

    public List<Entry> allOfYear(int year) {
        return entryRepository.allOfYear(year);
    }
}
