package PackageLibreOffice;

import Aplicativos.EditorApresentacao;

public class Impress implements EditorApresentacao {

	@Override
	public void apresentar() {
		System.out.println("Estou apresentando slides no Impress");

	}

	@Override
	public void passarslide() {
		System.out.println("Estou passando slides no Impress");
	}

}
