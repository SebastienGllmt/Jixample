package game;

import jixel.stage.JixelGame;

public class Player extends JixampleEntity {

	public Player(String PATH, String name, int x, int y, double friction, double acceleration, double maxSpeed) {
		super(PATH, name, x, y, friction, acceleration, maxSpeed);
	}

	@Override
	public void update() {
		if (JixelGame.getInput().right) {
			setSpeedX(getSpeedX() + getAcceleration());
		}
		if (JixelGame.getInput().left) {
			setSpeedX(getSpeedX() - getAcceleration());
		}
		if (JixelGame.getInput().up) {
			setSpeedY(getSpeedY() - getAcceleration());
		}
		if (JixelGame.getInput().down) {
			setSpeedY(getSpeedY() + getAcceleration());
		}
		super.update();
	}

}
