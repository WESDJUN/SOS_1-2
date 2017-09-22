package beans;

import javax.persistence.*;

@Entity
@Table(name = "servico")
public class Servico {

	@Id
	@GeneratedValue
	@Column(name = "ser_id")
	private int id;
	@Column(name = "ser_nome", length = 60, nullable = true)
	private String nome;
	@Column(name = "ser_preco", nullable = true)
	private float preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
