package Aplicativos;

import PackageMicrosoft.Excel;
import PackageMicrosoft.PowerPoint;
import PackageMicrosoft.Word;
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
