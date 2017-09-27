package br.com.alura.owasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.owasp.dao.UsuarioDao;
import br.com.alura.owasp.model.Usuario;

@Controller
public class RedirecionamentoURLController {
	
	@Autowired
	private UsuarioDao dao;
	
	@RequestMapping("/logar")
	public String logar(){
		return "logar";
	}

	@RequestMapping("/login")
	public String loginUsuario(Model model, RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("urlAfterLogin", "https://www.uol.com.br");
		Usuario usuario = new Usuario();
		model.addAttribute(usuario);
		return "redirect:/logar";
	}

}
