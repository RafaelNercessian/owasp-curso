package br.com.alura.owasp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.alura.owasp.model.Usuario;

@Controller
public class LoginController {

	@RequestMapping(value = "/usuario")
	public String usuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute(usuario);
		return "cadastrar";
	}

	@RequestMapping(value = "/adicionaUsuario", method = RequestMethod.POST)
	public String adicionaUsuario(
			@ModelAttribute(value = "usuario") Usuario usuario,
			BindingResult result, RedirectAttributes redirect, Model model) {
		if (result.hasErrors()) {
			return "adicionarProduto";
		}
		System.out.println(usuario.getEmail());
		redirect.addFlashAttribute("mensagem",
				"Produto adicionado com sucesso!");
		return "redirect:/usuario";
	}

}
