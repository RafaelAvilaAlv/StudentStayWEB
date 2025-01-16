package com.studentstay.app.Entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "calificaciones")
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCalificacion;

    private Integer puntaje; // Ejemplo: 1-5
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHabitaciones", nullable = false)
    private Habitaciones habitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstudiante", nullable = false)
    private Estudiante estudiante;

    private Date fechaCalificacion;

    // Getters y Setters
    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Date getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(Date fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }
}
