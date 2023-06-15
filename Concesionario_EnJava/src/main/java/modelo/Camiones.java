
package modelo;

public class Camiones extends Padre {
   private int capacidadCarga;
   private Poseer aireAcondiconado;
   private Poseer frenosAire;
   private Poseer abs;
   private int numeroEjes;
   private TipoCamion tipoCamion;

   public Camiones(byte[]foto,int capacidadCarga, Poseer aireAcondiconado, Poseer frenosAire, Poseer abs, int numeroEjes, TipoCamion tipoCamion, int matricula, String marca, int modelo, int cilindraje, EstadoUso estadoUso, Combustible combustible, int velocidadMax, int cambios, Transmision transmision, int numeroPasajeros, int numeroPuertas, int numeroBolsaAire, Poseer poseer, Poseer camaraReserva, Poseer aireAcondicionado) {
      super(foto,matricula, marca, modelo, cilindraje, estadoUso, combustible, velocidadMax, cambios, transmision, numeroPasajeros, numeroPuertas, numeroBolsaAire, poseer, camaraReserva, aireAcondicionado);
      this.abs = abs;
      this.tipoCamion = tipoCamion;
      this.capacidadCarga = capacidadCarga;
      this.aireAcondiconado = aireAcondiconado;
      this.frenosAire = frenosAire;
      this.numeroEjes = numeroEjes;
   }
}
