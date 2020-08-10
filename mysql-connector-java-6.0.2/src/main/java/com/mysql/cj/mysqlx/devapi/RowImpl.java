/*
  Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA

 */

package com.mysql.cj.mysqlx.devapi;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Supplier;

import com.mysql.cj.api.result.Row;
import com.mysql.cj.core.exceptions.DataReadException;
import com.mysql.cj.core.io.BigDecimalValueFactory;
import com.mysql.cj.core.io.BooleanValueFactory;
import com.mysql.cj.core.io.ByteValueFactory;
import com.mysql.cj.core.io.DbDocValueFactory;
import com.mysql.cj.core.io.DoubleValueFactory;
import com.mysql.cj.core.io.IntegerValueFactory;
import com.mysql.cj.core.io.LongValueFactory;
import com.mysql.cj.core.io.StringValueFactory;
import com.mysql.cj.x.json.DbDoc;

public class RowImpl implements com.mysql.cj.api.x.Row {
    private Row row;
    private Supplier<Map<String, Integer>> lazyFieldNameToIndex;

    public RowImpl(Row row, Supplier<Map<String, Integer>> lazyFieldNameToIndex) {
        this.row = row;
        this.lazyFieldNameToIndex = lazyFieldNameToIndex;
    }

    /**
     * Map a field name to it's index in the row.
     *
     * @throws DataReadException
     *             if the field name is not in the row
     */
    private int fieldNameToIndex(String fieldName) {
        Integer idx = this.lazyFieldNameToIndex.get().get(fieldName);
        if (idx == null) {
            throw new DataReadException("Invalid column");
        }
        return idx;
    }

    public BigDecimal getBigDecimal(String fieldName) {
        return getBigDecimal(fieldNameToIndex(fieldName));
    }

    public BigDecimal getBigDecimal(int pos) {
        return this.row.getValue(pos, new BigDecimalValueFactory());
    }

    public boolean getBoolean(String fieldName) {
        return getBoolean(fieldNameToIndex(fieldName));
    }

    public boolean getBoolean(int pos) {
        return this.row.getValue(pos, new BooleanValueFactory());
    }

    public byte getByte(String fieldName) {
        return getByte(fieldNameToIndex(fieldName));
    }

    public byte getByte(int pos) {
        return this.row.getValue(pos, new ByteValueFactory());
    }

    public DbDoc getDbDoc(String fieldName) {
        return getDbDoc(fieldNameToIndex(fieldName));
    }

    public DbDoc getDbDoc(int pos) {
        return this.row.getValue(pos, new DbDocValueFactory());
    }

    public double getDouble(String fieldName) {
        return getDouble(fieldNameToIndex(fieldName));
    }

    public double getDouble(int pos) {
        return this.row.getValue(pos, new DoubleValueFactory());
    }

    public int getInt(String fieldName) {
        return getInt(fieldNameToIndex(fieldName));
    }

    public int getInt(int pos) {
        return this.row.getValue(pos, new IntegerValueFactory());
    }

    public long getLong(String fieldName) {
        return getLong(fieldNameToIndex(fieldName));
    }

    public long getLong(int pos) {
        return this.row.getValue(pos, new LongValueFactory());
    }

    public String getString(String fieldName) {
        return getString(fieldNameToIndex(fieldName));
    }

    public String getString(int pos) {
        // TODO: charset
        return this.row.getValue(pos, new StringValueFactory());
    }
}
