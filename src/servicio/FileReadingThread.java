package servicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingThread extends Thread {
	
	private String fileName;
	
	public FileReadingThread(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = reader.readLine()) !=null) {
				//Procesar cada linea del archivo
				System.out.println("Leyendo linea: "+ line);
				//Simular algun procesamiento con un simple retardo
				Thread.sleep(1000);
			}
			reader.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
