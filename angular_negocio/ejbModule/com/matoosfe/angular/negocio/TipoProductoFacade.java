package com.matoosfe.angular.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.matoosfe.angular.modelo.TipoProducto;

@Stateless
@LocalBean
public class TipoProductoFacade {

	@PersistenceContext(unitName = "angularPU")
	private EntityManager em;

	/**
	 * Método para consultar tipo productos
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<TipoProducto> consultarTipoProductos() throws Exception {
		TypedQuery<TipoProducto> conPro = em.createQuery(
				"Select tipPro from TipoProducto tipPro", TipoProducto.class);
		return conPro.getResultList();
	}
}
