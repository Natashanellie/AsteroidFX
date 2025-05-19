package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IPostEntityProcessingService {

    /**
     * Handles logic used to determine the effects from collisions such as entity health reduction or entity removal
     *
     * <p><strong>Preconditions:</strong></p>
     * <ul>
     *   <li>{@code gameData} and {@code world} are not {@code null}</li>
     *   <li>Entities have already been updated via {@link IEntityProcessingService}</li>
     * </ul>
     *
     * <p><strong>Postconditions:</strong></p>
     * <ul>
     *   <li>Entities may have updated or removed state based on game logic</li>
     *   <li>Side effects such as splitting, health reduction, or destruction may occur</li>
     * </ul>
     *
     * @param gameData
     * @param world
     */

    void process(GameData gameData, World world);
}