package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;

import java.util.Iterator;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d> {
    private final int[] numberList;
    private final int width;
    private final int howManyGrass;
    private final int totalPosition;

    public RandomPositionGenerator(int width, int howManyGrass) {
        this.width = width;
        this.howManyGrass = howManyGrass;
        this.totalPosition = width * width;
        numberList = new int[totalPosition];
        for(int i = 0; i < width*width; i++){
            numberList[i] = i;
        }
        Random rand = new Random();
        for(int i = 0; i < width*width; i++){
            int swap = rand.nextInt(totalPosition);
            int temp = numberList[swap];
            numberList[swap] = numberList[i];
            numberList[i] = temp;
        }
    }
    @Override
    public Iterator<Vector2d> iterator() {
        return new vectorIterator(width,howManyGrass,numberList);
    }

}

class vectorIterator implements Iterator<Vector2d>{

    private int numberAlready=0;
    private final int howManyGrass;
    private final int totalPosition;
    private final int width;
    private final int[] numberList;

    vectorIterator(int width, int howManyGrass, int[] numberList) {
        this.width = width;
        this.howManyGrass = howManyGrass;
        this.totalPosition = width * width;
        this.numberList = numberList;
    }

    @Override
    public boolean hasNext() {
        return numberAlready<howManyGrass;
    }

    @Override
    public Vector2d next() {
        int temp=numberList[numberAlready];
        numberAlready++;
        return new Vector2d((int) temp/width, (int) temp%width);
    }


}