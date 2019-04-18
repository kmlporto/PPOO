import Aplicativos.Aplicativo;
import gof.AplicativoFactory;
import gof.ArquivoBuilder;
import models.Arquivo;

public class Cliente {
	public static void main(String[] args) {
		AplicativoFactory.getFactory(Aplicativo.MICROSOFT).criarEditorApresentacao().apresentar();
		Arquivo arquivo = (new ArquivoBuilder("Curriculo Kamila","home" )).create();
		arquivo.escrever();
	}
}
