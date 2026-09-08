package Singleton;

import java.util.List;
import java.util.ArrayList;

public class Logger {
    // 1. Variable estática privada que almacenará la ÚNICA instancia permitida de la clase.
    private static Logger instance;
    
    // 2. Lista para almacenar los mensajes de registro (logs) que se vayan creando.
    private List<String> logMessages = new ArrayList<>();

    // 3. Constructor privado: IMPIDE que otras clases usen "new Logger()", protegiendo la unicidad.
    private Logger() {
        // Constructor privado para evitar instanciación directa[cite: 3]
    }

    // 4. Método público y estático para obtener la instancia. Si no existe, la crea; si ya existe, devuelve la misma.
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Se crea por primera y única vez
        }
        return instance; // Devuelve la instancia existente
    }

    // 5. Método de negocio para agregar un nuevo mensaje al registro global.
    public void addLogMessage(String message) {
        logMessages.add(message);
    }

    // 6. Método para imprimir por consola todos los mensajes guardados en el registro.
    public void printLogs() {
        for (String message : logMessages) {
            System.out.println(message);
        }
    }
}
