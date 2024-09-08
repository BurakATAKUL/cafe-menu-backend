package com.cafe.cafe_menu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CafeDto {
    private String name;
    private String address;
    private List<BranchDto> branchDto;

    public CafeDto(String name, String address) {
    }

}
