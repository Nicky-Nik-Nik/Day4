package by.epam.day4.model.service;

import by.epam.day4.model.entity.IntegerArray;
import by.epam.day4.model.entity.JaggerArray;

public class JaggerArrayService {
    private static ArrayServiceAlgorithm arrayServiceAlgorithm = new ArrayServiceAlgorithm();

    public void sortByRowsSum(JaggerArray array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size(); j++) {
                int prevSum = arrayServiceAlgorithm.calculateSum(array.getElement(j - 1));
                int nowSum = arrayServiceAlgorithm.calculateSum(array.getElement(j));
                if (nowSum < prevSum) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public void sortByRowsSum(JaggerArray array, boolean reversed){
        sortByRowsSum(array);
        if (reversed){
            reverse(array);
        }
    }

    public void swap(JaggerArray array, int row, int row1) {
        IntegerArray temp = array.getElement(row);
        array.setElement(row, array.getElement(row1));
        array.setElement(row1, temp);
    }

    public void reverse(JaggerArray array) {
        for (int i = 0; i < array.size() / 2; i++) {
            swap(array, i, array.size() - 1 - i);
        }
    }

    public void sortByMaxElement(JaggerArray array){
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size(); j++) {
                int prevMax = arrayServiceAlgorithm.findMax(array.getElement(j - 1));
                int nowMax = arrayServiceAlgorithm.findMax(array.getElement(j));
                if (nowMax < prevMax) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public void sortByMaxElement(JaggerArray array, boolean reversed){
        sortByMaxElement(array);
        if (reversed){
            reverse(array);
        }
    }

    public void sortByMinElement(JaggerArray array){
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size(); j++) {
                int prevMin = arrayServiceAlgorithm.findMin(array.getElement(j - 1));
                int nowMin = arrayServiceAlgorithm.findMin(array.getElement(j));
                if (nowMin > prevMin) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public void sortByMinElement(JaggerArray array, boolean reversed){
        sortByMinElement(array);
        if (reversed){
            reverse(array);
        }
    }

}
