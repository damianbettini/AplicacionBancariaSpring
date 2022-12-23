package org.example.Entidades;

public class Persona {
        protected String nombre;
        protected String apellido;

        protected int edad;
        protected String direccion;

        protected Integer numeroCelular;
        protected String correo;


        public Persona (){}

        public Persona(String nombre, String apellido, int edad, String direccion, Integer numeroCelular, String correo) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad= edad;
            this.direccion = direccion;
            this.numeroCelular = numeroCelular;
            this.correo = correo;
        }

        public String getName() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public Integer getNumeroCelular() {
            return numeroCelular;
        }

        public void setNumeroCelular(Integer numeroCelular) {
            this.numeroCelular = numeroCelular;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "name='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", edad=" + edad +
                    ", direccion='" + direccion + '\'' +
                    ", numeroCelular=" + numeroCelular +
                    ", correo='" + correo + '\'' +
                    '}';
        }
}

