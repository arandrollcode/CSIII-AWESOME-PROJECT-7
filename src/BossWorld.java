import mayflower.*;

public class BossWorld extends World {
    private Tiles[][] tiles;
    private Finish finish;
    private Boss boss;
    private MovableAnimatedActor player;

    public BossWorld() {
        Mayflower.showBounds(false);
        setBackground("src/img/BG/BG2.png");
        Mayflower.stopMusic("src/sounds/music/music.mp3");
        Mayflower.playMusic("src/sounds/music/boss.mp3");
        player = StartScreen.getPlayer();

        tiles = new Tiles[6][8];

        tiles[0][3] = Tiles.BOSS;

        for (int i = 0; i < tiles[0].length; i++) {
            tiles[5][i] = Tiles.BLOCK;
        }
        tiles[1][1] = Tiles.BLOCK;
        tiles[1][6] = Tiles.BLOCK;
        tiles[3][0] = Tiles.BLOCK;
        tiles[3][7] = Tiles.BLOCK;
        tiles[4][1] = Tiles.BLOCK;
        tiles[4][6] = Tiles.BLOCK;
        tiles[4][7] = Tiles.HAZARD;

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                if (tiles[i][j] == null)
                    continue;

                Actor tileObject = null;
                if (tiles[i][j] == Tiles.BLOCK) {
                    tileObject = new Block();
                } else if (tiles[i][j] == Tiles.BLOCKLEFT) {
                    tileObject = new BlockLeft();
                } else if (tiles[i][j] == Tiles.BLOCKRIGHT) {
                    tileObject = new BlockRight();
                } else if (tiles[i][j] == Tiles.COIN) {
                    tileObject = new Coin();
                } else if (tiles[i][j] == Tiles.FINISH) {
                    finish = new Finish();
                    tileObject = finish;
                } else if (tiles[i][j] == Tiles.MOVINGBLOCK) {
                    tileObject = new MovingBlock();
                } else if (tiles[i][j] == Tiles.BOSS) {
                    boss = new Boss();
                    tileObject = boss;
                } else if (tiles[i][j] == Tiles.HAZARD) {
                    tileObject = new Hazard(1.2, 1.2);
                }

                if (tileObject != null)
                    addObject(tileObject, j * 100, (i * 100));
            }
        }

        addObject(player, 300, 400);

        Platform.setIsMovingDown(false);
    }

    public void act() {
        if (boss.getHealth() <= 0) {
            Mayflower.setWorld(new WinScreen());
        }

    }

}
