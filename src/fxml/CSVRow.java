/*
The MIT License (MIT)

Copyright (c) 2016 Douglas Nassif Roma Junior

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package fxml;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Douglas
 */
public class CSVRow {

    private final List<SimpleStringProperty> columns;

    public CSVRow() {
        this.columns = new ArrayList<>();
    }

    public CSVRow(List<SimpleStringProperty> columns) {
        this.columns = columns;
    }

    public List<SimpleStringProperty> getColumns() {
        return columns;
    }

    public void addColumn(int index, String value) {
        if (index <= columns.size()) {
            columns.add(index, new SimpleStringProperty(value));
        }
    }

    public void addColumn(int index) {
        addColumn(index, "");
    }

    boolean isEmpty() {
        if (columns == null || columns.isEmpty()) {
            return true;
        }
        for (SimpleStringProperty prop : columns) {
            if (!prop.getValueSafe().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "CSVRow: " + columns;
    }

    void removeColumn(int index) {
        if (index < columns.size()) {
            columns.remove(index);
        }
    }
}
