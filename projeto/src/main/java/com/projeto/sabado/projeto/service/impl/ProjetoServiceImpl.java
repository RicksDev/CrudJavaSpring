package com.projeto.sabado.projeto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.sabado.projeto.model.Projeto;
import com.projeto.sabado.projeto.repo.ProjetoRepository;
import com.projeto.sabado.projeto.service.IProjetoService;

import com.projeto.sabado.projeto.exception.ProjetoNotFoundException;

@Service
public class ProjetoServiceImpl implements IProjetoService {
	@Autowired
	private ProjetoRepository repo;
	@Override
	public Projeto salvarProjeto(Projeto projeto) {
		return repo.save(projeto);
	}
	@Override
	public List<Projeto> buscarTodosProjetos() {	
		return repo.findAll();
	}
 
	@Override
	public Projeto buscarProjetoUnico(Long id) {
		Optional<Projeto> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new ProjetoNotFoundException("O ID: " + id + " não encontrado");
		}
	}
	@Override
	public void deletarProjeto(Long id) {
		repo.delete(buscarProjetoUnico(id));
	}
	@Override
	public void atualizarProjeto(Projeto projeto) {
		repo.save(projeto);
	}
}