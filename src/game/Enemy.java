package game;

import jixel.entity.JixelCollidable;
import jixel.entity.JixelEntity;

public class Enemy extends JixampleEntity implements JixelCollidable{

	public Enemy(final String imgPath, String animPath, String name, int width, int height, int x, int y, double friction, double acceleration, double maxSpeed) {
		super(imgPath, animPath, name, width, height, x, y, friction, acceleration, maxSpeed);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void isColliding(JixelEntity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHit(JixelEntity e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSeparation(JixelEntity e) {
		// TODO Auto-generated method stub
		
	}

	
}
