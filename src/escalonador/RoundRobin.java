package escalonador;

import java.util.Queue;

import cpu.CPU;
import process.Processo;

public class RoundRobin {

	int quantum = 5;
	CPU processador = new CPU();

	public void executeRoundRobin(Queue<Processo> queue) {

		System.out.println("Executando Round Robin:");

		while (!queue.isEmpty()) {
			Processo processo = queue.poll();

			if (processo.getQtdInstrucao() != 0) {
				processador.executeRoundRobin(processo, quantum);

				System.out.println(String.format("Processo %d recebeu um quantum de: %d, restou: %d",
						processo.getId(), quantum, processo.getQtdInstrucao()));

				queue.offer(processo);

			} else {
				System.out.println(String.format("Processo %d finalizado", processo.getId()));
			}
		}
	}
}
