package memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

import processo.Processo;

public class MemoryBlock {
	private static int counter = 0;
	private int id;
	private int tamanho;
	private ArrayList<Processo> processos;
	private static int alocados = 0;
	private static int naoAlocados = 0;

	public MemoryBlock(int tamanho) {
		this.tamanho = tamanho;
		this.processos = new ArrayList<>();
		this.id = ++counter;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public ArrayList<Processo> getProcessos() {
		return processos;
	}

	public void addProcesso(Processo p) {
		processos.add(p);
		alocados++;
	}

	public static void naoAlocar() {
		naoAlocados++;
	}

	public void alocar(int tamanhoProcesso) {
		tamanho -= tamanhoProcesso;
	}

	public static double getTaxaDescarte() {
		int total = alocados + naoAlocados;
		if (total != 0) { 
			return (naoAlocados * 100.0) / total;
		}
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BlocoMemoria id = " + id + ", tamanho = " + tamanho + ", processos = " + processos + "\n";
	}

	public static void blocksSize(LinkedList<MemoryBlock> memory) {
		String tamanhos = memory.stream().map(bloco -> String.valueOf(bloco.getTamanho()))
				.collect(Collectors.joining(", "));

		System.out.println("Tamanhos dos Blocos: " + tamanhos);
	}

}
