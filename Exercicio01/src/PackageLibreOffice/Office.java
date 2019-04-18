package PackageLibreOffice;

import Aplicativos.EditorTexto;

public class Office implements EditorTexto {

	@Override
	public void escrever() {
		System.out.println("Estou escrevendo no Office");
	}

	@Override
	public void salvar() {
		System.out.println("Estou salvando o arquivo no Office");
	}

	@Override
	public void editar() {
		System.out.println("Estou editando o arquivo no Office");
	}

}
