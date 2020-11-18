package model.bean;

public class Filme {
	private int id_filme;
	private String titulo;
	private int tempo;
	private boolean imagem3d;
	private boolean dublado;
	private String sinopse;
	private String categoria;

	public int getIdFilme() {
		return id_filme;
	}

	public void setIdFilme(int id_filme) {
		this.id_filme = id_filme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public boolean isImagem3d() {
		return imagem3d;
	}

	public void setImagem3d(boolean imagem3d) {
		this.imagem3d = imagem3d;
	}

	public boolean isDublado() {
		return dublado;
	}

	public void setDublado(boolean dublado) {
		this.dublado = dublado;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}