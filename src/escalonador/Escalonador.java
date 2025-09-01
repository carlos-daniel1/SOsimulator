package escalonador;

import java.util.LinkedList;
import java.util.Queue;

import cpu.CPU;
import process.ProcessGenerator;
import process.Processo;

public class Escalonador {

	ProcessGenerator processGenerator = new ProcessGenerator();
	CPU cpu = new CPU();
	RoundRobin roundRobin = new RoundRobin();
	Queue<Processo> queue = new LinkedList<>(processGenerator.generateProcess());
	
	public void executeProcess() {
		roundRobin.executeRoundRobin(queue);
	}
}
