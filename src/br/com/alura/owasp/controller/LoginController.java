package br.com.alura.owasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.owasp.dao.UsuarioDao;
import br.com.alura.owasp.model.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDao dao;

	@RequestMapping(value = "/cadastro")
	public String usuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute(usuario);
		return "cadastrar";
	}

	@RequestMapping(value = "/adicionaUsuario")
	public String adicionaUsuario(
			@ModelAttribute(value = "usuario") Usuario usuario,
			RedirectAttributes redirect, Model model) {
		String adiciona = dao.adiciona(usuario);
		if(adiciona.equals("usuarioJaExiste")){
			redirect.addFlashAttribute("mensagem",
					"Usuário já foi cadastrado!");
			return "redirect:/cadastro";
		}
		else if(adiciona.equals("usuarioAdicionado")){
			redirect.addFlashAttribute("mensagem",
					"Usuário cadastrado com sucesso!");
			return "redirect:/cadastro";
		}else{
			redirect.addFlashAttribute("mensagem",
					adiciona);
		}
		
		return "redirect:/cadastro";
	
	}
	
	@RequestMapping(value="/loginUsuario")
	public String loginUsuario(Model model){
		Usuario usuario = new Usuario();
		model.addAttribute(usuario);
		return "logar";
	}
	
	@RequestMapping(value="/redirecionaUsuarioLogado")
	public String redirecionaUsuarioLogado(@ModelAttribute(value = "usuario") Usuario usuario,
			RedirectAttributes redirect, Model model){
		Usuario retornaUsuario = dao.retornaUsuario(usuario);
		if(retornaUsuario.getEmail()!=null && retornaUsuario.getSenha()!=null){
			return "usuarioLogado";
		}else{
			redirect.addFlashAttribute("mensagem",
					"Usuário não encontrado");
			return "redirect:/loginUsuario";
		}
		
	}

}
