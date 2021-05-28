package br.com.ofsajoaquim.webservicejersey.service;

import java.util.List;

import br.com.ofsajoaquim.webservicejersey.dao.ImovelDAO;
import br.com.ofsajoaquim.webservicejersey.domain.Imovel;

public class ImovelService {

    private final ImovelDAO imovelDAO = new ImovelDAO();

    public void cadastrarImovel(Imovel imovel) {
        imovelDAO.salvarImovel(imovel);
    }

    public void descadastrarImovel(long id) {
        imovelDAO.excluirImovel(id);
    }

    public void atualizarImovel(long id, Imovel imovel) {
        imovelDAO.atualizarImovel(id, imovel);
    }

    public List<Imovel> listarImoveis() {
        return imovelDAO.selecionarImoveis();
    }

    public Imovel obterImovel(long id) { return imovelDAO.recuperarImovelPorId(id); }

}
