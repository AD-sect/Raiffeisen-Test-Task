package ru.dmirtuk.raiffeisentesttask.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistic, Long> {
    Statistic findFirstByOrderByCreatedAtDesc();

    List<Statistic> findByUserId(Long id);

    boolean existsBy();
}
