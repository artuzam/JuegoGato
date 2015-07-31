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
    String f=JOptionPane.showInputDialog(null, nombre+":\n"+"Ingrese la fila \n(numero entre 1 y 3)", "Gato", JOptionPane.QUESTION_MESSAGE);
    String c=JOptionPane.showInputDialog(null, nombre+":\n"+"Ingrese la columna\n(numero entre 1 y 3)", "Gato", JOptionPane.QUESTION_MESSAGE);
    fila=Integer.parseInt(f);
    if(fila < 4){
      fila--;}
    else {
      String x=JOptionPane.showInputDialog(null, nombre+":\n"+"Numero invalido.Ingrese la fila", "Gato", JOptionPane.QUESTION_MESSAGE);
      fila=Integer.parseInt(x);
    }  
    columna=Integer.parseInt(c);
    if (columna < 4){
    columna--;
    }
    else {
    String y=JOptionPane.showInputDialog(null, nombre+":\n"+"Numero invalido.Ingrese la columna", "Gato", JOptionPane.QUESTION_MESSAGE);
    columna=Integer.parseInt(y);
    }
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
  
  public String verificarGanador(){
    String s="no";
    int suma=0;
    boolean ganador=false;
    for(int i=0; i<matriz.length && !ganador;i++)
    {
      suma=matriz[i][0]+matriz[i][1]+matriz[i][2];
      if(suma==3)
      {
        s="Gana: " + getNombreO();
        ganador=true;
      }
      if(suma==21)
      {
        s="Gana: " + getNombreX();
        ganador=true;
      }
    }
    
    for(int i=0; i<matriz.length && !ganador;i++)
    {
      suma=matriz[0][i]+matriz[1][i]+matriz[2][i];
      if(suma==3)
      {
        s="Gana: " + getNombreO();
        ganador=true;
      }
      if(suma==21)
      {
        s="Gana: " + getNombreX();
        ganador=true;
      }
    }
    suma=matriz[0][0]+matriz[1][1]+matriz[2][2];
    if(suma==3)
    {
      s="Gana: " + getNombreO();
      ganador=true;
    }
    if(suma==21)
    {
      s="Gana: " + getNombreX();
      ganador=true;
    }
    
    suma=matriz[0][2]+matriz[1][1]+matriz[2][0];
    if(suma==3)
    {
      s="Gana: " + getNombreO();
      ganador=true;
    }
    if(suma==21)
    {
      s="Gana: " + getNombreX();
      ganador=true;
    }
    return s;
  }
  
  public void imprimir(){
    System.out.println("Estado del tablero");
    for (int i=0; i < tablero.length; i++) {
      System.out.print("| ");
      for (int j=0; j < tablero[i].length; j++) {
        System.out.print(tablero[i][j]+ " | ");
      }
      System.out.println();
    }
  }
  
  public void imprimira(){
    System.out.println("Estado del tablero");
    for (int i=0; i < matriz.length; i++) {
      System.out.print("| ");
      for (int j=0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j]+ " | ");
      }
      System.out.println();
    }
  }
}


