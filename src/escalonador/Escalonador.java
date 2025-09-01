package escalonador;

import cpu.CPU;
import process.ProcessGenerator;

public class Escalonador {

    ProcessGenerator processGenerator = new ProcessGenerator();
    CPU cpu = new CPU();

    public void executeProcess() {
        for (int i = 0; i < 10; i++) {
            cpu.executeInstruction(processGenerator.generateProcess().get(i));
        }
    }
}
