package br.com.lsargus.finance.ports.service;

import br.com.lsargus.finance.data.IncomeBO;
import br.com.lsargus.finance.exceptions.RuleException;

import java.util.List;

public interface IncomeServicePort {
	
	List<IncomeBO> getAll();

	IncomeBO getIncome(Long id);

	IncomeBO addIncome(IncomeBO incomeBO) throws RuleException;

	IncomeBO updateIncome(Long id, IncomeBO incomeBO) throws RuleException;

	void deleteIncome(Long id);
}
