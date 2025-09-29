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
		final Processo[] arrayProcessos = new Processo[2];

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
		int intervalo2 = 2;
		int intervalo1 = 1;
		int tempoTotal = 20;

		long tempoInicial = System.currentTimeMillis();

		double[] somaOcupacao = { 0.0 };
		int[] segundos = { 0 };

		Runnable tarefa1s = () -> {
			long tempoDecorrido = (System.currentTimeMillis() - tempoInicial) / 1000;
			arrayProcessos[0] = geradorProcesso.generateProcess();
			arrayProcessos[1] = geradorProcesso.generateProcess();

			memory.alocarProcesso(arrayProcessos[0]);
			memory.alocarProcesso(arrayProcessos[1]);

			double ocupacaoAtual = memory.taxaOcupacao();
			somaOcupacao[0] += ocupacaoAtual;
			segundos[0]++;

			
			
			if (tempoDecorrido >= tempoTotal) {
				scheduler.shutdown();
				geradorProcesso.mediaTamanhoProcessos();
				System.out.println(String.format("Taxa de descarte: %.0f%%", MemoryBlock.getTaxaDescarte()));

				double ocupacaoMedia = somaOcupacao[0] / segundos[0];
				System.out.printf("Ocupação média da memória: %.2f%%\n", ocupacaoMedia);
			}
			
			if (MemoryBlock.getTaxaDescarte() > 30) {
				System.out.println("---------------Aumentando memória---------------");
				memory.addBlock(1);
			}

		};

		Runnable tarefa2s = () -> {
			memory.removerProcessoAleatorio();
		};

		memory.addBlock(10);

		scheduler.scheduleAtFixedRate(tarefa1s, 0, intervalo1, TimeUnit.SECONDS);
		scheduler.scheduleAtFixedRate(tarefa2s, 1, intervalo2, TimeUnit.SECONDS);

	}
}
