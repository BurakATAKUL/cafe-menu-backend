package com.cafe.cafe_menu.dto;

import com.cafe.cafe_menu.entity.Cafe;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchDto {
    private String name;
    private String location;
    private String contact;
    private Long cafe; //şubenin bağlı olacağı cafe Id si



    public BranchDto(String name, String location, Cafe cafe, String contact) {
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.cafe = cafe.getId();

    }
}
