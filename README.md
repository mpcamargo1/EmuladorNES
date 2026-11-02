# 🎮 Emulador NES (Java)

Um emulador do **Nintendo Entertainment System (NES)** desenvolvido em Java do zero, com foco educacional para estudo de arquitetura de computadores, decodificação de instruções e emulação de hardware de baixo nível.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Interface Gráfica:** JavaFX (Canvas / FXML)
- **Gerenciador de Dependências:** Maven
- **Testes Unitários:** JUnit 5

---

## 🏗️ Arquitetura do Sistema

- **CPU:** Ricoh 2A03 (baseado no MOS 6502, sem modo BCD)
- **PPU:** Ricoh 2C02 (Picture Processing Unit)
- **Barramento (Bus):** Mapeamento de memória, RAM interna (com espelhamento) e acesso aos periféricos
- **Mappers:** Suporte inicial planejado para NROM (Mapper 0)

---

## 🚀 Status do Projeto e Roadmap

### Fase 1: Fundação e Estrutura ✅
- [x] Estrutura do projeto Maven + JavaFX
- [x] Implementação inicial do barramento (`Bus`) com memória RAM e espelhamento

### Fase 2: Emulação da CPU (Ricoh 2A03) 🟡 (Em andamento)
- [x] Registradores (`A`, `X`, `Y`, `PC`, `SP`) e Registrador de Status (`P`)
- [x] Mecanismo de Pilha (operações de 8-bit e 16-bit)
- [x] Instruções de Flag (`CLC`, `SEC`, `CLI`, `SEI`, `CLV`, `CLD`, `SED`)
- [x] Instruções de Transferência (`TAX`, `TXA`, `TAY`, `TYA`, `TSX`, `TXS`)
- [x] Comparações (`CMP` nos modos existentes)
- [x] Saltos incondicionais (`JMP` Absoluto e Indireto com tratamento do bug histórico de virada de página)
- [x] Incremento e decremento de registradores (`INX`, `INY`, `DEX`, `DEY`)
- [ ] Instruções de Carga e Escrita (`LDA`, `STA`, `LDX`, `STX`, `LDY`, `STY`)
- [ ] Aritmética e Lógica (`ADC`, `SBC`, `AND`, `ORA`, `EOR`, `BIT`)
- [ ] Rotações e Deslocamentos (`ASL`, `LSR`, `ROL`, `ROR`)
- [ ] Demais Desvios Condicionais (`BNE`, `BPL`, `BMI`, `BCC`, `BCS`, `BVC`, `BVS`)
- [ ] Sub-rotinas e Interrupções (`JSR`, `RTS`, `BRK`, `RTI`, `NMI`, `IRQ`)

### Fase 3: Carregador de ROMs (iNES) e Mappers ⏳
- [ ] Leitura e validação do cabeçalho `.nes` (iNES Header)
- [ ] Mapeador básico NROM (Mapper 0)
- [ ] Validação automatizada da CPU contra a ROM oficial `nestest.nes`

### Fase 4: PPU (Picture Processing Unit) ⏳
- [ ] Mapeamento de memória da PPU (VRAM, Paletas, OAM)
- [ ] Renderização de Pattern Tables e Nametables (Background)
- [ ] Renderização de Sprites (Foreground / OAM)
- [ ] Geração da interrupção NMI no início do VBlank

### Fase 5: Entrada e Áudio (APU) ⏳
- [ ] Mapeamento do Controle (Shift register `$4016`/`$4017`) via teclado
- [ ] Canais básicos de som da APU (Pulse, Triangle, Noise)

---

## 💻 Como Executar

### Pré-requisitos:
- JDK 17 ou superior
- Maven instalado (ou integrado à sua IDE, como IntelliJ IDEA ou Eclipse)

### Executando via terminal:
```bash
mvn clean compile javafx:run
```

---

## 📚 Referências Úteis

- [Nesdev Wiki](https://www.nesdev.org/wiki/) - A principal documentação comunitária da arquitetura do NES
- [6502 Instruction Reference (Obelisk)](http://www.obelisk.me.uk/6502/reference.html) - Guia rápido de instruções e modos de endereçamento do 6502
- [The B Flag & 6502 Status Register](https://www.nesdev.org/wiki/Status_flags#The_B_flag) - Detalhamento das flags e pilha do 6502
- [Visual 6502](http://visual6502.org/) - Simulador a nível de transistores do 6502
