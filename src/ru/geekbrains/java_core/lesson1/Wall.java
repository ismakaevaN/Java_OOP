package ru.geekbrains.java_core.lesson1;

public class Wall implements Obstacles {
    public Wall(float high) {
        this.high = high;
    }

    private float high;
    @Override
    public boolean overcoming(Mover currentMover) {
        if(high<=currentMover.getMaxHigh()){
            System.out.println(currentMover.getName() +" успешно перепрыгнул");
            return true;
        } else{
            System.out.println(currentMover.getName() +" не смог перепрыгнуть");
            return false;
        }
    }
}
