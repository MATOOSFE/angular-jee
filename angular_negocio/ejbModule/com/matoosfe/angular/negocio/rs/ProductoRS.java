package com.matoosfe.angular.negocio.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.matoosfe.angular.modelo.Producto;
import com.matoosfe.angular.negocio.ProductoFacade;

@Stateless
@LocalBean
@Path("/productos")
public class ProductoRS {

	@EJB
	private ProductoFacade adminProducto;

	@POST
	@Consumes("application/json")
	public Producto create(Producto producto) {
		Producto productoRec = null;
		try {
			productoRec = adminProducto.guardar(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productoRec;
	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public Response update(Producto producto) {
		Response r = null;
		try {
			adminProducto.actualizar(producto);
			r = Response.ok("OK").build();
		} catch (Exception e) {
			r = Response.ok("error" + e.getMessage()).build();
		}
		return r;
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	@Produces("text/plain")
	public Response deleteById(@PathParam("id") int id) {
		Response r = null;
		try {
			adminProducto.eliminar(id);
			r = Response.ok("OK").build();
		} catch (Exception e) {
			r = Response.ok("error" + e.getMessage()).build();
		}
		return r;
	}

	@GET
	@Produces("application/json")
	public List<Producto> consultarTodos(
			@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		List<Producto> productos = new ArrayList<Producto>();
		try {
			productos = adminProducto.consultarProductos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}

}
