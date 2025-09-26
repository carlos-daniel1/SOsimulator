package algorithms;

import java.util.LinkedList;

import memory.MemoryBlock;
import processo.Processo;

public class Algorithms {

	public boolean firstFit(LinkedList<MemoryBlock> memory, Processo processo) {
		for (MemoryBlock m : memory) {
			if (m.getTamanho() >= processo.getTamanho()) {
				m.setProcessos(processo);
				formatarMensagem(m, processo);
				m.setTamanho(m.getTamanho() - processo.getTamanho());
				return true;

			}
		}
		System.out.println("Processo id: " + processo.getId() + " não alocado!");
		return false;

	}

	public void nextFit() {

	}

	public void bestFit() {

	}

	public void worstFit() {

	}
	
	private void formatarMensagem(MemoryBlock m, Processo processo) {
		System.out.println(String.format("Processo id: %d, tamanho %d, alocado no bloco %d, com %d de espaço",
				processo.getId(), processo.getTamanho(), m.getId(), m.getTamanho()));
	}

}
