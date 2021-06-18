package spacesurvival.utilities.path;

import java.nio.file.Paths;

public final class Weapon {

    /**
     * Path of fire weapon.
     */
    public static final String FIRE = Paths.get(MainFolder.WEAPON, "fire.png").toString();

    /**
     * Path of electric weapon.
     */
    public static final String ELECTRIC = Paths.get(MainFolder.WEAPON, "electric.png").toString();

    /**
     * Path of ice weapon.
     */
    public static final String ICE = Paths.get(MainFolder.WEAPON, "ice.png").toString();

    /**
     * Path of normal weapon.
     */
    public static final String NORMAL = Paths.get(MainFolder.WEAPON, "normal.png").toString();

    private Weapon() {

    }

}
