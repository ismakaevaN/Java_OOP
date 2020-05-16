package ru.geekbrains.java_core.lesson1;

public class Cat implements Mover {
    private float maxLength;
    private float maxHigh;
    private String name;

    public Cat(float maxLength, float maxHigh, String name) {
        this.maxLength = maxLength;
        this.maxHigh = maxHigh;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(" бежит покушать!");

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
