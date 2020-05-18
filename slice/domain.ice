/*
 * MIT License
 *
 * Copyright (c) 2020 Diego Urrutia-Astorga <durrutia@ucn.cl>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// https://doc.zeroc.com/ice/3.7/language-mappings/java-mapping/client-side-slice-to-java-mapping/customizing-the-java-mapping
["java:package:cl.ucn.disc.pdis.fivet.zeroice"]
module model {

    /**
     * Clase Persona
     */
     class Persona{

        /**
         * Primary Key
         */
        int id;

        /**
         * Rut: 193982336
         */
        string rut;

        /**
         * Nombre
         */
        string nombre;

        /*
         * Apellido
         */
        string apellido;

        /**
         * Direccion
         */
        string direccion;

        /**
         * Telefono fijo
         */
        long telefonoFijo;

        /**
         * Telefono movil
         */
        long telefonoMovil;

        /**
         * Correo electronico
         */
         string email;


     }

     /**
       * Sexo del animal
       */
     enum Sexo {
        MACHO,HEMBRA
     };

     /**
      * Tipo de paciente
      */
     enum TipoPaciente {
     INTERNO, EXTERNO
     };

     /**
      * La ficha
      */
     class Ficha {

         /**
          * Primary Key
          */
         int id;

         /**
          * Numero de  cha
          */
         int numeroFicha;

         /**
          * Especie
          */
         string especie;

         /**
          * Fecha nacimiento
          */
         string fechaNacimiento;

         /**
          * Raza
          */
         string raza;

         /**
          * Sexo
          */
         Sexo sexo;

         /**
          * Color
          */
         string color;

         /**
          * Tipo
          */
         TipoPaciente tipo;



     }

     /**
       * El control
       */
     class Control {

        /**
         * ID ficha
         */
        int id;

        /**
         * Fecha del contorl
         */
        string fechaControl;

        /**
         * Fecha proximo control
         */
        string fechaProximoControl;

        /**
         * Temperatura en °C
         */
        int temperatura;

        /**
         * Peso
         */
        int peso;

        /**
         * Altura
         */
        int altura;

        /**
         * Diagnostico
         */
        string diagnostico;

        /**
         * Nombre del veterinario
         */
        string nombreVeterinario;




     }

     /**
      * La Foto
      */
     class Foto{

        /**
          * Ficha Id
          */
        string fichaId;

        /**
         * URL foto
         */
        string urlFoto;

     }

     /**
      * El examen
      */
     class Examen{

        /**
         * ID del control
         */
        int controlId;

        /**
         * Nombre del Examen
         */
        string nombreExamen;


        /**
         * Fecha del examen
         */
        string fechaExamen;


     }

     /**
      * Interfaz de Contratos
      */
     interface Contratos {

        /**
         * Ingreado un numero de ficha, se retorna la ficha asociada.
         * @param numero numero entero asociado a la ficha
         * @return Ficha la ficha asociada
         */
        Ficha obtenerFicha(int numero);

        /**
         * Ingreado datos de un paciente creando una nueva ficha.
         * @param ficha objeto ficha por agregar
         * @return bool confirmacion
         */
        bool registrarFicha(Ficha ficha);

        /**
         * Ingreado datos de un un nuevo dueño.
         * @param persona objeto persona por agregar
         * @return bool confirmacion
         */
        bool registrarDuenio(Persona persona);

        /**
         * Registro de un nuevo control.
         * @param control objeto control por agregar
         * @return bool confirmacion
         */
        bool registrarControl(Control control);

        /**
         * Ingreso de una foto
         * @param foto objeto foto por agregar
         * @return bool confirmacion de la foto.
         */
        bool agregarFoto(Foto foto);


     }

    /**
     * The base system.
     */
     interface TheSystem {

        /**
         * @return the diference in time between client and server.
         */
        long getDelay(long clientTime);

     }

}
