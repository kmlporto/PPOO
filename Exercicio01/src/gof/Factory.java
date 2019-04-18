package gof;

import Aplicativos.EditorApresentacao;
import Aplicativos.EditorPlanilha;
import Aplicativos.EditorTexto;

public interface Factory {
	public EditorPlanilha criarEditorPlanilha();
	public EditorTexto criarEditorTexto();
	public EditorApresentacao criarEditorApresentacao();
}
