package dk.sdu.cbse.player;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.GameKeys;
import dk.sdu.cbse.common.data.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerControlSystemTest {

    private PlayerControlSystem playerSystem;
    private GameData gameData;
    private World world;
    private Entity player;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        playerSystem = new PlayerControlSystem();
        gameData = new GameData();
        world = new World();

        player = new Player();
        player.setRadius(10);
        player.setX(100);
        player.setY(100);
        player.setRotation(0);

        world.addEntity(player);
    }

    @Test
    void turnPlayerLeft(){

        gameData.getKeys().setKey(GameKeys.LEFT, true);

        double originalRotation = player.getRotation();
        playerSystem.process(gameData, world);
        double newRotation = player.getRotation();

        assertTrue(newRotation < originalRotation, "Rotation should decrease when turning left");

    }

    @Test
    void turnPlayerRight(){
        gameData.getKeys().setKey(GameKeys.RIGHT, true);

        double originalRotation = player.getRotation();
        playerSystem.process(gameData, world);
        double newRotation = player.getRotation();

        assertTrue(newRotation > originalRotation, "Rotation should increase when turning right");
    }


}