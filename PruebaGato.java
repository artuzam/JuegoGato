import javax.swing.*;
public class PruebaGato{
  public static void main(String args[]){
    Gato g = new Gato();
    int opcion = 0;
    g.pedirNombreX();
    g.pedirNombreO();
    int ganesX = 0;
    int ganesO = 0;
    int empates = 0;
    do{
      g.iniciarTablero();
      boolean continuar = false;
      g.convertirTablero();
      g.imprimir();
      int contador = 0;
      int turnos = 1;
      do{
        if(turnos%2 != 0){
          do{
            g.pedirPosicion(g.getNombreX());
            if(!g.modificarTablero(7))
            {
              JOptionPane.showMessageDialog(null, "La posición está ocupada\n", "Gato", JOptionPane.QUESTION_MESSAGE);
            }
          }while(g.modificarTablero(7));
        }
        else{
          do{
            g.pedirPosicion(g.getNombreO());
            if(!g.modificarTablero(1))
            {
              JOptionPane.showMessageDialog(null, "La posición está ocupada\n", "Gato", JOptionPane.QUESTION_MESSAGE);
            }
          } while(g.modificarTablero(1));
        }
        
        g.convertirTablero();
        g.imprimir();
        if(g.verificarGanador().equals("no")){
          continuar = true;
        }
        else{
          JOptionPane.showMessageDialog(null, g.verificarGanador() , "Gato", JOptionPane.QUESTION_MESSAGE);
          continuar = false;
          if(g.verificarGanador().equals("Gana: " + g.getNombreX())){
            ganesX++;
          }
          if(g.verificarGanador().equals("Gana: " + g.getNombreO())){
            ganesO++;
          }
        }
        if(contador == 8){
          JOptionPane.showMessageDialog(null, "No hubo ganador", "Gato", JOptionPane.QUESTION_MESSAGE);
          empates++;
        }
        turnos++;
        contador++;
      }while(continuar && contador <= 8);
      
      //mostrar estadisticas
      JOptionPane.showMessageDialog(null, "Ganes de "+g.getNombreX()+": "+ ganesX +"\n" + "Ganes de "+g.getNombreO()+": "+ ganesO +"\n" + "Empates: "+ empates +"\n", "Gato/Estadísticas", JOptionPane.QUESTION_MESSAGE);
      
      String entrada=JOptionPane.showInputDialog(null, "Digite una opción:\n1.Jugar de nuevo\n2.Cambiar jugador con la X\n3.Cambiar jugador con la O\n4.Salir.", "Gato", JOptionPane.QUESTION_MESSAGE);
      try{
        opcion=Integer.parseInt(entrada);
      }
      catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "El formato de número es inválido", "Gato", JOptionPane.INFORMATION_MESSAGE );
        System.exit(1);
      }  
      switch(opcion){
        case 1:
          JOptionPane.showMessageDialog(null, "Creando juego nuevo", "Gato", JOptionPane.INFORMATION_MESSAGE );
          break;
          
        case 2:
          g.pedirNombreX();
          ganesX = 0;
          ganesO = 0;
          empates = 0;
          break;
          
        case 3:
          g.pedirNombreO();
          ganesX = 0;
          ganesO = 0;
          empates = 0;
          break;
          
        case 4:
          System.exit(0);
          break; 
      } 
    }while(opcion == 1 || opcion == 2 || opcion == 3);
  }
}