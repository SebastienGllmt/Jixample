package game;

import java.awt.Color;

import jixel.gui.JixelSprite;
import jixel.stage.JixelGame;

public class Game extends JixelGame {

	private static final int width = 640;
	private static final int height = width / 4 * 3; // 480
	private static final int tileSizeLog2 = 5;

	private Player player;
	private Enemy test;

	public Game() {
		super("Game", width, height, 1, tileSizeLog2, 60);
		player = new Player("res/you.png", "res/you.anim", "Player", 10, 8, .5, 1, 5);
		test = new Enemy("res/evil.png", null, "Evil", 14, 10, 1, 1, 5);
		getEntityManager().add(player);
		getEntityManager().add(test);
		getScreen().getCamera().setLockedEntity(player);
		String name = "Sebastien";
		getVM().newVar("name", name);
		getCamera().getMap().setSpriteSheet(new JixelSprite("res/tiles.png"));
		getCamera().getMap().loadLevel("res/map.jixmap");
	}

	private boolean lockOnPlayer = true;

	private boolean newKeyState = false;
	
	@Override
	public void update() {
		if(!getKeyInput().key1){
			newKeyState = true;
		}
		if (getKeyInput().key1 && newKeyState) {
			newKeyState = false;
			lockOnPlayer = !lockOnPlayer;
			if (lockOnPlayer) {
				getCamera().setLockedEntity(player);
			} else {
				getCamera().setLockedEntity(test);
			}
		}
		if(getKeyInput().key2){
			getCamera().setMaxSize(width-(width>>2), height-(height>>2));
			getCamera().setMinSize(width>>2, height>>2);
		}
		if(getKeyInput().key3){
			getCamera().setMaxSize(width, height);
			getCamera().setMinSize(0, 0);
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
	}

	@Override
	public void closeOperation() {
	}
}