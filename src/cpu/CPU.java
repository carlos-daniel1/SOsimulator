package cpu;

import process.Processo;

public class CPU {

	public void executeInstruction(Processo process) {
		while (process.getQtdInstrucao() > 0) {

			int qtdInstrucao = process.getQtdInstrucao();
			process.setQtdInstrucao(qtdInstrucao - 1);
		}
		System.out.println(String.format("Processo: %d finalizado, qtd. instrucoes: %d", process.getId(),
				process.getQtdInstrucao()));
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
