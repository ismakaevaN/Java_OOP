package ru.geekbrains.java_core.lesson1;

public class Treadmill implements Obstacles {
    private float length;

    public Treadmill(float length) {
        this.length = length;
    }

    @Override
    public boolean overcoming(Mover mover) {
        //проверить что у mover'а хватает сил пробежать дорожку
        if(length<=mover.getMaxLength()){
            System.out.println(mover.getName() +" успешно пробежал");
            return true;
        } else{
            System.out.println(mover.getName() + " не смог пробежать");
            return false;
        }
    }
}
