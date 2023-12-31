package com.example.budget.controller;




import com.example.budget.saving.Saving;
import com.example.budget.saving.SavingResponseDTO;
import com.example.budget.saving.SavingRepository;
import com.example.budget.saving.SavingRequestDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("savings")
public class ControllerSaving {

    @Autowired
    private SavingRepository repository;
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveSaving(@RequestBody SavingRequestDTO data){
        
        Saving savingData = new Saving(data);
        repository.save(savingData);
        return;
        
        
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    
    @GetMapping
    public List<SavingResponseDTO> getAll(){
        
        List<SavingResponseDTO> savingList = repository.findAll().stream().map(SavingResponseDTO::new).toList();
        return savingList;

    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> deleteSaving(@PathVariable long id){
        
        return repository.findById(id)
           .map(record -> {
               repository.deleteById(id);
               return ResponseEntity.ok().build();
           }).orElse(ResponseEntity.notFound().build());
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    
    @PutMapping(value="/{id}")
public ResponseEntity update(@PathVariable("id") long id,
                                      @RequestBody Saving savings) {
   return repository.findById(id)
           .map(record -> {
               record.setMonth(savings.getMonth());
               record.setEconomy(savings.getEconomy());
               record.setImage(savings.getImage());
               Saving updated = repository.save(record);
               return ResponseEntity.ok().body(updated);
           }).orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    
    @GetMapping(path = {"/{id}"})
public ResponseEntity findById(@PathVariable long id){
   return repository.findById(id)
           .map(record -> ResponseEntity.ok().body(record))
           .orElse(ResponseEntity.notFound().build());

    }

}
