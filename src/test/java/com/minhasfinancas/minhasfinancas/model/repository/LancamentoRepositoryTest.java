package com.minhasfinancas.minhasfinancas.model.repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.minhasfinancas.model.entity.Lancamento;
import com.minhasfinancas.model.enums.StatusLancamento;
import com.minhasfinancas.model.enums.TipoLancamento;
import com.minhasfinancas.model.repository.LancamentoRepository;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LancamentoRepositoryTest {
	
	@Autowired
	LancamentoRepository repository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void deveSalvarUmLancamento() {
		
		//Cenário
		Lancamento lancamento = Lancamento.builder().ano(2021)
												    .mes(6)
												    .descricao("Lançamento Teste")
												    .valor(BigDecimal.valueOf(10))
												    .tipo(TipoLancamento.RECEITA)
												    .status(StatusLancamento.PENDENTE)
												    .dataCadastro(LocalDate.now())
												    .build();
		//Ação
		lancamento = repository.save(lancamento);
		
		//Verificação
		Assertions.assertThat(lancamento.getId()).isNotNull();
	}
	
}
