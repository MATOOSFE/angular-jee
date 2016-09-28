package com.matoosfe.angular.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prod_codigo")
	private Integer prodCodigo;

	@Column(name="prod_descripcion")
	private String prodDescripcion;

	@Column(name="prod_nombre")
	private String prodNombre;

	@Column(name="prod_precio")
	private BigDecimal prodPrecio;

	//bi-directional many-to-one association to TipoProducto
	@ManyToOne
	@JoinColumn(name="tippro_codigo")
	private TipoProducto tipoProducto;

	public Producto() {
	}

	public Integer getProdCodigo() {
		return this.prodCodigo;
	}

	public void setProdCodigo(Integer prodCodigo) {
		this.prodCodigo = prodCodigo;
	}

	public String getProdDescripcion() {
		return this.prodDescripcion;
	}

	public void setProdDescripcion(String prodDescripcion) {
		this.prodDescripcion = prodDescripcion;
	}

	public String getProdNombre() {
		return this.prodNombre;
	}

	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}

	public BigDecimal getProdPrecio() {
		return this.prodPrecio;
	}

	public void setProdPrecio(BigDecimal prodPrecio) {
		this.prodPrecio = prodPrecio;
	}

	public TipoProducto getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

}