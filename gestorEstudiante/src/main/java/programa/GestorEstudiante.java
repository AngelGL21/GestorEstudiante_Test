/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package programa;

/**
 *
 * @author lopez
 */
import java.util.ArrayList;
import java.util.List;

class Estudiante {
    private String nombre;
    private List<Integer> notas;

    public Estudiante(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarNota(int nota) {
        this.notas.add(nota);
    }

    public List<Integer> getNotas() {
        return notas;
    }

    public double calcularPromedio() {
        return notas.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public boolean haAprobado() {
        return calcularPromedio() >= 60;
    }
}

class GestorEstudiantes {
    private List<Estudiante> estudiantes;

    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiante(String nombre) {
        return estudiantes.stream()
                .filter(est -> est.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }
}

public class GestorEstudiante {
    public static void main(String[] args) {
        GestorEstudiantes gestor = new GestorEstudiantes();

        // Crear estudiantes
        Estudiante est1 = new Estudiante("Juan");
        est1.agregarNota(75);
        est1.agregarNota(80);
        est1.agregarNota(90);

        Estudiante est2 = new Estudiante("Maria");
        est2.agregarNota(50);
        est2.agregarNota(60);
        est2.agregarNota(70);

        // Agregar estudiantes al gestor
        gestor.agregarEstudiante(est1);
        gestor.agregarEstudiante(est2);

        // Buscar y mostrar resultados
        Estudiante estudiante = gestor.buscarEstudiante("Juan");
        if (estudiante != null) {
            System.out.println("Promedio de " + estudiante.getNombre() + ": " + estudiante.calcularPromedio());
            System.out.println("Ha aprobado? " + (estudiante.haAprobado() ? "Si" : "No"));
        }

        estudiante = gestor.buscarEstudiante("Maria");
        if (estudiante != null) {
            System.out.println("Promedio de " + estudiante.getNombre() + ": " + estudiante.calcularPromedio());
            System.out.println("Ha aprobado? " + (estudiante.haAprobado() ? "Si" : "No"));
        }
    }
}
