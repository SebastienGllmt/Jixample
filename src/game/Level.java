package game;

import java.util.Random;

import gui.JixelMap;

public class Level extends JixelMap {

	private final Random rand = new Random();
	
	public Level(int width, int height) {
		super(width, height);
	}
	
	public void genRandLevel(){
		for(int y=0; y<height; y++){
			for(int x=0; x<width; x++){
				tiles[x+y*width] = rand.nextInt(4);
			}
		}
	}

	
}
