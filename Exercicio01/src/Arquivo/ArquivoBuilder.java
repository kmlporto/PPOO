package Arquivo;

import gof.Builder;

public class ArquivoBuilder implements Builder<Arquivo>{
	private String nome, path, data, hora, proprietario, email;
	private boolean autorizacaoImpressao, autorizacaoCopia;

	public ArquivoBuilder(String nome, String path) {
		this.nome=nome;
		this.path=path;
		this.autorizacaoCopia=false;
		this.autorizacaoImpressao=false;
	}
	
	public void nome(String nome) {
		this.nome = nome;
	}

	public void path(String path) {
		this.path = path;
	}

	public void data(String data) {
		this.data = data;
	}

	public void hora(String hora) {
		this.hora = hora;
	}

	public void proprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public void email(String email) {
		this.email = email;
	}

	public void autorizacaoImpressao(boolean autorizacaoImpressao) {
		this.autorizacaoImpressao = autorizacaoImpressao;
	}

	public void autorizacaoCopia(boolean autorizacaoCopia) {
		this.autorizacaoCopia = autorizacaoCopia;
	}

	@Override
	public Arquivo create() {
		Arquivo arquivo = new Arquivo();
		arquivo.setNome(this.nome);
		arquivo.setPath(this.path);
		arquivo.setEmail(this.email);
		arquivo.setData(this.data);
		arquivo.setHora(this.hora);
		arquivo.setProprietario(this.proprietario);
		arquivo.setAutorizacaoCopia(this.autorizacaoCopia);
		arquivo.setAutorizacaoImpressao(this.autorizacaoImpressao);
		return arquivo;
	}

}
