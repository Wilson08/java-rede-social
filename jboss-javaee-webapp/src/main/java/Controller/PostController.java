package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Daos.PostDAO;
import Models.Post;
import Models.Usuario;



@Controller
public class PostController {
	
	@Autowired
	private PostDAO postDAO;
	
	@RequestMapping(value="post/form", method=RequestMethod.GET)
	public String form() {
		return "post/form";
	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	public String grava(Post post) {
		Usuario user = new Usuario();
		
		user.setId(1);
		user.setEmail("daniel");
		user.setName("daniel");
		user.setSenha("daniel");
		post.setUser(user);
		postDAO.gravar(post);
		return "post/ok";
	}

}
