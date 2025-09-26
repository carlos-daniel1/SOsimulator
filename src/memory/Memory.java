package memory;

import java.util.LinkedList;
import java.util.Random;

import algorithms.Algorithms;
import processo.ProcessGenerator;
import processo.Processo;

public class Memory {
	LinkedList<MemoryBlock> memory = new LinkedList<>();
	ProcessGenerator p = new ProcessGenerator();
	Algorithms algoritmo = new Algorithms();
	Random random = new Random();
	Processo processo = null;

	public void addBlock() {
		for (int i = 0; i < 5; i++) {
		    memory.add(new MemoryBlock(random.nextInt(90) + 20));
		}
		MemoryBlock.blocksSize(memory);
	}
	public void alocarProcesso() {
		for (int i = 0; i < 5; i++) {
			processo = p.generateProcess();
			algoritmo.bestFit(memory, processo);
		}
		
		p.mediaTamanhoProcessos();
	}
	
}	
