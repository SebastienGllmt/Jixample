package game;

import jixel.entity.JixelEntity;

public class JixampleEntity extends JixelEntity {

	private double friction, acceleration, maxSpeed;
	private double[] speed = new double[2];

	public JixampleEntity(String PATH, String name, int x, int y, double friction, double acceleration, double maxSpeed) {
		super(PATH, name, x, y, acceleration);
		this.friction = friction;
		this.acceleration = acceleration;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public void update() {
		for (int i = 0; i < 2; i++) {
			if (speed[i] > 0) {
				speed[i] -= friction;
				if (speed[i] < 0) {
					speed[i] = 0;
				}else if (speed[i] > maxSpeed) {
					speed[i] = maxSpeed;
				}
			} else if (speed[i] < 0) {
				speed[i] += friction;
				if (speed[i] > 0) {
					speed[i] = 0;
				}else if (speed[i] < -maxSpeed) {
					speed[i] = -maxSpeed;
				}
			}
		}
		setX((int) (getX() + speed[0]));
		setY((int) (getY() + speed[1]));
	}

	/**
	 * @return the speedX
	 */
	public double getSpeedX() {
		return speed[0];
	}

	/**
	 * @param speedX the speedX to set
	 */
	public void setSpeedX(double speedX) {
		this.speed[0] = speedX;
	}

	/**
	 * @return the speedY
	 */
	public double getSpeedY() {
		return speed[1];
	}

	/**
	 * @param speedY the speedY to set
	 */
	public void setSpeedY(double speedY) {
		this.speed[1] = speedY;
	}

	/**
	 * @return the acceleration
	 */
	public double getAcceleration() {
		return acceleration;
	}

	/**
	 * @param acceleration the acceleration to set
	 */
	public void setAcceleration(double acceleration) {
		this.acceleration = acceleration;
	}

	/**
	 * @return the maxSpeed
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

}
