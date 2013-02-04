package game;

import jixel.stage.JixelGame;

public class Player extends JixampleEntity {

	public Player(String PATH, String name, int tileX, int tileY, double friction, double acceleration, double maxSpeed) {
		super(PATH, name, tileX, tileY, friction, acceleration, maxSpeed);
	}

	@Override
	public void update() {
		if (JixelGame.getKeyInput().right) {
			setSpeedX(getSpeedX() + getAcceleration());
		}
		if (JixelGame.getKeyInput().left) {
			setSpeedX(getSpeedX() - getAcceleration());
		}
		if (JixelGame.getKeyInput().up) {
			setSpeedY(getSpeedY() - getAcceleration());
		}
		if (JixelGame.getKeyInput().down) {
			setSpeedY(getSpeedY() + getAcceleration());
		}
		super.update();
	}

}
