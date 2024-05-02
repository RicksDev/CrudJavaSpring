package com.projeto.sabado.projeto.service;

import java.util.List;

import com.projeto.sabado.projeto.model.Projeto;

public interface IProjetoService {
	 
	public Projeto salvarProjeto(Projeto projeto);
	public List<Projeto> buscarTodosProjetos();
	public Projeto buscarProjetoUnico(Long id);
	public void deletarProjeto(Long id);
	public void atualizarProjeto(Projeto projeto);
}