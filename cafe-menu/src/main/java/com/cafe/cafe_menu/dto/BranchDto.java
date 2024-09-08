package com.cafe.cafe_menu.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchDto {
    private String name;
    private String location;
    private String contact;
    private Long cafeId; //şubenin bağlı olacağı cafe Id si



}
