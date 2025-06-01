import dk.sdu.cbse.common.services.IPostEntityProcessingService;

module Collision {
    requires Common;
    requires CommonAsteroids;
    requires CommonBullet;
    requires CommonShips;


    uses dk.sdu.cbse.common.asteroids.IAsteroidSplitter;
    provides IPostEntityProcessingService with dk.sdu.cbse.collision.CollisionDetector;
}