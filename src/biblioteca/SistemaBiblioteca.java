package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaBiblioteca {

    private Map<String, Material> catalogo;
    private Map<String, List<String>> listaEspera;
    private Set<String> miembros;

    public SistemaBiblioteca() {
        catalogo = new HashMap<>();
        listaEspera = new HashMap<>();
        miembros = new HashSet<>();
    }

    // =========================
    // HASHMAP - CATÁLOGO
    // =========================

    public void registrarMaterial(Material material) {
        catalogo.put(material.getCodigo(), material);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo);
    }

    public void mostrarCatalogo() {

        System.out.println("\n===== CATÁLOGO =====");

        for (Material material : catalogo.values()) {
            material.mostrarInfo();
        }
    }

    // =========================
    // ARRAYLIST - LISTA ESPERA
    // =========================

    public void agregarEspera(String codigoMaterial, String usuario) {

        if (!listaEspera.containsKey(codigoMaterial)) {
            listaEspera.put(codigoMaterial, new ArrayList<>());
        }

        listaEspera.get(codigoMaterial).add(usuario);
    }

    public String siguienteEnEspera(String codigoMaterial) {

        List<String> lista = listaEspera.get(codigoMaterial);

        if (lista == null || lista.isEmpty()) {
            return null;
        }

        return lista.remove(0);
    }

    // =========================
    // HASHSET - MEMBRESÍAS
    // =========================

    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario);
    }

    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);
    }
}