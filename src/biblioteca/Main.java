package biblioteca;

public class Main {

    public static void main(String[] args) {

        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        // =====================================
        // 1. CREAR MATERIALES
        // =====================================

        Libro libro1 = new Libro(
                "BK-2024-001",
                "Java desde cero",
                2024,
                true,
                "Ana Gómez",
                "978-1234567890"
        );

        Libro libro2 = new Libro(
                "BK-2024-002",
                "Programación Java",
                2024,
                false,
                "Carlos Ruiz",
                "978-9876543210"
        );

        Revista revista1 = new Revista(
                "RV-2025-001",
                "Tecnología Hoy",
                2025,
                true,
                15,
                "Tecnología"
        );

        // =====================================
        // 2. REGISTRAR EN EL CATÁLOGO
        // =====================================

        biblioteca.registrarMaterial(libro1);
        biblioteca.registrarMaterial(libro2);
        biblioteca.registrarMaterial(revista1);

        // =====================================
        // 3. MOSTRAR CATÁLOGO
        // =====================================

        biblioteca.mostrarCatalogo();

        // =====================================
        // 4. BUSCAR POR CÓDIGO
        // =====================================

        System.out.println("\n===== BUSCAR MATERIAL =====");

        Material encontrado = biblioteca.buscarMaterial("BK-2024-001");

        if (encontrado != null) {
            encontrado.mostrarInfo();
        }

        // Buscar uno que no existe

        Material noExiste = biblioteca.buscarMaterial("XXX-999");

        if (noExiste == null) {
            System.out.println("El material no existe.");
        }

        // =====================================
        // 5. LISTA DE ESPERA
        // =====================================

        System.out.println("\n===== LISTA DE ESPERA =====");

        biblioteca.agregarEspera("BK-2024-002", "Ana");
        biblioteca.agregarEspera("BK-2024-002", "Carlos");
        biblioteca.agregarEspera("BK-2024-002", "Pedro");

        System.out.println(
                "Siguiente: " +
                        biblioteca.siguienteEnEspera("BK-2024-002")
        );

        System.out.println(
                "Siguiente: " +
                        biblioteca.siguienteEnEspera("BK-2024-002")
        );

        // =====================================
        // 6. MEMBRESÍAS
        // =====================================

        System.out.println("\n===== MEMBRESÍAS =====");

        System.out.println(
                "Ana registrada: " +
                        biblioteca.registrarMiembro("Ana")
        );

        System.out.println(
                "Carlos registrado: " +
                        biblioteca.registrarMiembro("Carlos")
        );

        System.out.println(
                "Pedro registrado: " +
                        biblioteca.registrarMiembro("Pedro")
        );

        // Intentar registrar a Ana nuevamente

        System.out.println(
                "Ana nuevamente: " +
                        biblioteca.registrarMiembro("Ana")
        );

        // Verificar membresías

        System.out.println(
                "¿Ana tiene membresía? " +
                        biblioteca.tieneMembresia("Ana")
        );

        System.out.println(
                "¿Luis tiene membresía? " +
                        biblioteca.tieneMembresia("Luis")
        );
    }
}