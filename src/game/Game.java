package game;

import stage.JixelGame;

public class Game extends JixelGame{

	private static final int width = 640;
	private static final int height = width / 4 * 3; // 480
	private static final int tileSize = 32;
	
	Player player;
	Enemy test;

	public Game() {
		super("Game", width, height, 1, tileSize, 60, 20);
		
		player = new Player("res/you.png", "Player", width/2, height/2, 5);
		test = new Enemy("res/evil.png", "Evil", width/2+5*tileSize, height/2, 5, false);
		getEntityList().add(player);
		getEntityList().add(test);
		getScreen().lockOn(player);
		getVM().newVar("name", "Sebastien");
	}
	
	boolean lockOnPlayer = true;
	@Override
	public void update() {
		if(getInput().key1){
			lockOnPlayer = !lockOnPlayer;
			if(lockOnPlayer){
				getScreen().lockOn(player);
			}else{
				getScreen().lockOn(test);
			}
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
	}
}