package br.com.ofsajoaquim.webservicejersey.service;

import java.util.List;

import br.com.ofsajoaquim.webservicejersey.dao.ProdutoDAO;
import br.com.ofsajoaquim.webservicejersey.domain.Produto;

public class ProdutoService {

    private ProdutoDAO dao = new ProdutoDAO();

    public List<Produto> getProdutos() {
    return dao.getAll();
    }

    public Produto getProduto(Long id) {
    return dao.getById(id);
    }

    public Produto saveProduto(Produto produto) {
    return dao.save(produto);
    }

    public Produto updateProduto(Produto produto) {
    return dao.update(produto);
    }

    public Produto deleteProduto(Long id) {
    return dao.delete(id);
    }

    public List<Produto> getProdutosByPagination(int firstResult, int maxResults) {
    return dao.getByPagination(firstResult, maxResults);
    }

    public List<Produto> getProdutoByName(String name) {
    return dao.getByName(name);
    }

}
