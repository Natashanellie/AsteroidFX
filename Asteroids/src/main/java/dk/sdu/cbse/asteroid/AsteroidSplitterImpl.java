package dk.sdu.cbse.asteroid;

import dk.sdu.cbse.common.asteroids.Asteroid;
import dk.sdu.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.World;

import java.util.Random;

public class AsteroidSplitterImpl implements IAsteroidSplitter {


    private int threshold = 3;

    @Override
    public void createSplitAsteroid(Entity e, World w) {

        float asteroidRadius = e.getRadius();
        // checking if asteroid is under threshold size
        if (asteroidRadius <= threshold){
            w.removeEntity(e);
            return;
        }
        // splitting Asteroid into 2
        for (int i = 0; i < 2 ; i++){
            int newSize = (int)(e.getRadius() / 2);
            Asteroid fragment = new Asteroid();
            fragment.setRadius(newSize);
            fragment.setX(e.getX());
            fragment.setY(e.getY());
            fragment.setRotation(new Random().nextInt(360));
            fragment.setPolygonCoordinates(newSize, -newSize, -newSize, -newSize, -newSize, newSize, newSize, newSize);

            w.removeEntity(e);
            w.addEntity(fragment);
        }

    }
}
