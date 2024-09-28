import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	public FileManager() {

	}

	//Metodo para poder leer el archivo
	public String leerArchivo(String rutaArchivo) {
		String archivo = "";
		try {
			List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));

			for (int i = 0; i < lineas.size(); i++) {
				archivo += lineas.get(i) + "\n";
			}

		} catch (Exception e) {
			System.out.println("El archivo no se puede leer: " + e.getMessage());
		}

		return archivo;

	}
	
	//Metodo para escribir texto en un archivo
	public void escribirArchivo(String rutaArchivo, String texto) {
		File archivo = new File(rutaArchivo);
		String [] textoArray = new String[texto.length()];
		textoArray = texto.split("\n");
				
		List <String> textoList = new ArrayList<>();
		for(int i = 0; i < textoArray.length; i++) {
			textoList.add(textoArray[i]);
		}
		
		try {
			PrintWriter escribirTexto = new PrintWriter(archivo);
			
			for(String valor : textoList) {
				escribirTexto.println(valor);
			}
			System.out.println("Archivo " + rutaArchivo + " creado");
			escribirTexto.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo escribir en el archivo" + e.getMessage());
			e.printStackTrace();
		}

	}

}
