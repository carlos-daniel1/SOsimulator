package processo;

import java.util.Random;

public class ProcessGenerator {
	private static int nextId = 1;
	private Random random = new Random();
	
	public Processo generateProcess() {
		int gerarInstrucao = random.nextInt(41) + 10;
		
		Processo newProcess = new Processo(nextId, gerarInstrucao);
		
		return newProcess;
		
	}
}
