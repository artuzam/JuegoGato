import javax.swing.*;
public class Gato{
  
  String tablero [][] = new String[3][3];
  int matriz [][] = new int[3][3];
  String jugador1= "";
  String jugador2= "";
  int fila = 0;
  int columna = 0;
  
  public String getNombreX(){
    return jugador1;
  }
  public String getNombreO(){
    return jugador2;
  }

}