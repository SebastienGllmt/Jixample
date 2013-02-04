package game;

import jixel.gui.JixelSprite;
import jixel.stage.JixelGame;

public class Game extends JixelGame {

	private static final int width = 640;
	private static final int height = width / 4 * 3; // 480
	private static final int tileSize = 32;

	private Player player;
	private Enemy test;

	public Game() {
		super("Game", width, height, 1, tileSize, 60);
		player = new Player("res/you.png", "Player", 10, 8, .5, 1, 5);
		test = new Enemy("res/evil.png", "Evil", 14, 10, 1, 1, 5);
		getEntityList().add(player);
		getEntityList().add(test);
		getScreen().lockOn(player);
		getVM().newVar("name", "Sebastien");
		getMap().setSpriteSheet(new JixelSprite("res/tiles.png"));
		getMap().loadLevel("res/map.jixmap");
	}

	boolean lockOnPlayer = true;
	double delay = 0;

	@Override
	public void update() {
		if (delay < 1) {
			delay += 0.1;
		}
		if (getKeyInput().key1) {
			if (delay >= 1) {
				delay = 0;
				lockOnPlayer = !lockOnPlayer;
				if (lockOnPlayer) {
					getScreen().lockOn(player);
				} else {
					getScreen().lockOn(test);
				}
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
	}
}