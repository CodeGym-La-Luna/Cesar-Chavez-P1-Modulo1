import java.util.ArrayList;
import java.util.List;

public class Cipher {

	private static String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,!?";

	public Cipher() {
	}

	// Metodo para convertir el alfabdeo de String a List
	public List<Character> alfabetoLista(String alfabeto) {
		List<Character> listaAlfabeto = new ArrayList<>();
		for (int i = 0; i < alfabeto.length(); i++) {
			listaAlfabeto.add(alfabeto.charAt(i));
		}
		return listaAlfabeto;
	}
	
	
	// Metodo para cifrar texto
	public String cifrarTexto(String texto, int clave) {
		String textoCif = "";
		List<Character> listaAlfabeto = alfabetoLista(alfabeto);
		for (int i = 0; i < texto.length(); i++) {
			for (int j = 0; j < listaAlfabeto.size(); j++) {
				if (listaAlfabeto.contains(texto.charAt(i)) && texto.charAt(i) == listaAlfabeto.get(j)) {
					if (j + clave >= listaAlfabeto.size()) {
						textoCif += listaAlfabeto.get((j + clave) % listaAlfabeto.size());
						break;
					} else {
						textoCif += listaAlfabeto.get(j + clave);
						break;
					}
				} else if (!listaAlfabeto.contains(texto.charAt(i))) {
					textoCif += texto.charAt(i);
					break;					
				}
			}
		}
		return textoCif;
	}

	// Metodo para descifrar texto
	public String descifrarTexto(String texto, int clave) {
		String alfabetoInv = "";
		String textoDescifrado = "";

		for (int i = 0; i < alfabeto.length(); i++) {
			alfabetoInv += alfabeto.charAt(alfabeto.length() - 1 - i);
		}

		List<Character> listaAlfabeto = alfabetoLista(alfabetoInv);

		for (int i = 0; i < texto.length(); i++) {
			for (int j = 0; j < listaAlfabeto.size(); j++) {
				if (listaAlfabeto.contains(texto.charAt(i)) && texto.charAt(i) == listaAlfabeto.get(j)) {
					if (j + clave >= listaAlfabeto.size()) {
						textoDescifrado += listaAlfabeto.get((j + clave) % listaAlfabeto.size());
						break;
					} else {
						textoDescifrado += listaAlfabeto.get(j + clave);
						break;
					}
				} else if (!listaAlfabeto.contains(texto.charAt(i))) {
					textoDescifrado += texto.charAt(i);
					break;
				}
			}
		}

		return textoDescifrado;
	}
}
