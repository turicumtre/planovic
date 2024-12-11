package ch.wiibeeri.planovic.controllers;

import ch.wiibeeri.planovic.datatypes.db.Entry;
import ch.wiibeeri.planovic.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entry")
public class EntryController {
    @Autowired
    private EntryService entryService;

    @GetMapping("/allOfYear/{year}")
    public List<Entry> allOfYear(@PathVariable int year) {
        return entryService.allOfYear(year);
    }

    @PostMapping("/create")
    public Entry create(@RequestBody Entry entry) {
        return entryService.insert(entry);
    }

    @GetMapping("/{id}")
    public Entry getEntryByID(@PathVariable String id) {
        return entryService.getByID(id).orElse(null);
    }
}
