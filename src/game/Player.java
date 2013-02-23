package game;

import jixel.entity.JixelCollidable;
import jixel.entity.JixelEntity;
import jixel.stage.JixelGame;

public class Player extends JixampleEntity implements JixelCollidable {

	public Player(final String imgPath, String animPath, String name, int width, int height, int x, int y, double friction, double acceleration, double maxSpeed) {
		super(imgPath, animPath, name, width, height, x, y, friction, acceleration, maxSpeed);
	}

	@Override
	public void update() {
		
		if(JixelGame.getKeyInput().isDown("Up") ||
				JixelGame.getKeyInput().isDown("Down") ||
				JixelGame.getKeyInput().isDown("Left") ||
				JixelGame.getKeyInput().isDown("Right")){
			playAnim("Walk");
		}else{
			playAnim("Stand");
		}
		if (JixelGame.getKeyInput().isDown("Right")) {
			this.setFlipH(false);
			setSpeedX(getSpeedX() + getAcceleration());
		}else if (JixelGame.getKeyInput().isDown("Left")) {
			this.setFlipH(true);
			setSpeedX(getSpeedX() - getAcceleration());
		}
		if (JixelGame.getKeyInput().isDown("Up")) {
			setSpeedY(getSpeedY() - getAcceleration());
		}else if (JixelGame.getKeyInput().isDown("Down")) {
			setSpeedY(getSpeedY() + getAcceleration());
		}
		
		super.update();
	}

	@Override
	public void isColliding(JixelEntity e) {
		
	}

	@Override
	public void onHit(JixelEntity e) {
		System.out.println("On hit " + e.getName());
	}

	@Override
	public void onSeparation(JixelEntity e) {
		System.out.println("On separation " + e.getName());
	}

}
