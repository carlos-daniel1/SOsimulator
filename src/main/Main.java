package main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import memory.Memory;
import memory.MemoryBlock;
import processo.ProcessGenerator;
import processo.Processo;


public class Main {
	public static void main(String[] args) {
		Memory memory = new Memory();
		ProcessGenerator geradorProcesso = new ProcessGenerator();
		Processo processo = null;
		final Processo[] processoWrapper = new Processo[1];
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2); // 2 threads
		int intervalo2 = 2;    // segundos
		int intervalo1 = 1;     // segundos
		int tempoTotal = 10;    // segundos

		long tempoInicial = System.currentTimeMillis();

		// a cada 1 s
		Runnable tarefa1s = () -> {
		    long tempoDecorrido = (System.currentTimeMillis() - tempoInicial) / 1000;
		    processoWrapper[0] = geradorProcesso.generateProcess();
		    
		    
		    memory.alocarProcesso(processoWrapper[0]);
		    

		    if (tempoDecorrido >= tempoTotal) {
		        scheduler.shutdown();
		        geradorProcesso.mediaTamanhoProcessos();
		        System.out.println(String.format("Taxa de descarte: %.0f%%", MemoryBlock.getTaxaDescarte()));
		    }
		};

		// a cada 2s
		Runnable tarefa2s = () -> {
		    long tempoDecorrido = (System.currentTimeMillis() - tempoInicial) / 1000;
		};
		
		memory.addBlock();
		
		scheduler.scheduleAtFixedRate(tarefa1s, 0, intervalo1, TimeUnit.SECONDS);
		scheduler.scheduleAtFixedRate(tarefa2s, 0, intervalo2, TimeUnit.SECONDS);
		
	        
	}
}
