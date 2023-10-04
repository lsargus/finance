package br.com.lsargus.finance.adapter;

import br.com.lsargus.finance.data.IncomeBO;
import br.com.lsargus.finance.entity.Income;
import br.com.lsargus.finance.mapper.IncomeEntityMapper;
import br.com.lsargus.finance.ports.presistence.IncomePersistencePort;
import br.com.lsargus.finance.repository.IncomeRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IncomeJpaAdapter implements IncomePersistencePort {

    private final IncomeRepository incomeRepository;

    private static final IncomeEntityMapper mapper = Mappers.getMapper(IncomeEntityMapper.class);

    public IncomeJpaAdapter(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public List<IncomeBO> getIncome() {
        List<Income> incomeList = incomeRepository.findAll();

        return incomeList.stream().map(mapper::toBO).toList();
    }

    @Override
    public IncomeBO getIncome(Long id) {
        return  incomeRepository.findById(id).map(mapper::toBO).orElse(new IncomeBO());
    }

    @Override
    public IncomeBO saveIncome(IncomeBO incomeBO) {
        Income income = mapper.toEntity(incomeBO);
        income = incomeRepository.save(income);

        return mapper.toBO(income);
    }

    @Override
    public List<IncomeBO> getIncomeByYearAndMonthAndDescription(Integer year, Integer month, String description) {
        List<IncomeBO> incomeBOList = new ArrayList<>();

        List<Income> incomeList = incomeRepository.findIncomeByYearAndMonthAndDescription(year, month, description);

        if (incomeList != null && !incomeList.isEmpty())
            incomeBOList = incomeList.stream().map(mapper::toBO).toList();

        return incomeBOList;
    }

    @Override
    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
