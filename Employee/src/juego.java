/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rim
 */

import static java.lang.Math.random;// en pythone sintaxis  import random

public class juego {
    
//Este es el juego de adivinar el número. comentario en pythone con #

    int intentosRealizados  = 0;

    public juego() {
    }

    public int getIntentosRealizados() {
        return intentosRealizados;
    }
public static llamas(){

 miNombre = input()


 número = random.randint(1, 20)

 print('Bueno, ' + miNombre + ', estoy pensando en un número entre 1 y 20.')


 while intentosRealizados < 6:

   print('Intenta adivinar.') # Hay cuatro espacios delante de print.

  estimación = input()

   estimación = int(estimación)



 intentosRealizados = intentosRealizados + 1
 if estimación < número:

  print('Tu estimación es muy baja.') # Hay ocho espacios delante de print.



 if estimación > número:

 print('Tu estimación es muy alta.')



if estimación == número:

      break


if estimación == número:

intentosRealizados = str(intentosRealizados)

print('¡Buen trabajo, ' + miNombre + '! ¡Has adivinado mi número en ' + intentosRealizados + ' intentos!')



 if estimación != número:

número = str(número)

print('Pues no. El número que estaba pensando era ' + número)
    
}
