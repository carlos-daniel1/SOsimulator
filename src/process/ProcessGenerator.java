package process;

import java.util.ArrayList;
import java.util.Random;

public class ProcessGenerator {

	private static int nextId = 1;
	private Random random = new Random();
	ArrayList<Processo> arrayProcess = new ArrayList<Processo>();

	public ArrayList<Processo> generateProcess() {
		
		for (int i = 0; i < 10; i++) {	
			int gerarInstrucao = random.nextInt(41) + 10;
			Processo newProcess = new Processo(nextId++, gerarInstrucao);
			arrayProcess.add(newProcess);
		}

		return arrayProcess;
	}
}
