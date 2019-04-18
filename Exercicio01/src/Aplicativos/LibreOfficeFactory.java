package Aplicativos;

import PackageLibreOffice.Calc;
import PackageLibreOffice.Impress;
import PackageLibreOffice.Office;
import gof.Factory;

public class LibreOfficeFactory implements Factory {

	@Override
	public EditorPlanilha criarEditorPlanilha() {
		return new Calc();
	}

	@Override
	public EditorTexto criarEditorTexto() {
		return new Office();
	}

	@Override
	public EditorApresentacao criarEditorApresentacao() {
		return new Impress();
	}

}
