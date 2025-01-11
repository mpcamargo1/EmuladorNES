package com.mpcamargo.emuladornes.core.CPU;


import com.mpcamargo.emuladornes.core.Bus;

public class CPU {
    private int A; // Registrador acumulador
    private int X; // Registrador X
    private int Y; // Registrador Y
    private int pc; // Contador de Programa
    private int sp; // Ponteiro da pilha
    private Flag status;  // Registrador de Status
    private int ciclo; // Contador de ciclos

    private Bus barramento; // Barramento

    public CPU (Bus barramento) {
        inicializarRegistradores();
        conectarAoBarramento(barramento);
    }

    private void conectarAoBarramento(Bus barramento) {
        this.barramento = barramento;
    }

    private void inicializarRegistradores() {
        A = X = Y = 0;
        pc = 0xFFFC;
        sp = 0xFD;
        status = Flag.NEGATIVE;
    }

    public void clock() throws Exception {
        if (ciclo == 0) {
            byte dado = barramento.lerMemoria(pc);
            pc++;
        }

        ciclo--;
    }
}
