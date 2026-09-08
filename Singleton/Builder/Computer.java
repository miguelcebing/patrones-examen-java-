package Builder;

// 1. El objeto complejo que queremos construir (una Computadora con múltiples partes).
class Computer {
    private String cpu;
    private String memory;
    private String storage;
    private String gpu;

    // Métodos setters para asignar los componentes paso a paso.
    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setMemory(String memory) { this.memory = memory; }
    public void setStorage(String storage) { this.storage = storage; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    // Método para mostrar el resultado final del objeto armado.
    public void showComputer() {
        System.out.println("Computer with CPU: " + cpu + ", Memory: " + memory + ", Storage: " + storage + ", GPU: " + gpu);
    }
}

// 2. Interfaz Builder: Define los pasos genéricos para armar cualquier tipo de computadora.
interface ComputerBuilder {
    void buildCpu();
    void buildMemory();
    void buildStorage();
    void buildGpu();
    Computer getComputer(); // Devuelve el objeto ya construido
}

// 3. Builder Concreto: Define los detalles específicos para construir una Computadora Gamer.
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer(); // Instancia el objeto vacío que irá tomando forma

    @Override public void buildCpu() { computer.setCpu("Intel Core i7"); }
    @Override public void buildMemory() { computer.setMemory("16GB DDR4 RAM"); }
    @Override public void buildStorage() { computer.setStorage("512GB SSD + 1TB HDD"); }
    @Override public void buildGpu() { computer.setGpu("NVIDIA RTX 3080"); }
    
    @Override public Computer getComputer() { return computer; }
}

// 4. Director: Controla el orden exacto en el que se deben ejecutar los pasos de construcción.
class ComputerDirector {
    private ComputerBuilder computerBuilder;

    // Recibe el constructor específico por inyección.
    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    // Ejecuta los pasos de manera secuencial y organizada.
    public void buildComputer() {
        computerBuilder.buildCpu();
        computerBuilder.buildMemory();
        computerBuilder.buildStorage();
        computerBuilder.buildGpu();
    }
}
