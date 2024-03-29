package sintaxis;

import java.util.ArrayList;

import javafx.scene.control.TreeItem;
import lexico.Token;
import semantica.Simbolo;
import semantica.TablaSimbolos;

public class DeclaracionDeVariable extends Sentencia {

	private Token tipoDato;
	private Token identificador;

	public DeclaracionDeVariable(Token tipoDato, Token identificador) {
		this.tipoDato = tipoDato;
		this.identificador = identificador;

	}

	public TreeItem<String> getArbolVisual() {
		TreeItem<String> raiz = new TreeItem<>("Declaracion");
		raiz.getChildren().add(new TreeItem<>("Identificador: " + identificador.getPalabra()));
		raiz.getChildren().add(new TreeItem<>("Tipo de dato: " + tipoDato.getPalabra()));

		return raiz;

	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos tablaSimbolos, ArrayList<String> erroresSemanticos, Simbolo ambito) {
		tablaSimbolos.guardarSimboloVariable(identificador.getPalabra(), tipoDato.getPalabra(), tipoDato.getFila(), tipoDato.getColumna(), ambito);

	}

	@Override
	public void analizarSemantica(TablaSimbolos tablaSimbolos, ArrayList<String> erroresSemanticos, Simbolo ambito) {
		
		
	}
	
	public String getJavaCode() {
		
		String jDeclaracion="";
		if (tipoDato.getPalabra().equals("Z")) {
			jDeclaracion+="int ";
		}else if (tipoDato.getPalabra().equals("R")) {
			jDeclaracion+="double ";
		}else if (tipoDato.getPalabra().equals("text")) {
			jDeclaracion+="String ";
		}else if (tipoDato.getPalabra().equals("bin")) {
			jDeclaracion+="boolean ";
		}
		 
		jDeclaracion+=identificador.getPalabra().replace("@", "$")+"; ";
		
		return jDeclaracion;
		
			
		
		
	}

}
