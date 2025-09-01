package escalonador;

import java.util.LinkedList;
import java.util.Queue;
import cpu.CPU;
import process.ProcessGenerator;
import process.Processo;

public class Escalonador {
	private CPU cpu;
	private FCFS fcfs;
	private RoundRobin roundRobin;
	private SJF sjf;
	private ProcessGenerator processGenerator;;
	
	public Escalonador() {
	    this.cpu = new CPU();
	    this.fcfs = new FCFS(cpu);
	    this.roundRobin = new RoundRobin(cpu);
	    this.sjf = new SJF(cpu);
	    this.processGenerator = new ProcessGenerator();
	}
	

	Queue<Processo> queue = new LinkedList<>(processGenerator.generateProcess());
	
	public void executeProcess() {
		roundRobin.executeRoundRobin(queue);
	}
}
