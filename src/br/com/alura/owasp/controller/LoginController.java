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
	
	@RequestMapping("/loginUsuario")
	public String loginUsuario(Model model){
		Usuario usuario = new Usuario();
		model.addAttribute(usuario);
		return "logar";
	}
	
	@RequestMapping("/redirecionaUsuarioLogado")
	public String redirecionaUsuarioLogado(@ModelAttribute(value = "usuario") Usuario usuario,
			RedirectAttributes redirect, Model model){
		String mensagem = dao.procuraUsuario(usuario);
		if(mensagem.equals("usuarioExiste")){
			return "usuarioLogado";
		}else if (mensagem.equals("usuarioNaoExiste")){
			redirect.addFlashAttribute("mensagem",
					"Usuário não cadastrado!");
			return "redirect:/loginUsuario";
		}else{
			redirect.addFlashAttribute("mensagem",
					mensagem);
			return "redirect:/loginUsuario";
		}
		
	}

}
