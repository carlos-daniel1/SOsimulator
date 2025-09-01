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

    public void executar(List<Processo> processos) {
        System.out.println("\nEscalonador SJF");

        System.out.println("Processos recebidos:");
        for (Processo p : processos) {
            System.out.print(p);
        }

        PriorityQueue<Processo> pq = new PriorityQueue<>(processos.size(),
                (p1, p2) -> Integer.compare(p1.getQtdInstrucao(), p2.getQtdInstrucao()));
        pq.addAll(processos);

        System.out.println("\nOrdem de execução SJF:");
        while (!pq.isEmpty()) {
            cpu.executeInstruction(pq.poll());
        }
    }
}
