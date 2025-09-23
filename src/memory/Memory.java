package memory;

import java.util.LinkedList;

import processo.ProcessGenerator;
import processo.Processo;

public class Memory {
	LinkedList<MemoryBlock> memory = new LinkedList<>();
	ProcessGenerator p = new ProcessGenerator();
	Processo processo = null;

	public void addBlock() {
		for (int i = 0; i < 2; i++) {
		    memory.add(new MemoryBlock(200));
		}
	}
	public void addProcessAtBlock() {
	
		for (MemoryBlock b : memory) {
			processo = p.generateProcess();
			if(b.getTamanho() > processo.getTamanho()) {
				b.setProcessos(processo);
				b.setTamanho(b.getTamanho() - processo.getTamanho());
			}
		}
		
		System.out.println(memory);
	}
}	
