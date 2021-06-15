package com.minhasfinancas.service;

import java.util.List;

import com.minhasfinancas.model.entity.Lancamento;
import com.minhasfinancas.model.enums.StatusLancamento;


public interface LancamentoService {
	
	Lancamento salvar(Lancamento lancamento);
	Lancamento atualizar(Lancamento lancamento);
	List<Lancamento> buscar(Lancamento lancamentoFiltro);
	void deletar(Lancamento lancamento);
	void atualizarStatus(Lancamento lancamento, StatusLancamento status);
	void validar(Lancamento lancamento);
	
}
