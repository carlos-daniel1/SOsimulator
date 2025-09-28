package memory;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

import algorithms.Algorithms;
import processo.ProcessGenerator;
import processo.Processo;

public class Memory {
	LinkedList<MemoryBlock> memory = new LinkedList<>();
	ProcessGenerator geradorProcesso = new ProcessGenerator();
	Algorithms algoritmo = new Algorithms();
	Random random = new Random();
	Processo processo = null;

	public void addBlock() {
		for (int i = 0; i < 5; i++) {
			memory.add(new MemoryBlock(random.nextInt(50) + 20));
			
		}		
		    blocksSize(memory);
	}
	public void alocarProcesso(Processo p) {
			algoritmo.worstFit(memory, p);
	}
	
	
	private static void blocksSize(LinkedList<MemoryBlock> memory) {
		String tamanhos = memory.stream().map(bloco -> String.valueOf(bloco.getTamanho()))
				.collect(Collectors.joining(", "));

		System.out.println("Tamanhos dos Blocos: " + tamanhos);
	}
}	
