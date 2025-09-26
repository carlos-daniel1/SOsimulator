package algorithms;

import java.util.LinkedList;

import memory.MemoryBlock;
import processo.Processo;

public class Algorithms {
	private static int apontador = 0;

	public boolean firstFit(LinkedList<MemoryBlock> memory, Processo processo) {
		for (MemoryBlock block : memory) {
			if (block.getTamanho() >= processo.getTamanho()) {
				block.setProcessos(processo);
				formatarMensagem(block, processo);
				block.setTamanho(block.getTamanho() - processo.getTamanho());
				return true;

			}
		}
		System.out.println("Processo id: " + processo.getId() + " não alocado!");
		return false;

	}

	public boolean nextFit(LinkedList<MemoryBlock> memory, Processo processo) {
		for (int i = apontador; i < memory.size(); i++) {
			MemoryBlock block = memory.get(i);
			if(block.getTamanho() >= processo.getTamanho()) {
				block.setProcessos(processo);
				formatarMensagem(block, processo);
				block.setTamanho(block.getTamanho() - processo.getTamanho());
				apontador = i;
				return true;
			}
		}
		System.out.println("Processo id: " + processo.getId() + " não alocado!");
		return false;

	}

	public void bestFit(LinkedList<MemoryBlock> memory, Processo processo) {
		for (MemoryBlock block : memory) {
			
		}

	}

	public void worstFit() {

	}
	
	private void formatarMensagem(MemoryBlock block, Processo processo) {
		System.out.println(String.format("Processo id: %d tamanho %d, alocado no bloco %d com %d de espaço",
				processo.getId(), processo.getTamanho(), block.getId(), block.getTamanho()));
	}

}
