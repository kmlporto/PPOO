package PackageMicrosoft;

import Aplicativos.EditorPlanilha;

public class Excel implements EditorPlanilha {

	@Override
	public void calcular() {
		System.out.println("Estou calculando com o Excel");
	}

}
