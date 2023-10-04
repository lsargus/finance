package br.com.lsargus.finance.mapper;

import br.com.lsargus.finance.data.IncomeBO;
import br.com.lsargus.finance.dto.IncomeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface IncomeDTOMapper {

    IncomeDTO toDTO(IncomeBO incomeBO);

    IncomeBO toBO(IncomeDTO incomeDTO);

}
