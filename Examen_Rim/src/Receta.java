/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rim
 */
public class Receta {

    private String nombrePizza;
    private double diametro;
    private int valorEnergitico;
    private int altura;
    private int temperatura;
    private int tiempo;
    private String OtrosDatos;
// constructor de copia

    public Receta(Receta r) throws RecetaException {
        if (RecetaException.validarNombreReceta(r.getNombrePizza())) {
            this.nombrePizza = r.getNombrePizza();

        } else {
            throw new RecetaException("El nombre del Receta no tiene un valor válido:" + nombrePizza);
        }
    
        if (RecetaException.validarvalorEnergitico(r.getValorEnergitico())) {
            this.valorEnergitico = r.getValorEnergitico();

        } else {
            throw new RecetaException("El ValorEnergitico del Receta no tiene un valor válido:" +valorEnergitico);
        }
          if (RecetaException.validaraltura(r.getAltura())) {
            this.altura= r.getAltura();

        } else {
            throw new RecetaException("El altura del Receta no tiene un valor válido:" +altura);
        }
    }

    public String getNombrePizza() {
        return nombrePizza;
    }

    public double getDiametro() {
        return diametro;
    }

    public int getValorEnergitico() {
        return valorEnergitico;
    }

    public int getAltura() {
        return altura;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getOtrosDatos() {
        return OtrosDatos;
    }

    /**
     *
     *
     * if (ClienteParkingException.validarNombreClienteParking(c.getNombre())) {
     * this.nombre = c.getNombre(); } else { throw new
     * ClienteParkingException("El nombre del cliente no tiene un valor válido:"
     * + nombre); }
        *
     */


// contructor con todos los parametros
public Receta(String nombrePizza, double diametro, int valorEnergitico, int altura, int temperatura, int tiempo, String OtrosDatos) {
        this.nombrePizza = nombrePizza;
        this.diametro = diametro;
        this.valorEnergitico = valorEnergitico;
        this.altura = altura;
        this.temperatura = temperatura;
        this.tiempo = tiempo;
        this.OtrosDatos = OtrosDatos;
    }

}
