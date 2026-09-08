package Prototype;

// 1. Interfaz prototipo que define el contrato de clonación obligatorio para cualquier figura.
interface Shape {
    Shape clone(); // Método que devuelve una copia exacta del objeto
    void draw();
}

// 2. Clase concreta que implementa la interfaz Shape (en este caso, un Círculo).
class Circle implements Shape {
    private int radius; // Atributo propio del círculo

    // Constructor normal para inicializar el objeto por primera vez.
    public Circle(int radius) {
        this.radius = radius;
    }

    // Modificador del radio por si se requiere ajustar después.
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // 3. Sobrescribimos el método clone para replicar este objeto devolviendo uno nuevo con sus mismos valores.
    @Override
    public Shape clone() {
        return new Circle(this.radius); // Retorna una nueva instancia clonando el radio actual
    }

    // Método funcional para simular el dibujo de la figura.
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}
