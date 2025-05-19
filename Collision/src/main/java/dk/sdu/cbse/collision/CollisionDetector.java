package dk.sdu.cbse.collision;

import dk.sdu.cbse.common.asteroids.Asteroid;
import dk.sdu.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.cbse.common.bullet.Bullet;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.cbse.enemy.Enemy;
import dk.sdu.cbse.player.Player;
import dk.sdu.cbse.common.ships.Ship;

import java.util.ServiceLoader;

public class CollisionDetector implements IPostEntityProcessingService {


    private final IAsteroidSplitter asteroidSplitter;

    public CollisionDetector() {
        this.asteroidSplitter = ServiceLoader.load(IAsteroidSplitter.class)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No AsteroidSplitter implementation found"));
    }

    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    if (entity1 instanceof Asteroid && entity2 instanceof Bullet){
                        asteroidSplitter.createSplitAsteroid(entity1,world);
                        world.removeEntity(entity2);
                    }

                    if (entity1 instanceof Ship && entity2 instanceof Asteroid ){
                        world.removeEntity(entity1);
                    }

                    if (entity1 instanceof Ship && entity2 instanceof Bullet){
                        Ship ship = (Ship) entity1;
                        ship.reduceHealth(1);
                        world.removeEntity(entity2);

                        if (ship.isDead()){
                            world.removeEntity(entity1);
                        }

                    }
                    if (entity1 instanceof Player && entity2 instanceof Enemy){
                        world.removeEntity(entity1);
                        world.removeEntity(entity2);
                        continue;
                    }
                }
            }
        }

    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }

}