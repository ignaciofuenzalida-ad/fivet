/*
 * MIT License
 *
 * Copyright (c) 2020 Ignacio Fuenzalida Veas
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
 *
 */

package cl.ucn.disc.pdis.fivet.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * The Persona class.
 *
 */


@DatabaseTable(tableName = "persona")
public final class Persona {

    /**
     * the id: Primary key autoincrement.
     */
    @DatabaseField(generatedId = true)
    private Long id;

    /**
     * The nombre.
     */
    @DatabaseField(canBeNull = false)
    private String nombre;

    /**
     * The Apellido
     */
    @DatabaseField(canBeNull = false)
    private String apellido;

    /**
     * Run
     */
    @DatabaseField(canBeNull = false, index = true)
    private String run;

    /**
     * Empty Constructor, for test
     */
    Persona(){
        //nothing here.
    }



    /**
     * The constructor
     * @param nombre
     * @param apellido
     * @param run
     */
    public Persona(String nombre, String apellido, String run) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.run = run;
    }

    /**
     * Get id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Get nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Get apellido
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Get run
     * @return run
     */
    public String getRun() {
        return run;
    }
}
