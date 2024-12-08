package ch.wiibeeri.planovic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ch.wiibeeri.planovic.datatypes.db.Entry;
import ch.wiibeeri.planovic.datatypes.frontend.YearData;
import ch.wiibeeri.planovic.services.*;

@RestController
@RequestMapping("/api/cal")
public class CalController {
	@Autowired
    private CalService calService;

	@GetMapping("/year/{year}")
    public YearData year(@PathVariable int year) {
        return calService.allOfYear(year);
    }
}
