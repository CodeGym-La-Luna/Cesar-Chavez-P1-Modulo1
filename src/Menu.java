import java.util.Scanner;

public class Menu {

	public Menu() {

	}

	public void mostrarMenu() {

		FileManager fileManager = new FileManager();
		Cipher cipher = new Cipher();
		Scanner scanner = new Scanner(System.in);
		Scanner scannerTexto = new Scanner(System.in);
		int seleccion = 0;
		String nombreArchivo = "", nombreArchivoProcesado = "";
		int clave;
		boolean iterar = true;
		boolean iterarInt = true;
		boolean terminar = false;

		System.out.println("--------------------------------------------");
		System.out.println("Programa de cifrado y descifrado de archivos");
		System.out.println("--------------------------------------------\n");

		while (iterar) {
			try {
				iterarInt = true;
				System.out.println("Seleccionar una opcion: ");

				System.out.println("1 Cifrar");
				System.out.println("2 Descifrar");
				System.out.println("3 Salir");

				seleccion = scanner.nextInt();

				if (seleccion == 1 || seleccion == 2) {
					iterarInt = false;
				} else if (seleccion == 3) {
					iterarInt = false;
					iterar = false;
					break;
				}

				while (iterarInt == true) {
					System.out.println("Haz escogido una opcion no valida, vuelve a seleccionar una opcion: ");

					System.out.println("1 Cifrar");
					System.out.println("2 Descifrar");
					System.out.println("3 Salir");

					seleccion = scanner.nextInt();

					if (seleccion == 1 || seleccion == 2) {
						iterarInt = false;
					} else if (seleccion == 3) {
						iterarInt = false;
						iterar = false;
						terminar = true;
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("Se ingreso un valor desconocido " + e.getMessage());
				e.printStackTrace();
			}

			// Dentro de este if se indica la condicion del valor booleano de terminar, si
			// es true terminará el programa
			// de otra forma el programa continuará con su ejecución
			if (terminar) {
				break;
			}

			System.out.print("Elige un numero que servira de clave para trabajar el archivo: ");
			clave = scanner.nextInt();

			if (clave <= 0) {
				System.out.println("\nHas elegido una valor menor que cero. Se asignará el valor de 1 a la clave\n");
				clave = 1;
			}

			System.out.print("Selecciona el nombre del archivo con el que quieres trabajar sin su extension: ");
			nombreArchivo = scannerTexto.nextLine();

			nombreArchivoProcesado = nombreArchivo;

			switch (seleccion) {
			case 1:
				String cifrado = cipher.cifrarTexto(fileManager.leerArchivo(nombreArchivo + ".txt"), clave);
				fileManager.escribirArchivo(nombreArchivoProcesado + "Cifrado.txt", cifrado);
				System.out.println("");
				break;
			case 2:
				String descifrado = cipher.descifrarTexto(fileManager.leerArchivo(nombreArchivo + ".txt"), clave);
				fileManager.escribirArchivo(nombreArchivoProcesado + "Descifrado.txt", descifrado);
				System.out.println("");
				break;
			case 3:
				iterar = false;
				break;
			}
		}
	}

}
