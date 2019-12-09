package br.edu.ifms.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@NamedQueries({
	@NamedQuery(name="Quarto.buscarTodos", query="select q from Quarto q"),
	
})

public class Quarto {

	private Long codigo;
	private Long numero;
	private Long capacidade;
	private Disponibilidade disponibilidade;
	private List<Comodidades> comodidades;
	private TipoQuarto tipoQuarto;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Long getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Long capacidade) {
		this.capacidade = capacidade;
	}
	
	@Enumerated(EnumType.STRING)
	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(Disponibilidade disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	@Enumerated(EnumType.STRING)
	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	
	@Cascade(org.hibernate.annotations.CascadeType.REMOVE)
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="quarto_comodidades"
				, joinColumns=@JoinColumn(name="codigo_quarto")
				, inverseJoinColumns=@JoinColumn(name="codigo_comodidades"))
	public List<Comodidades> getComodidades() {
		return comodidades;
	}
	public void setComodidades(List<Comodidades> comodidades) {
		this.comodidades = comodidades;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
