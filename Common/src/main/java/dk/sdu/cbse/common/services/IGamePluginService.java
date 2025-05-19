package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IGamePluginService {

    /**
     * Defines a plugin responsible for adding entities to game world when game world start,
     * and removing entities when game world stop.
     *
     * <p><strong>Preconditions:</strong></p>
     * <ul>
     *   <li>{@code gameData} and {@code world} must not be {@code null}</li>
     * </ul>
     *
     * <p><strong>Postconditions:</strong></p>
     * <ul>
     *   <li>After {@code start(...)}: one or more entities may have been added to the world</li>
     *   <li>After {@code stop(...)}: those entities may have been removed from the world</li>
     * </ul>
     *
     * @param gameData
     * @param world
     */

    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}