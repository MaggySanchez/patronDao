package org.example;

import java.util.Date;

public class Paciente {

        private String nombre;
        private String apellido;
        private String domicilio;
        private Long dni;
        private Date fechaDeAlta;
        private String username;
        private String password;


        public Paciente(String nombre, String apellido, String domicilio, Long dni, Date fechaDeAlta, String username, String password) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.domicilio = domicilio;
            this.dni= dni;
            this.fechaDeAlta = fechaDeAlta;
            this.username = username;
            this.password = password;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setDomicilio(String domicilio) {
            this.domicilio = domicilio;
        }

        public void setDni(Long dni) {
            this.dni = dni;
        }

    public java.sql.Date getFechaDeAlta() {
        return (java.sql.Date) fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getDomicilio() {
            return domicilio;
        }

        public Long getDni() {
            return dni;
        }



        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", dni=" + dni +
                ", fechaDeAlta=" + fechaDeAlta +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


