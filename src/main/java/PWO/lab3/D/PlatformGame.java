package PWO.lab3.D;

public class PlatformGame {
    private Level level;
    private GameMap gameMap;
    private List<Platform> platforms;
    private Player player;
    private List<Opponent> opponents;
    private List<Treasure> treasures;
    private double score;
    private String playerName;
    private Image avatar;

    public PlatformGame(String playerName, Level level, GameMap gameMap, Player player, List<Opponent> opponents, List<Treasure> treasures) {
        this.level = level;
        this.gameMap = gameMap;
        this.player = player;
        this.opponents = opponents;
        this.treasures = treasures;
        this.playerName = playerName;
        this.score = 0;
        this.avatar = new Avatar(this.playerName); // Still depends on Avatar class
        this.platforms = new ArrayList<>();
        initializePlatforms();
    }

    private void initializePlatforms() {
        for (int i = 0; i < 200; i++) {
            platforms.add(new GroundPlatform(Colour.BROWN));
        }
    }

    public void changeLevel() {
        if (level instanceof FirstLevel) {
            level = new SecondLevel("Advanced level");
        } else if (level instanceof SecondLevel) {
            level = new ThirdLevel("Expert level");
        }
    }

    public void movePlayer(int direction) {
        player.move(direction);
    }


    public static class GroundPlatform {
        // Implementation details
    }

    public class BlackSoldier implements Opponent {
        public void attack() {
            // Attack logic
        }
    }

    public class FirstLevel implements Level {
        private String description;

        public FirstLevel(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // Implement other Level and GameMap classes similarly
    public class EuropeMap implements GameMap {
        private String background;

        public EuropeMap(String background) {
            this.background = background;
        }

        public String getBackground() {
            return background;
        }
    }

    public class GreenSoldier implements Player {
        public void move(int direction) {
            // Movement logic
        }

        public void stop() {
            // Stop logic
        }
    }


    public interface Level {
        String getDescription();
    }

    public interface GameMap {
        String getBackground();
    }

    public interface Player {
        void move(int direction);

        void stop();
    }

    public interface Opponent {
        void attack();
    }

    public interface Treasure {
        int getValue();
    }

    public interface Level {
        String getDescription();
    }

    public interface GameMap {
        String getBackground();
    }

    public interface Player {
        void move(int direction);
        void stop();
    }

    public interface Opponent {
        void attack();
    }

    public interface Treasure {
        int getValue();
    }
}

