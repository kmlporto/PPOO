package PackageMicrosoft;

import Aplicativos.EditorApresentacao;

public class PowerPoint implements EditorApresentacao {

	@Override
	public void apresentar() {
		System.out.println("Estou apresentando slides no PowerPoint");
	}

	@Override
	public void passarslide() {
		System.out.println("Estou passando slides no PowerPoint");
	}

}
