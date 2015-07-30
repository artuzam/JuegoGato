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
  
  public void iniciarTablero(){
    for (int i=0; i < tablero.length; i++) {
      for (int j=0; j < tablero[i].length; j++) {
        tablero[i][j] = " ";
      }
    }
    for (int i=0; i < matriz.length; i++) {
      for (int j=0; j < matriz[i].length; j++) {
        matriz[i][j] = 0;
      }
    }
  }
  
  public boolean modificarTablero(int jugador)
  {
    boolean d= false;
    if(matriz[fila][columna]==0)
    {
      matriz[fila][columna]=jugador;
      d= true;
    }
    return d;
  }
  
  public void pedirNombreX(){
    jugador1=JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador que utilizará la X\n", "Gato", JOptionPane.QUESTION_MESSAGE);
  }
  public void pedirNombreO()
  {
    jugador2=JOptionPane.showInputDialog(null, "Ingrese el nombre del jugador que utilizará la O\n", "Gato", JOptionPane.QUESTION_MESSAGE);
  }
  
  public void pedirPosicion(String nombre){
    String f=JOptionPane.showInputDialog(null, nombre+":\n"+"Ingrese la fila", "Gato", JOptionPane.QUESTION_MESSAGE);
    String c=JOptionPane.showInputDialog(null, nombre+":\n"+"Ingrese la columna\n", "Gato", JOptionPane.QUESTION_MESSAGE);
    fila=Integer.parseInt(f);
    fila--;
    columna=Integer.parseInt(c);
    columna--;
  }
  
  public void convertirTablero(){
    for (int i=0; i < tablero.length; i++) {
      for (int j=0; j < tablero[i].length; j++) {
        if(matriz[i][j]==0)
        {
          tablero[i][j]= " ";
        }
        if(matriz[i][j]==7)
        {
          tablero[i][j]= "X";
        }
        if(matriz[i][j]==1)
        {
          tablero[i][j]= "O";
        }
        
      }
    }
  }
  
  
 
}