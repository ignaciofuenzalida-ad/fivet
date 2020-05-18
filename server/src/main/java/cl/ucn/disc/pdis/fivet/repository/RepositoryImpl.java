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

package cl.ucn.disc.pdis.fivet.repository;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

public class RepositoryImpl<T,ID> implements Repository<T,ID> {

    private final Dao<T,ID> dao;


    /**
     * The constructor of dao.
     * @param connectionSource The connection URL source.
     * @param dataClass the class needed to make the table.
     */
    public RepositoryImpl(ConnectionSource connectionSource, Class<T> dataClass) throws SQLException {

        try {

            // Create table from the T class
            TableUtils.createTableIfNotExists(connectionSource,dataClass);
            this.dao = DaoManager.createDao(connectionSource,dataClass);


        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    /**
     * Insert a new entity into the database.
     * @param entity the entity class.
     * @throws SQLException the error whe it try to do the operation.
     */
    @Override
    public void create(T entity) throws SQLException {

        this.dao.create(entity);

    }

    /**
     * Delete an element of the database by Id.
     * @param id the primary key of the table.
     * @throws SQLException the error whe it try to do the operation.
     */
    @Override
    public void delete(ID id) throws SQLException {

        this.dao.deleteById(id);

    }

    /**
     * Update an element of the database.
     * @param entity the entity class.
     * @throws SQLException the error whe it try to do the operation.
     */
    @Override
    public void update(T entity) throws SQLException {

        this.dao.update(entity);

    }

    /**
     * Get an element from the database by an Id.
     * @param id the primary key of the table.
     * @return the T class.
     * @throws SQLException the error whe it try to do the operation.
     */
    @Override
    public T findById(ID id) throws SQLException {

        return this.dao.queryForId(id);

    }

    /**
     * Get all elements of the database.
     * @return a List of T elements.
     * @throws SQLException the error whe it try to do the operation.
     */
    @Override
    public List<T> getAll() throws SQLException {

        return this.dao.queryForAll();

    }
}
