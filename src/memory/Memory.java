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
	private int somaBlocosGerados = 0;

	public void addBlock(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			int randomNumber = random.nextInt(150) + 20;
			memory.add(new MemoryBlock(randomNumber));
			somaBlocosGerados += randomNumber;
			
		}		
		    blocksSize(memory);
	}
	public void alocarProcesso(Processo p) {
			algoritmo.firstFit(memory, p);
	}
	
	
	private void blocksSize(LinkedList<MemoryBlock> memory) {
		String tamanhos = memory.stream().map(bloco -> String.valueOf(bloco.getTamanho()))
				.collect(Collectors.joining(", "));

		System.out.println("Tamanhos dos Blocos: " + tamanhos);
	}
	
	public double taxaOcupacao() {
		int tamanhoAtual = memory.stream()
                .mapToInt(MemoryBlock::getTamanho)
                .sum();
		
		return (tamanhoAtual * 100.0) / somaBlocosGerados;
		
	}
	
	public void removerProcessoAleatorio() {
		
		int randomNumber = random.nextInt(memory.size());
		
		MemoryBlock bloco = memory.get(randomNumber);
		
		if(!bloco.getProcessos().isEmpty()) {
			System.out.println("Processo removido aleatoriamente: " + bloco.getProcessos().get(0));
			bloco.removerProcesso();
		}
	}
}	
