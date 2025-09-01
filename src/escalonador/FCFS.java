package escalonador;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import cpu.CPU;
import process.Processo;

public class FCFS {
    private CPU cpu;

    public FCFS(CPU cpu) {
        this.cpu = cpu;
    }

    public void executar(List<Processo> processos) {
        System.out.println("\nEscalonador FCFS");

        System.out.println("Processos recebidos:");
        for (Processo p : processos) {
            System.out.print(p);
        }

        Queue<Processo> fila = new LinkedList<>(processos);

        System.out.println("\nOrdem de execução FCFS:");
        while (!fila.isEmpty()) {
            Processo p = fila.poll();
            cpu.executeInstruction(p);
        }
    }
}
