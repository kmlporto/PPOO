package models;

public class Arquivo {
	private String nome, path, data, hora, proprietario, email;
	private boolean autorizacaoImpressao, autorizacaoCopia;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isAutorizacaoImpressao() {
		return autorizacaoImpressao;
	}
	
	public void setAutorizacaoImpressao(boolean autorizacaoImpressao) {
		this.autorizacaoImpressao = autorizacaoImpressao;
	}
	
	public boolean isAutorizacaoCopia() {
		return autorizacaoCopia;
	}
	
	public void setAutorizacaoCopia(boolean autorizacaoCopia) {
		this.autorizacaoCopia = autorizacaoCopia;
	}
	
	@Override
	public String toString() {
		return "Arquivo\n nome: " + nome + "\n path: " + path + 
			"\n data: " + data +
			"\n hora: " + hora +
			"\n proprieratio: " + proprietario +
			"\n e-mail: " + email +
			"\n autorizacao Impressao: " + autorizacaoImpressao+
			"\n autorizacao Copia: " + autorizacaoCopia;
	}
	
	public void escrever() {
		System.out.println("escrevendo no arquivo " + nome);
	}
	
	public void ler() {
		System.out.println("lendo o arquivo " + nome);
	}

}
