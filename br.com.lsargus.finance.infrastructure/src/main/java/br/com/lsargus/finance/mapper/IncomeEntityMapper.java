package br.com.lsargus.finance.mapper;

import br.com.lsargus.finance.data.IncomeBO;
import br.com.lsargus.finance.entity.Income;
import org.mapstruct.Mapper;

@Mapper
public interface IncomeEntityMapper {

    IncomeBO toBO(Income income);

    Income toEntity(IncomeBO incomeBO);

}
