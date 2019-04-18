package gof;

import Aplicativos.Aplicativo;
import PackageLibreOffice.LibreOfficeFactory;
import PackageMicrosoft.MicrosoftFactory;

public class AplicativoFactory {
	public static Factory getFactory(Aplicativo aplicativo){
		if (aplicativo == Aplicativo.MICROSOFT)
			return new MicrosoftFactory();
		else if (aplicativo == Aplicativo.LIBREOFFICE)
			return new LibreOfficeFactory();
		else
			return null;
	}
}
