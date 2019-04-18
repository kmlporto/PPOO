package PackageMicrosoft;

import Aplicativos.EditorTexto;

public class Word implements EditorTexto {

	@Override
	public void escrever() {
		System.out.println("Estou escrevendo no Word");
	}

	@Override
	public void salvar() {
		System.out.println("Estou salvando o arquivo no Word");
	}

	@Override
	public void editar() {
		System.out.println("Estou editando o arquivo no Word");
	}

}
