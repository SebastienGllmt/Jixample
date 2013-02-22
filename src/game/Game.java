package game;

import java.awt.Color;

import jixel.entity.JixelEntityManager;
import jixel.gui.JixelCamera;
import jixel.gui.JixelMap;
import jixel.gui.JixelSprite;
import jixel.stage.JixelGame;

public class Game extends JixelGame {

	private static final int width = 640;
	private static final int height = width / 4 * 3; // 480
	private static final int tileSizeLog2 = 5;
	private static final int tileSize = 32;
	private static final int BORDER = 5;
	private Player player;
	private Enemy enemy;

	public Game() {
		super("Jixample", width, height, tileSizeLog2, 1000);

		getKeyInput().addKey("Up", 38);
		getKeyInput().addKey("Down", 40);
		getKeyInput().addKey("Left", 37);
		getKeyInput().addKey("Right", 39);
		getKeyInput().addKey("Action", 'z');
		getKeyInput().addKey("Attack", 'x');

		getScreen().setScale(1, 1);

		JixelMap gameMap = new JixelMap();
		gameMap.setSpriteSheet(new JixelSprite("res/tiles.png", 32, 32));
		gameMap.loadLevel("res/map.jixmap");

		player = new Player("res/you.png", "res/you.anim", "Player", tileSize, tileSize, 10 * tileSize, 8 * tileSize, .5, 1, 5);
		enemy = new Enemy("res/evil.png", null, "Evil", tileSize, tileSize, 14 * tileSize, 10 * tileSize, 1, 1, 5);
		JixelEntityManager entityManager = new JixelEntityManager();
		entityManager.add(player);
		entityManager.add(enemy);

		JixelCamera screen1 = new GameScreen(BORDER, BORDER, (width >> 1) - BORDER, (height >> 1) - BORDER);
		screen1.setMap(gameMap);
		screen1.setLockedEntity(player);
		screen1.setEntityManager(entityManager);

		JixelCamera screen2 = new GameScreen((width >> 1) + BORDER, BORDER, width - BORDER, (height >> 1) - BORDER);
		screen2.setMap(gameMap);
		screen2.setLockedEntity(enemy);
		screen2.setEntityManager(entityManager);

		JixelCamera screen3 = new GameScreen(BORDER, (height >> 1) + BORDER, (width >> 1) - BORDER, height - BORDER);
		screen3.setMap(gameMap);
		screen3.setLockedEntity(enemy);
		screen3.setEntityManager(entityManager);

		JixelCamera screen4 = new GameScreen((width >> 1) + BORDER, (height >> 1) + BORDER, width - BORDER, height - BORDER);
		screen4.setMap(gameMap);
		screen4.setLockedEntity(player);
		screen4.setEntityManager(entityManager);

		getScreen().setBackground(new Color(0, 50, 0));

		getScreen().addCamera(screen1);
		getScreen().addCamera(screen2);
		getScreen().addCamera(screen3);
		getScreen().addCamera(screen4);
	}

	@Override
	public void update() {
		if (getKeyInput().isDownOnce("Action")) {
			//enemy.changeSprite(player);
			System.out.println(getTimer().getLastFrameCount());
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
	}

	@Override
	public void closeOperation() {
	}
}