import Aplicativos.Aplicativo;
import Aplicativos.AplicativoFactory;
import Arquivo.Arquivo;
import Arquivo.ArquivoBuilder;

public class Cliente {
	public static void main(String[] args) {
		AplicativoFactory.getFactory(Aplicativo.MICROSOFT).criarEditorApresentacao().apresentar();
		Arquivo arquivo = (new ArquivoBuilder("Curriculo Kamila","home" )).create();
		arquivo.escrever();
	}
}
