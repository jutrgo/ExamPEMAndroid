package es.ulpgc.juan.exampemandroid.model;

import io.realm.RealmObject;

public class Usuario extends RealmObject {

  private int id, valoracion;
  private String nombre, apellidos, profesion, poblacion, dni, fechaNacimiento;
  private int edad;

  public Usuario() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getProfesion() {
    return profesion;
  }

  public void setProfesion(String profesion) {
    this.profesion = profesion;
  }

  public String getPoblacion() {
    return poblacion;
  }

  public void setPoblacion(String poblacion) {
    this.poblacion = poblacion;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public int getValoracion() {
    return valoracion;
  }

  public void setValoracion(int valoracion) {
    this.valoracion = valoracion;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }
}
