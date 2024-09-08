package com.cafe.cafe_menu.repository;

import com.cafe.cafe_menu.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
