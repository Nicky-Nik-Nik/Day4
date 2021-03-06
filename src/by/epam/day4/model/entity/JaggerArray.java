package by.epam.day4.model.entity;

import java.util.Arrays;

public class JaggerArray {
    IntegerArray[] jaggerIntegerArray;

    public JaggerArray(int rows) {
        jaggerIntegerArray = new IntegerArray[rows];
    }

    public JaggerArray(int rows, int cols) {
        jaggerIntegerArray = new IntegerArray[rows];
        for (int i = 0; i < rows; i++) {
            jaggerIntegerArray[i] = new IntegerArray(cols);
        }
    }

    public JaggerArray(IntegerArray... jaggerIntegerArray){
        setJaggerArray(jaggerIntegerArray);
    }

    public int size() {
        return jaggerIntegerArray.length;
    }

    public IntegerArray[] getJaggerArray() {
        return jaggerIntegerArray.clone();
    }

    public void setJaggerArray(IntegerArray[] jaggerIntegerArray) {
        this.jaggerIntegerArray = jaggerIntegerArray;
    }

    public IntegerArray getElement(int row) {
        if (row >= jaggerIntegerArray.length || row < 0) {
            throw new IndexOutOfBoundsException("invalid row index");
        }
        IntegerArray result = new IntegerArray(jaggerIntegerArray[row].getArr());
        return result;
    }

    public int getElement(int row, int col) {
        if (row >= jaggerIntegerArray.length || row < 0) {
            throw new IndexOutOfBoundsException("invalid row index");
        }
        if (col >= getElement(row).size() || col < 0) {
            throw new IndexOutOfBoundsException("invalid col index");
        }

        return jaggerIntegerArray[row].getElement(col);
    }

    public void setElement(int row, IntegerArray integerArray) {
        if (row >= jaggerIntegerArray.length || row < 0) {
            throw new IndexOutOfBoundsException("invalid row index");
        }
        jaggerIntegerArray[row] = integerArray;
    }

    public void setElement(int row, int col, int value) {
        if (row >= jaggerIntegerArray.length || row < 0) {
            throw new IndexOutOfBoundsException("invalid row index");
        }
        if (col >= getElement(row).size() || col < 0) {
            throw new IndexOutOfBoundsException("invalid col index");
        }
        jaggerIntegerArray[row].setElement(col, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaggerArray that = (JaggerArray) o;
        return Arrays.equals(getJaggerArray(), that.getJaggerArray());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getJaggerArray());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JaggerArray{").append("\n");
        for (IntegerArray integerArray : jaggerIntegerArray) {
            sb.append(integerArray).append("\n");
        }
        sb.append('}');
        return sb.toString();
    }

}
