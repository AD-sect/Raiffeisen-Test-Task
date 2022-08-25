package ru.dmirtuk.raiffeisentesttask.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmirtuk.raiffeisentesttask.models.Statistic;

public interface StatisticsRepository extends JpaRepository<Statistic, Long> {
}
