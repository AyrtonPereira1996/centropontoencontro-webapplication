package mz.com.centropontoencontro.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dev_devolucao")
public class Devolucao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dev_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "dev_utenteid")
	private Utente utenteDevolucoes;
	
	@ManyToOne
	@JoinColumn(name = "dev_livroid")
	private Livro livroDevolucoes;
	
	@Column(name="dev_data_registo")
	private LocalDateTime dataRegisto;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Utente getUtenteDevolucoes() {
		return utenteDevolucoes;
	}

	public void setUtenteDevolucoes(Utente utenteDevolucoes) {
		this.utenteDevolucoes = utenteDevolucoes;
	}

	public Livro getLivroDevolucoes() {
		return livroDevolucoes;
	}

	public void setLivroDevolucoes(Livro livroDevolucoes) {
		this.livroDevolucoes = livroDevolucoes;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}
}
