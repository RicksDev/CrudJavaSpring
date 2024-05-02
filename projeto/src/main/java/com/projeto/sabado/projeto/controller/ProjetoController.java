package com.projeto.sabado.projeto.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
import com.projeto.sabado.projeto.exception.ProjetoNotFoundException;
import com.projeto.sabado.projeto.model.Projeto;
import com.projeto.sabado.projeto.service.IProjetoService;

 
@Controller
@RequestMapping("/projeto")
public class ProjetoController {
 
	@Autowired
	private IProjetoService service;
 
	@GetMapping("/")
	public String paginaInicial() {
		return "home";
	}
 
	@PostMapping("/salvar")
	public String salvarProjeto(@ModelAttribute Projeto projeto) {
		// , Model model
		System.out.println(projeto);
		// @ModelAttributte vincula as infromações do formulário a um objeto.
		service.salvarProjeto(projeto);
		// Salva novamente (redundante) retorna o id do nosso projeto
		// Long id = service.salvarProjeto(projeto).getId();
		// Mesagrmpara o User
		// String msg = "Salvo com o id : " + id + " com sucesso!";
		// Add msg in response
		// model.addAttribute(msg);
		return "buy";
	}
 
	@PostMapping("/atualizar")
	public String atualizarProjeto(@ModelAttribute Projeto projeto, RedirectAttributes attributes) {
		service.atualizarProjeto(projeto);
		Long id = projeto.getId();
		attributes.addAttribute("message", "projeto com id: " + id + " foi atualizado");
		return "redirect:list";
	}
 
	
	@GetMapping("/deletar")
	public String deletarProjeto(@RequestParam Long id, RedirectAttributes attributes) {
		try {
			service.deletarProjeto(id);
			attributes.addAttribute("message", "O projeto foi deletado, id: " + id);
		} catch (ProjetoNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
 
		return "redirect:list";
	}
 
	@GetMapping("/adicionar")
	public String adicionarProjeto() {
		return "buy";
	}
	
	@GetMapping("/contact")
	public String entrarProjeto() {
		return "contact";
	}
	
	@GetMapping("/login")
	public String entrarNoProjeto() {
		return "login";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrarProjeto() {
		return "signUp";
	}
	
	@GetMapping("/perfil")
	public String verPerfil() {
		return "profile";
	}
	
	@GetMapping("/editar")
	public String editarProjeto(Model model, RedirectAttributes attributes, @RequestParam Long id) {
		String page;
		try {
			Projeto projeto = service.buscarProjetoUnico(id);
			model.addAttribute("projeto", projeto);
			page = "upgrade";
		} catch (ProjetoNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("messages", e.getMessage());
			page = "redirect:list";
		}
		return page;
	}
 
	@GetMapping("/list")
	public String listarProjeto(@RequestParam(value = "message", required = false) String message, Model model) {
 
		// /user/lista? message=hello%world
		// Lista dos projetos
 
		List<Projeto> projetos = service.buscarTodosProjetos();
		model.addAttribute("lista", projetos);
		model.addAttribute("mensagem", message);
 
		return "list";
	}
}
 