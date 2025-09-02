package process;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProcessGenerator {

	private static int nextId = 1;
	private Random random = new Random();

	public Queue<Processo> generateProcess() {
		Queue<Processo> filaProcessos = new LinkedList<>();

		for (int i = 0; i < 10; i++) {
			int gerarInstrucao = random.nextInt(11) + 10;
			Processo newProcess = new Processo(nextId++, gerarInstrucao);
			filaProcessos.offer(newProcess);
		}

		return filaProcessos;
	}
}
