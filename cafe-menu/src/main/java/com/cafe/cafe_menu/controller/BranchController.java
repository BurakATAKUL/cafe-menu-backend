package com.cafe.cafe_menu.controller;

import com.cafe.cafe_menu.dto.BranchDto;
import com.cafe.cafe_menu.entity.Branch;
import com.cafe.cafe_menu.service.BranchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping("/add")
    public ResponseEntity<Branch> addBranch(@RequestBody BranchDto branchDto) {
        try {
            Branch branch = branchService.addBranch(branchDto);
            return new ResponseEntity<>(branch, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
