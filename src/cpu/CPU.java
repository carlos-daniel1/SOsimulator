package cpu;

import process.Processo;

public class CPU {

	public void executeInstruction(Processo process) {
		int qtdInstrucao = process.getQtdInstrucao();
		process.setQtdInstrucao(qtdInstrucao - 1);

		if (process.getQtdInstrucao() == 0) {
			System.out.println(String.format("Processo: %d finalizado, qtd. instrucoes: %d\n", process.getId(),
					process.getQtdInstrucao()));
		}

	}

	public void executeRoundRobin(Processo process, int quantum) {
		int qtdInstrucao = process.getQtdInstrucao();
		if (quantum > qtdInstrucao) {
			process.setQtdInstrucao(0);
		} else {
			process.setQtdInstrucao(qtdInstrucao - quantum);
		}

	}
}
