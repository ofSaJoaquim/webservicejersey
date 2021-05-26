package br.com.ofsajoaquim.webservicejersey.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.ofsajoaquim.webservicejersey.domain.Produto;
import br.com.ofsajoaquim.webservicejersey.service.ProdutoService;

@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ProdutoResource {

   private ProdutoService service = new ProdutoService();

  
   @GET
   @Path("{produtoId}")
   public Produto getProduto(@PathParam("produtoId") long id) {
                return service.getProduto(id);
   }
   @POST 
   public Response save(Produto produto) {
	   produto = service.saveProduto(produto);
       return Response.status(Status.CREATED)
                    .entity(produto)
                    .build();
   }

   @PUT
   @Path("{produtoId}") 
   public void update(@PathParam("produtoId") long id, Produto produto) {
                produto.setId(id);
                service.updateProduto(produto);
   }

   @DELETE
   @Path("{produtoId}") 
   public void delete(@PathParam("produtoId") long id) {
                service.deleteProduto(id);
   }
   //busca com paramentor /produtos?name=teste
   //Exermplo busca com parametros simples
   /*
   @GET   
   public List<Produto> getProdutos(@QueryParam("name") String name) {
   if (name != null) {
         return service.getProdutoByName(name);
   }
   return service.getProdutos();
   }*/
   @GET
   public List<Produto> getProdutos(@BeanParam ProdutoFilterBean produtoFilter) {
         if ((produtoFilter.getOffset() >= 0) &&
            (produtoFilter.getLimit() > 0)) {
                return service.getProdutosByPagination(produtoFilter.getOffset(),
                produtoFilter.getLimit());
         }
         if (produtoFilter.getName() != null) {
                return service.getProdutoByName(produtoFilter.getName());
         }

         return service.getProdutos();
   }
}