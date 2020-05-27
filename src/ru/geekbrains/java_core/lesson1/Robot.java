package ru.geekbrains.java_core.lesson1;

public class Robot implements Mover {
    private float maxLength;
    private String name;
    private float maxHigh;


    public Robot(float maxLength, String name, float maxHigh) {
        this.maxLength = maxLength;
        this.name = name;
        this.maxHigh = maxHigh;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public float getMaxLength() {
        return maxLength;
    }

    @Override
    public float getMaxHigh() {
        return maxHigh;
    }
}
