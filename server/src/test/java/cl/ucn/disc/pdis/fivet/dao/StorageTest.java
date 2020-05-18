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

package cl.ucn.disc.pdis.fivet.dao;

import cl.ucn.disc.pdis.fivet.models.Persona;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public final class StorageTest {

    /**
     * The logger.
     */
    private static final Logger log = LoggerFactory.getLogger(StorageTest.class);

    /**
     * Tesing the ORMLite + H2 (database)
     */
    @Test
    public void testDatabase() throws SQLException {

        // The databse to use (in RAM memory)
        String dataBaseURL = "jdbc:h2:mem:fivet_db";

        // Connectionsource: autoclose with try/catch
        try (ConnectionSource connectionSource = new JdbcConnectionSource(dataBaseURL)) {

            //Create the table from Persona Class Annotations
            TableUtils.createTableIfNotExists(connectionSource, Persona.class);

            //Dao of Persona
            Dao<Persona, Long> daoPersona = DaoManager.createDao(connectionSource,Persona.class);

            //The persona
            Persona persona = new Persona("Ignacio","Fuenzalida","19398233");

            // Insert Persona into the database
            int tuples = daoPersona.create(persona);
            log.debug("Id: {}",persona.getId());

            Assertions.assertEquals(1,tuples,"Save tuples !=1");

            //Get from DB
            Persona personaDb = daoPersona.queryForId(persona.getId());

            Assertions.assertEquals(persona.getNombre(),personaDb.getNombre(),"Names are equals?");
            Assertions.assertEquals(persona.getApellido(),personaDb.getApellido(),"Surname are equals?");
            Assertions.assertEquals(persona.getRun(),personaDb.getRun(),"Ruts are equals?");

            //Search by rut: Select * FROM  'persona' WHERE 'rut' = '19398233'
            List<Persona> personaList = daoPersona.queryForEq("run","19398233");
            Assertions.assertEquals(persona.getRun(),personaDb.getRun(),"Runs are equals?");

            //Not found rut
            Assertions.assertEquals(0,daoPersona.queryForEq("run","19").size(),"Found somethings?");

        } catch (IOException e){
            log.error("Error", e);
        }


    }

}
