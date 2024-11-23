package tech.codestrux.sca.models;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@SpringComponent
@VaadinSessionScope
public class Prueba {
    private String nombre;
    private Map<Integer, String> respuestasUsuario;
    private Map<Integer, String> respuestasCorrectas;
    private Integer cantidadRespuestasCorrectas;
    private String calificacion;

    public Prueba() {
        cantidadRespuestasCorrectas = 0;
        calificacion = "";
        respuestasUsuario = new HashMap<>();
        respuestasCorrectas = new HashMap<>();
        respuestasCorrectas.put(1, "b) Confidencialidad");
        respuestasCorrectas.put(2, "b) Usar más de un método de verificación para acceder al sistema");
        respuestasCorrectas.put(3, "b) Restringir a los usuarios únicamente a las funciones necesarias para realizar su trabajo");
        respuestasCorrectas.put(4, "b) Falta de sanitización en la entrada del usuario");
        respuestasCorrectas.put(5, "b) Codificar correctamente las entradas del usuario al renderizarlas");
        respuestasCorrectas.put(6, "a) Control de acceso basado en roles (RBAC)");
        respuestasCorrectas.put(7, "b) Usar un algoritmo hash con sal (salted hashing)");
        respuestasCorrectas.put(8, "b) Un encabezado que especifica qué recursos pueden cargarse en una página web");
        respuestasCorrectas.put(9, "b) Para minimizar la superficie de ataque");
        respuestasCorrectas.put(10, "b) Documentarla y solucionarla lo antes posible");
        respuestasCorrectas.put(11, "b) Implementar un sistema de revisión periódica para identificar amenazas y actividades sospechosas en tiempo real");
        respuestasCorrectas.put(12, "b) ISO/IEC 27001");
        respuestasCorrectas.put(13, "a) Uso de cookies inseguras sin bandera HttpOnly");
        respuestasCorrectas.put(14, "c) Ataque DDoS - Usar un balanceador de carga o WAF");
        respuestasCorrectas.put(15, "b) Usar tokens únicos que se validen en cada solicitud");
    }

    public String getNombre() {
        if (nombre == null) {
            return "";
        }
        return nombre;
    }

    public void calculateRate() {
        cantidadRespuestasCorrectas = 0;

        respuestasUsuario.forEach((k, v) -> {
            if (v.equals(respuestasCorrectas.get(k))) {
                cantidadRespuestasCorrectas++;
            }
        });

        BigDecimal bd = BigDecimal.valueOf((cantidadRespuestasCorrectas.doubleValue() / respuestasCorrectas.size() * 100));
        // calificacion.set(bd.setScale(2, BigDecimal.ROUND_FLOOR).doubleValue());
        calificacion = "Calificación: " + new DecimalFormat("##.##").format(bd);
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getCantidadRespuestasCorrectas() {
        return cantidadRespuestasCorrectas;
    }

    public void setCantidadRespuestasCorrectas(Integer cantidadRespuestasCorrectas) {
        this.cantidadRespuestasCorrectas = cantidadRespuestasCorrectas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<Integer, String> getRespuestas() {
        return respuestasUsuario;
    }

    public Map<Integer, String> getRespuestasCorrectas() {
        return respuestasCorrectas;
    }
}
