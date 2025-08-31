package process;

public class Process {
	private int id;
	private int qtdInstrucao;
	
	public Process(int id, int qtdInstrucao) {
		this.id = id;
		this.qtdInstrucao = qtdInstrucao;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtdInstrucao() {
		return qtdInstrucao;
	}
	public void setQtdInstrucao(int qtdInstrucao) {
		this.qtdInstrucao = qtdInstrucao;
	}
	
}
