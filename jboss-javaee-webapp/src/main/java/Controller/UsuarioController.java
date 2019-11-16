package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Daos.UsuarioDAO;
import Models.Usuario;



@Controller
public class UsuarioController {
	public static Usuario userLogged;
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/usuario/form", method=RequestMethod.GET)
	public String form() {
		return "usuario/form";
	}
	
	@RequestMapping(value="/usuario",method=RequestMethod.POST)
	public String grava(Usuario usuario) {
		this.userLogged = usuario;
		usuarioDAO.gravar(usuario);
		return "post/form";
	}
	@RequestMapping(value="usuario/login",method=RequestMethod.GET)
	public String formU() {
		return "usuario/login";
	}
	
	@RequestMapping(value="usuario/login",method=RequestMethod.POST)
	public String login(Usuario usuario) {
		this.userLogged = usuarioDAO.logar(usuario);
		if (this.userLogged != null) {
			return "post/form";	
		} else {
			return "usuario/login";
		}
		
	}

}
