import processing.core.PApplet;

public class Pong extends PApplet{

// Variaveis

private float x, y, speedX, speedY;
private float size = 40;
private float rectSize = 150;

// Setup

public void settings() {
  fullScreen();
  reset();
}

// Começar novamente

public void reset() {
  x = width/2;
  y = height/2;
  speedX = random(5, 10);
  speedY = random(5, 10);
}

// Draw = loop

public void draw() { 
  background(255,255,255);
  
  ellipse(x, y, size, size);
  fill(255, 0, 0);
  rect(0, 0, 20, height);
  rect(width-20, mouseY-rectSize/2, 10, rectSize);

  x += speedX;
  y += speedY;

  //  Colisão com o quadrado
  
  if ( x > width-30 && x < width -20 && y > mouseY-rectSize/2 && y < mouseY+rectSize/2 ) {
    speedX = speedX * -1;
  } 

  // Colisão com a parede esquerda

  if (x < 25) {
    speedX *= -1.1;
    speedY *= 1.1;
    x += speedX;
  }


  // Colisão com bottom e top

  if ( y > height || y < 0 ) {
    speedY *= -1;
  }
  noStroke();
}

// Ao clicar reseta o jogo

public void mousePressed() {
  reset();
}
	

// Main
public static void main(String[] args){
    String[] processingArgs = {"Pong"};
    PApplet.main(processingArgs);
  }
}
