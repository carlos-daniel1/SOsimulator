package escalonador;

import java.util.Queue;
import cpu.CPU;
import process.Processo;

public class FCFS {
	private CPU cpu;

	public FCFS(CPU cpu) {
		this.cpu = cpu;
	}

	public void executar(Queue<Processo> processos) {
		System.out.println("\nEscalonador FCFS");

		Processo firstProcess = processos.peek();

		System.out.println("\nExecução FCFS:");
		while (firstProcess.getQtdInstrucao() > 0) {
			
			System.out.println(String.format("FCFS: Processo %d sendo executado, restou: %d instruções", firstProcess.getId(),
        			firstProcess.getQtdInstrucao()));
			
			cpu.executeInstruction(firstProcess);
			
			if (firstProcess.getQtdInstrucao() == 0) {
				processos.poll();

			}
		}
	}
}
