//@author Daiane Tararam

package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {
	public KillController() {
		super();
	}
	
	private String os() {
		String name = System.getProperty("os.name");
		System.out.println("Sistema Operacional: "+ name);
		return name;
	}
	
	public void listaProcessos() {
		String so = os();
		String comando = "";
		
		try {
			if(so.contains("Windows")) {
				comando = "TASKLIST /FO TABLE";
			}else if(so.contains("Linux")){
				comando = "ps -ef";
			}
			
			Process processo = Runtime.getRuntime().exec(comando);
			BufferedReader ler = new BufferedReader(new InputStreamReader(processo.getInputStream()));
			String linha;
			while((linha = ler.readLine()) != null) {
				System.out.println(linha);
			}
			ler.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mataPid(int pid) {
		String so = os();
		String comando = "";
		
		try {
			if(so.contains("Windows")) {
				comando = "TASKKILL /PID " + pid;
			}else if (so.contains("Linux")) {
				comando = "kill -9 " + pid;
			}
			Runtime.getRuntime().exec(comando);
			System.out.println("Processo com PID: " + pid + " foi terminado." );
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mataNome(String pidNome) {
		String so = os();
		String comando = "";
		
		try {
			if(so.contains("Windows")) {
				comando = "TASKKILL /IM " + pidNome;
			}else if (so.contains("Linux")) {
				comando = "pkill -f " + pidNome;
			}
			Runtime.getRuntime().exec(comando);
			System.out.println("Processo com nome: " + pidNome + " foi terminado." );
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
