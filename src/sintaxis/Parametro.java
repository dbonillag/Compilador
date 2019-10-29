package sintaxis;


import javafx.scene.control.TreeItem;
import lexico.Token;

public class Parametro {

	Token tipoDato;
	Token identificador;

	public Parametro(Token tipoDato, Token identificador) {
		super();
		this.tipoDato = tipoDato;
		this.identificador = identificador;
	}

	public Token getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(Token tipoDato) {
		this.tipoDato = tipoDato;
	}

	public Token getNombre() {
		return identificador;
	}

	public void setNombre(Token nombre) {
		this.identificador = nombre;
	}

	public TreeItem<String> getArbolVisual() {
		TreeItem<String> raiz = new TreeItem<>("Parametro");
		raiz.getChildren().add(new TreeItem<>("Identificador: " + identificador.getPalabra()));
		raiz.getChildren().add(new TreeItem<>("Tipo de dato: " + tipoDato.getPalabra()));

		return raiz;

	}
}
