package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     * Defines a service that controls the entities behavior during game loop.
     *
     * <p><strong>Preconditions:</strong></p>
     * <ul>
     *   <li>{@code gameData} and {@code world} are not {@code null}</li>
     * </ul>
     *
     * <p><strong>Postconditions:</strong></p>
     * <ul>
     *   <li>One or more entities in the {@code world} may have updated state (e.g., position, rotation)</li>
     * </ul>
     *
     * @param gameData
     * @param world
     */

    void process(GameData gameData, World world);
}