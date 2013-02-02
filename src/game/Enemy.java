package game;

import entity.JixelEntity;

public class Enemy extends JixelEntity{

	public Enemy(String PATH, String name, int x, int y, int speed, boolean controllable) {
		super(PATH, name, x, y, speed, controllable);
	}

	@Override
	public void update() {
		
	}

	
}
