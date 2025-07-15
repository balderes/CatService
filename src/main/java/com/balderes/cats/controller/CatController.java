package com.balderes.cats.controller;

import com.balderes.cats.dto.CatDto;
import com.balderes.cats.entity.Cat;
import com.balderes.cats.repository.CatRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Main methods")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/cats")
@RestController
public class CatController {

    private final CatRepository catRepository;

    @Operation( summary = "Добавляем котэ в базу",
            description = "Принимаем ДТО кота и сохраняем в базу")
    @PostMapping("/add")
    public void addCat(@RequestBody CatDto catDto) {
        log.info(
                "New row: {}", catRepository.save(
                        Cat.builder()
                                .name(catDto.getName())
                                .weight(catDto.getWeight())
                                .age(catDto.getAge())
                                .build())
        );
    }

    @GetMapping("/all")
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cat getCat(@PathVariable Integer id) {
        return catRepository.findById(id).orElse(new Cat());
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
