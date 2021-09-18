/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteParking;

/**
 *
 * @author Rim
 */
public class ClienteParking {

    private String nombre;
    private int edad;
    private String telefono;
    private boolean vip;
// constructor de copia

    public ClienteParking() {
    }
        public ClienteParking(ClienteParking c) throws Cliente_ParkingException {
        if (Cliente_ParkingException.validarNombreClienteParking(c.getNombre())) {
            this.nombre = c.getNombre();
        } else {
            throw new Cliente_ParkingException("El nombre del cliente no tiene un valor válido:" + nombre);
        }
        if (Cliente_ParkingException.validarTelefonoClienteParking(c.getTelefono())) {
            this.telefono = c.getTelefono();
        } else {
            throw new Cliente_ParkingException("El teléfono del cliente no tiene un valor válido:" + telefono);
        }
        if (Cliente_ParkingException.validarEdadClienteParking(c.getEdad())) {
            this.edad = c.getEdad();
        } else {
            throw new Cliente_ParkingException("La edad del cliente no tiene un valor válido:" + edad);
        }
        if (Boolean.valueOf(c.vip) != null) {
            this.vip = c.isVip();
        }
    }
//constructor con 4 argumentos

    public ClienteParking(String nombre, int edad, String telefono, boolean vip) throws Cliente_ParkingException {
        if (Cliente_ParkingException.validarNombreClienteParking(nombre)) {
            this.nombre = nombre;
        } else {
            throw new Cliente_ParkingException("El nombre del cliente no tiene un valor válido:" + nombre);
        }
        if (Cliente_ParkingException.validarTelefonoClienteParking(telefono)) {
            this.telefono = telefono;
        } else {
            throw new Cliente_ParkingException("El teléfono del cliente no tiene un valor válido:" + telefono);
        }
        if (Cliente_ParkingException.validarEdadClienteParking(edad)) {
            this.edad = edad;
        } else {
            throw new Cliente_ParkingException("La edad del cliente no tiene un valor válido:" + edad);
        }
        if (Boolean.valueOf(vip) != null) {
            this.vip = vip;
        }
    }
// los getters

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isVip() {
        return vip;
    }

}
