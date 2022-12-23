package org.example.Entidades;

public class Cliente extends Persona{

        private Integer numeroTarjeta;
        private Integer numeroCliente;
        private String usuario;
        private String clave;
        private Integer montoTarjeta;

        public Cliente (){}



        public Cliente(String nombre, String apellido, int edad, String direccion, Integer numeroCelular, String correo, Integer numeroTarjeta, Integer numeroCliente, String usuario, String clave, Integer montoTarjeta) {
            super(nombre, apellido, edad, direccion, numeroCelular, correo);
            this.numeroTarjeta = numeroTarjeta;
            this.numeroCliente = numeroCliente;
            this.usuario = usuario;
            this.clave = clave;
            this.montoTarjeta = montoTarjeta;
        }

        public Integer getNumeroTarjeta() {
            return numeroTarjeta;
        }

        public void setNumeroTarjeta(Integer numeroTarjeta) {
            this.numeroTarjeta = numeroTarjeta;
        }

        public Integer getNumeroCliente() {
            return numeroCliente;
        }

        public void setNumeroCliente(Integer numeroCliente) {
            this.numeroCliente = numeroCliente;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getClave() {
            return clave;
        }

        public void setClave(String clave) {
            this.clave = clave;
        }

        public Integer getMontoTarjeta() {
            return montoTarjeta;
        }

        public void setMontoTarjeta(Integer montoTarjeta) {
            this.montoTarjeta = montoTarjeta;
        }

        @Override
        public String toString() {
            return "Cliente{" +
                    "numeroTarjeta=" + numeroTarjeta +
                    ", numeroCliente=" + numeroCliente +
                    ", usuario='" + usuario + '\'' +
                    ", clave='" + clave + '\'' +
                    ", montoTarjeta=" + montoTarjeta +
                    '}';
        }
}


