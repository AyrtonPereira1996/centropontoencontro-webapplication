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
@Table(name = "dev_devolucaoinfantil")
public class DevolucaoInfantil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dev_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "dev_utenteid")
	private UtenteMenor utenteDevolucoes;
	
	@ManyToOne
	@JoinColumn(name = "dev_livroid")
	private LivroInfantil livroDevolucoes;
	
	@Column(name = "dev_data_registo")
	private LocalDateTime dataRegisto;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UtenteMenor getUtenteDevolucoes() {
		return utenteDevolucoes;
	}

	public void setUtenteDevolucoes(UtenteMenor utenteDevolucoes) {
		this.utenteDevolucoes = utenteDevolucoes;
	}

	public LivroInfantil getLivroDevolucoes() {
		return livroDevolucoes;
	}

	public void setLivroDevolucoes(LivroInfantil livroDevolucoes) {
		this.livroDevolucoes = livroDevolucoes;
	}

	public LocalDateTime getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(LocalDateTime dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

}
