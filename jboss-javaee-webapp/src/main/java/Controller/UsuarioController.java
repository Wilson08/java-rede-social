package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Daos.UsuarioDAO;
import Models.Usuario;



@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/usuario/form", method=RequestMethod.GET)
	public String form() {
		return "usuario/form";
	}
	
	@RequestMapping(value="/usuario",method=RequestMethod.POST)
	public String grava(Usuario usuario) {
	
		usuarioDAO.gravar(usuario);
		return "post/form";
	}

}
