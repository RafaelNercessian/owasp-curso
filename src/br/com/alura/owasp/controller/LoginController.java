package br.com.alura.owasp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.owasp.model.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("/cadastrar")
	public String cadastro(Model model){
		model.addAttribute("usuario", new Usuario());
		return "cadastro";
}
		
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public void cadastro(@ModelAttribute("usuario")Usuario usuario, ModelMap model){
		System.out.println(usuario.getEmail());
	}

}
