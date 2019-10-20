package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Daos.ProdutoDAO;
import Models.Produto;

@Controller
public class ProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("/produtos/form")
	public String form() {
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String grava(Produto produto) {
		System.out.println(produto);
		produtoDao.gravar(produto);
		return "produtos/ok";
	}

}
