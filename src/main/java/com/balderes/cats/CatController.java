package com.balderes.cats;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/cats")
@RestController
public class CatController {

    private final CatRepository catRepository;

    @PostMapping("/add")
    public void addCat(@RequestBody Cat cat) {
        log.info("New row: {}", catRepository.save(cat));
    }

    @GetMapping("/all")
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cat getCat(@PathVariable Integer id) {
        return catRepository.findById(id).orElseThrow();
    }
    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Integer id) {
        catRepository.deleteById(id);
    }

    @PutMapping("/add")
    public String changeCat(@RequestBody Cat cat) {
        if (!catRepository.existsById(cat.getId())) {
            return "No such row";
        }
        return catRepository.save(cat).toString();
    }
}
