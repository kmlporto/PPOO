package PackageMicrosoft;

import Aplicativos.EditorApresentacao;
import Aplicativos.EditorPlanilha;
import Aplicativos.EditorTexto;
import gof.Factory;

public class MicrosoftFactory implements Factory {

	@Override
	public EditorPlanilha criarEditorPlanilha() {
		return new Excel();
	}

	@Override
	public EditorTexto criarEditorTexto() {
		return new Word();
	}

	@Override
	public EditorApresentacao criarEditorApresentacao() {
		return new PowerPoint();
	}

}
