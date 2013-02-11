package game;

public class Enemy extends JixampleEntity{

	public Enemy(final String PATH, final String ANIM_PATH, String name, int tileX, int tileY, double friction, double acceleration, double maxSpeed) {
		super(PATH, ANIM_PATH, name, tileX, tileY, friction, acceleration, maxSpeed);
	}

	@Override
	public void update() {
		
	}

	
}
