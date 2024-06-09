package org.example;

import java.util.HashMap;
import java.util.Map;

public class DependencyInjector {
    private Map<Class<?>, Object> dependencies = new HashMap<>();//mapa para almacenar las instancias de las dependencias

    public <T> void addDependency(Class<T> classType, T classImplementation) {//método para registrar dependencias
        dependencies.put(classType, classImplementation);
    }
    @SuppressWarnings("unchecked")
    public <T> T getDependency(Class<T> classType) {//método para obtener dependencias
        return (T) dependencies.get(classType);
    }
}
