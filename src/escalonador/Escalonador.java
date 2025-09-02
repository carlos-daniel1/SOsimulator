package escalonador;

import java.util.Queue;
import java.util.Random;

import cpu.CPU;
import process.ProcessGenerator;
import process.Processo;

public class Escalonador {
	private CPU cpu;
	private FCFS fcfs;
	private RoundRobin roundRobin;
	private SJF sjf;
	private ProcessGenerator processGenerator;;
	private Queue<Processo> processos;
	Random random = new Random();

	public Escalonador() {
		this.cpu = new CPU();
		this.fcfs = new FCFS(cpu);
		this.roundRobin = new RoundRobin(cpu);
		this.sjf = new SJF(cpu);
		this.processGenerator = new ProcessGenerator();
		this.processos = processGenerator.generateProcess();
	}

	public void executeProcess() {

		while (!processos.isEmpty()) {
			int numero = random.nextInt(3) + 1;
			
			if (numero == 1) {
				fcfs.executar(processos);
			} else if (numero == 2) {
				sjf.executar(processos);
			} else {
				roundRobin.executeRoundRobin(processos);
			}
		}

	}
}
