package game;

import jixel.stage.JixelGame;

public class Player extends JixampleEntity {

	public Player(final String PATH, final String ANIM_PATH, String name, int tileX, int tileY, double friction, double acceleration, double maxSpeed) {
		super(PATH, ANIM_PATH, name, tileX, tileY, friction, acceleration, maxSpeed);
	}

	@Override
	public void update() {
		if(JixelGame.getKeyInput().up ||
				JixelGame.getKeyInput().down ||
				JixelGame.getKeyInput().left ||
				JixelGame.getKeyInput().right){
			playAnim("Walk");
		}else{
			playAnim("Stand");
		}
		if (JixelGame.getKeyInput().right) {
			this.setFlipH(false);
			setSpeedX(getSpeedX() + getAcceleration());
		}else if (JixelGame.getKeyInput().left) {
			this.setFlipH(true);
			setSpeedX(getSpeedX() - getAcceleration());
		}
		if (JixelGame.getKeyInput().up) {
			setSpeedY(getSpeedY() - getAcceleration());
		}else if (JixelGame.getKeyInput().down) {
			setSpeedY(getSpeedY() + getAcceleration());
		}
		super.update();
	}

}
