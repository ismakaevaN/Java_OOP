package ru.geekbrains.java_core.lesson1;

public class Main {
    public static void main(String[] args) {
        Mover[] movers = new Mover[]{
                new Cat(4500f, 1,"Max"),
                new Human(1000f, 0.4f,"Vika"),
                new Robot(5000f, "Amigo",3.2f),
                new Cat(0.5f, 0,"Jastina")};
        Obstacles[] obstaclesList = new Obstacles[]{
                new Treadmill(1f),
                new Treadmill(3000f),
                new Wall(1),
                new Wall(3)
        };
        for (int i = 0; i < movers.length; i++) {
            int j = 0;
            boolean goNext = true;
            while (j < obstaclesList.length && goNext) {
                goNext =  obstaclesList[j].overcoming(movers[i]);
                j++;
            }
        }
    }
}
