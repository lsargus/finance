package br.com.lsargus.finance.repository;

import br.com.lsargus.finance.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    @Query(value = "SELECT r FROM FI001 r WHERE r.year = ?1 AND r.month = ?2 AND r.description like ?3 ")
    List<Income> findIncomeByYearAndMonthAndDescription(Integer year, Integer month, String description);
}
