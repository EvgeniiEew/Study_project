package by.home.kitchen.service.repository;

import by.home.kitchen.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishJpaRepository extends JpaRepository<Dish, Integer> {
}
