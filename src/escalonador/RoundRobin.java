package escalonador;

import java.util.Queue;

import cpu.CPU;
import process.Processo;

public class RoundRobin {

	int quantum = 5;
	private CPU cpu;
	
	public RoundRobin(CPU cpu) {
		this.cpu = cpu;
	}

	public void executeRoundRobin(Queue<Processo> queue) {

		System.out.println("Executando Round Robin:");

		while (!queue.isEmpty()) {
			Processo processo = queue.poll();

			if (processo.getQtdInstrucao() != 0) {
				cpu.executeRoundRobin(processo, quantum);

				System.out.println(String.format("Processo %d recebeu um quantum de: %d, restou: %d",
						processo.getId(), quantum, processo.getQtdInstrucao()));

				queue.offer(processo);

			} else {
				System.out.println(String.format("Processo %d finalizado", processo.getId()));
			}
		}
	}
}
