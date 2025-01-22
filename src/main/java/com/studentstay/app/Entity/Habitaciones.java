package com.studentstay.app.Entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "habitaciones", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "idCategoria", "idHabitaciones" }) })
public class Habitaciones implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitaciones;

    private Double precio;
    private Integer nHabitacion;
    private Integer nPiso;
    private Long idCategoria;

    @Column(name = "descriphabi", columnDefinition = "TEXT")
    private String descriphabi;

    @Column(name = "foto", columnDefinition = "TEXT")
    private String foto;

    private String estado;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idHabitaciones")
    private List<Reservas> reservas;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idHabitaciones")
    private List<Servicio> servicio;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "habitacion")
    private List<Calificacion> calificaciones;

    // Getters y Setters
    public Long getIdHabitaciones() {
        return idHabitaciones;
    }

    public void setIdHabitaciones(Long idHabitaciones) {
        this.idHabitaciones = idHabitaciones;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getnHabitacion() {
        return nHabitacion;
    }

    public void setnHabitacion(Integer nHabitacion) {
        this.nHabitacion = nHabitacion;
    }

    public Integer getnPiso() {
        return nPiso;
    }

    public void setnPiso(Integer nPiso) {
        this.nPiso = nPiso;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<Reservas> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}


    public List<Servicio> getServicio() {
        return servicio;
    }

    public void setServicio(List<Servicio> servicio) {
        this.servicio = servicio;
    }

    public String getDescriphabi() {
        return descriphabi;
    }

    public void setDescriphabi(String descriphabi) {
        this.descriphabi = descriphabi;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
