package com.sdnath.JournalApp.controller;


import com.sdnath.JournalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long,JournalEntry> journalEntries= new HashMap<>();


    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());

    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myentry){
        journalEntries.put(myentry.getId(),myentry);
        return true;

    }

    @GetMapping("/Id/{id}")
    public JournalEntry getJournalbyid(@PathVariable Long id) {
        return journalEntries.get(id);
    }

    @DeleteMapping("/Id/{id}")
    public JournalEntry deleteEntry(@PathVariable Long id) {
        return journalEntries.remove(id);
    }

//    update Byid:

    @PutMapping("/Id/{id}")
    public JournalEntry update(@PathVariable long id, @RequestBody JournalEntry myentry) {
        myentry.setId(id); // enforce consistency
        return journalEntries.put(id, myentry);
    }



}



