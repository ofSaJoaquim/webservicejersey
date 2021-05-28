package br.com.ofsajoaquim.webservicejersey.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ofsajoaquim.webservicejersey.domain.Imovel;
import br.com.ofsajoaquim.webservicejersey.resource.filter.AcessoRestrito;
import br.com.ofsajoaquim.webservicejersey.service.ImovelService;

@Path("imoveis")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ImovelResource {

    private final ImovelService imovelService = new ImovelService();

    @POST
    @AcessoRestrito
    public Response cadastrarImovel(Imovel imovel) {
        imovelService.cadastrarImovel(imovel);
        return Response.status(Status.CREATED)
                .entity(imovel)
                .build();
    }

    @GET
    public List<Imovel> getImoveis() {
        return imovelService.listarImoveis();
    }

    @GET
    @Path("{imovelId}")
    public Imovel getImovel(@PathParam("imovelId") long id) {
        return imovelService.obterImovel(id);
    }

    @PUT
    @AcessoRestrito
    @Path("{imovelId}")
    public void update(@PathParam("imovelId") long id, Imovel imovel) {
        imovelService.atualizarImovel(id, imovel);
    }

    @DELETE
    @AcessoRestrito
    @Path("{imovelId}")
    public void delete(@PathParam("imovelId") long id) {
        imovelService.descadastrarImovel(id);
    }

}