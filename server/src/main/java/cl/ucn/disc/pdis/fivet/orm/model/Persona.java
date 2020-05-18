/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.pdis.fivet.orm.model;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * The Persona class.
 *
 *
 */


@DatabaseTable(tableName = "persona")
public class Persona {

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
     * Apellido
     */
    @DatabaseField(canBeNull = false)
    private String apellido;

    /**
     * Run
     */
    @DatabaseField(canBeNull = false, index = true)
    private String run;

    /**
     * Empty constructor
     */
    Persona(){

    }




}
