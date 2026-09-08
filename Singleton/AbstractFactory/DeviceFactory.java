package AbstractFactory;

// 1. Interfaces abstractas para los productos genéricos (Teléfonos y Computadoras).
interface Phone {
    String getModel();
}

interface Computer {
    String getModel();
}

// 2. Productos concretos de la familia Samsung.
class SamsungPhone implements Phone {
    public String getModel() { return "Samsung Galaxy"; }
}

class SamsungComputer implements Computer {
    public String getModel() { return "Samsung Laptop"; }
}

// 3. Productos concretos de la familia Apple.
class ApplePhone implements Phone {
    public String getModel() { return "iPhone"; }
}

class AppleComputer implements Computer {
    public String getModel() { return "MacBook Pro"; }
}

// 4. La Fábrica Abstracta: Declara los métodos para crear toda la familia de productos.
interface DeviceFactory {
    Phone createPhone();
    Computer createComputer();
}

// 5. Fábrica Concreta de Samsung: Crea exclusivamente dispositivos de la marca Samsung.
class SamsungFactory implements DeviceFactory {
    public Phone createPhone() { return new SamsungPhone(); }
    public Computer createComputer() { return new SamsungComputer(); }
}

// 6. Fábrica Concreta de Apple: Crea exclusivamente dispositivos de la marca Apple.
class AppleFactory implements DeviceFactory {
    public Phone createPhone() { return new ApplePhone(); }
    public Computer createComputer() { return new AppleComputer(); }
}
