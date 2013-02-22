package game;

public class Enemy extends JixampleEntity{

	public Enemy(final String imgPath, String animPath, String name, int width, int height, int x, int y, double friction, double acceleration, double maxSpeed) {
		super(imgPath, animPath, name, width, height, x, y, friction, acceleration, maxSpeed);
	}

	@Override
	public void update() {
		
	}

	
}
