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
public class CadastrarUsuarioController {
	
	@Autowired
	private UsuarioDao dao;
	
	@RequestMapping("/cadastro")
	public String usuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute(usuario);
		return "cadastrar";
	}

	@RequestMapping("/adicionaUsuario")
	public String adicionaUsuario(
			@ModelAttribute(value = "usuario") Usuario usuario,
			RedirectAttributes redirect, Model model) {
		String adiciona = dao.adiciona(usuario);
		if(adiciona.equals("usuarioAdicionado")){
			redirect.addFlashAttribute("mensagem",
					"Usuário cadastrado com sucesso!");
			return "redirect:/cadastro";
		}else{
			redirect.addFlashAttribute("mensagem",
					adiciona);
		}
		
		return "redirect:/cadastro";
	
	}

}
