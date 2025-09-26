package processo;

import java.util.Random;

public class ProcessGenerator {
	private static int nextId = 1;
	private Random random = new Random();
	private int somaTamanhoProcessos = 0;
	
	public Processo generateProcess() {
		int gerarTamanho = random.nextInt(41) + 10;
		somaTamanhoProcessos += gerarTamanho;
		
		Processo newProcess = new Processo(nextId++, gerarTamanho);
		
		return newProcess;
		
	}
	
	public void mediaTamanhoProcessos() {
		double media = somaTamanhoProcessos / (nextId - 1);
		System.out.println("Tamanho médio dos processos gerados: " + media);
	}
}
