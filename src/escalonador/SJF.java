package escalonador;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import cpu.CPU;
import process.Processo;

public class SJF {
    private CPU cpu;

    public SJF(CPU cpu) {
        this.cpu = cpu;
    }

    public void executar(Queue<Processo> processos) {
       
        PriorityQueue<Processo> pq = new PriorityQueue<>(processos.size(),
                (p1, p2) -> Integer.compare(p1.getQtdInstrucao(), p2.getQtdInstrucao()));
        pq.addAll(processos);

        System.out.println("\nExecução SJF:");
        
        Processo firstProcess = pq.peek();
        
        while(firstProcess.getQtdInstrucao() > 0) {
        	System.out.println(String.format("SJF: Processo %d sendo executado, restou: %d instruções", firstProcess.getId(),
        			firstProcess.getQtdInstrucao()));
        	
        	cpu.executeInstruction(firstProcess);
        	
        	if(firstProcess.getQtdInstrucao() == 0) {
        		processos.remove(firstProcess);
        	}
        }
        
    }
}
