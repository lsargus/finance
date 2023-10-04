package br.com.lsargus.finance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "FI001")
@NoArgsConstructor
@AllArgsConstructor
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FI001_ID")
	private Long id;
	@Column(name = "FI001_DS_RECEITA")
	private String description;
	@Column(name = "FI001_VL_RECEITA")
	private BigDecimal value;
	@Column(name = "FI001_NR_ANO")
	private Integer year;
	@Column(name = "FI001_NR_MES")
	private Integer month;
	@Column(name = "FI001_DT_RECEITA")
	private LocalDateTime date;
}
