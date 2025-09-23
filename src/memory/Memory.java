package memory;

import java.util.LinkedList;

import processo.ProcessGenerator;
import processo.Processo;

public class Memory {
	LinkedList<MemoryBlock> memory = new LinkedList<>();
	ProcessGenerator p = new ProcessGenerator();
	Processo processo = null;

	public void addBlock() {
		for (int i = 0; i < 5; i++) {
		    memory.add(new MemoryBlock(200));
		}
	}
	
	public void addProcessAtBlock() {
		for (MemoryBlock b : memory) {
			processo = p.generateProcess();
			if(b.getTamanho() > processo.getQtdInstrucao()) {
				b.setProcessos(processo);
			}
		}
		
		System.out.println(memory);
	}
}	
