package principal;

import servicio.FileReadingThread;

public class Principal {

	public static void main(String[] args) {
		//Nombre del archivo que se va a leer
		String fileName = "archivo.txt";
		
		//Crear e iniciar el hilo para la lectura del archivo
		FileReadingThread fileReadingThread = new FileReadingThread(fileName);
		fileReadingThread.start();
		
		//Operaciones del hilo principal mientras se lee el archivo
		for(int i = 0; i < 5; i++) {
			System.out.println("Realizando operacion en el hilo principal...");
			//Simular alguna operacion con un simple retardo
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Esperar a que el hilo de lectura del archivo termine
		try {
			fileReadingThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin del programa");	
	}
}
