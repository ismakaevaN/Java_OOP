package ru.geekbrains.java_core.lesson1;

public interface Mover {

    default void run() {
        System.out.println(" бежит");
    }

    default void jump() {
        System.out.println(" прыгает");
    }
    //максимальная длина
    float getMaxLength();
    //максимальная высота
    float getMaxHigh();

    String getName();
}
