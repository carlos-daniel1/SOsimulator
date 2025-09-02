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

	public void executeRoundRobin(Queue<Processo> processos) {

		System.out.println("Executando Round Robin:");

		Processo processo = processos.peek();

		if (processo.getQtdInstrucao() > 0) {
			cpu.executeRoundRobin(processo, quantum);
			processos.poll();

			System.out.println(String.format("Round Robin: Processo %d recebeu um quantum de: %d, restou: %d", processo.getId(),
					quantum, processo.getQtdInstrucao()));

			if (processo.getQtdInstrucao() > 0) {
				processos.offer(processo);
			}

		} else {
			System.out.println(String.format("Processo %d finalizado", processo.getId()));
		}

	}
}
