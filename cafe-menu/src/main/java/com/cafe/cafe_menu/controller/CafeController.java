package com.cafe.cafe_menu.controller;

import com.cafe.cafe_menu.dto.CafeDto;
import com.cafe.cafe_menu.entity.Cafe;
import com.cafe.cafe_menu.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cafes")
@CrossOrigin(origins = "http://localhost:3000")
public class CafeController {

    private final CafeService cafeService;

    @Autowired
    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @PostMapping
    public ResponseEntity<Cafe> addCafe(@RequestBody CafeDto cafeDto) {
        try {
            Cafe cafe = cafeService.addCafe(cafeDto);
            return new ResponseEntity<>(cafe, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List <CafeDto>> getAllCafes() {
        List<CafeDto> cafes = cafeService.getAllCafes();
        System.out.println(cafes);
        return new ResponseEntity<>(cafes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CafeDto> updateCafe (@PathVariable("id") Long id,
                                               @RequestBody CafeDto updateCafe) {
        CafeDto cafeDto = cafeService.updateCafe(id, updateCafe);
        return new ResponseEntity<>(cafeDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCafe (@PathVariable("id") Long cafeId) {
        cafeService.deleteCafe(cafeId);
        return new ResponseEntity<>("Cafe Deleted Successfully: " + cafeId, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CafeDto> getCafeById(@PathVariable("id") Long cafeId) {
        CafeDto cafeDto = cafeService.getCafeById(cafeId);
        return new ResponseEntity<>(cafeDto, HttpStatus.OK);

    }

}
