package ch.wiibeeri.planovic.controllers;

import ch.wiibeeri.planovic.datatypes.Entry;
import ch.wiibeeri.planovic.services.EntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public Entry getEntryByID(@PathVariable String id) {
        System.out.println(":)))");
        return entryService.getByID(id).orElse(null);
    }
}
