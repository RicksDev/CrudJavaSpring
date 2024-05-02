package com.projeto.sabado.projeto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Projeto {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String veiculo;
	private String cor;
	private String preco;	
	private String metPag;
	private String codPromo;
	
}
