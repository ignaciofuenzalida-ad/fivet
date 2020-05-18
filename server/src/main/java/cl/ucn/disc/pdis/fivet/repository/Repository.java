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

import java.sql.SQLException;
import java.util.List;

public interface Repository<T,ID> {

    /**
     * Create an entity into database's table.
     * @param entity the new to add.
     */
    void create(T entity) throws SQLException;

    /**
     * Delete an entity from the database's table.
     * @param id primary key of the entity.
     */
    void delete(ID id) throws SQLException;

    /**
     * Update an entity from the database's table.
     * @param entity to update.
     */
    void update(T entity) throws SQLException;

    /**
     * Get an entity from the database's table.
     * @param id primary key of the entity.
     * @return a T entity.
     */
    T findById(ID id) throws SQLException;

    /**
     * Get all entities from the database's table.
     * @return a list of T entities.
     */
    List<T> getAll() throws SQLException;


}
