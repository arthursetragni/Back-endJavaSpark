package model;

public class Denuncia {
	private int id;
	private String localizacao;
	private String descricao;
	private String categoria;
	private String data;
	private int idUsuario;
	
	public Denuncia(int id, String localizacao, String descricao, String categoria, String data, int idUsuario) {
		this.id = id;
		this.localizacao = localizacao;
		this.descricao = descricao;
		this.categoria = categoria;
		this.data = data;
		this.idUsuario = idUsuario;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getLocalizacao() {
		return this.localizacao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public String getData() {
		return this.data;
	}
	
	public int getIdUsuario() {
		return this.idUsuario;
	}
	
}
