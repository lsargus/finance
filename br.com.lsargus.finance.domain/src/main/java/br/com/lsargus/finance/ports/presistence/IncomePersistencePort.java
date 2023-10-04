package br.com.lsargus.finance.ports.presistence;

import br.com.lsargus.finance.data.IncomeBO;

import java.util.List;

public interface IncomePersistencePort {

    List<IncomeBO> getIncome();

    IncomeBO getIncome(Long id);

    IncomeBO saveIncome(IncomeBO incomeBO);

    List<IncomeBO> getIncomeByYearAndMonthAndDescription(Integer year, Integer month, String description);

    void deleteIncome(Long id);
}
