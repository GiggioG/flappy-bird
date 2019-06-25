import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Random; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class flappy_bird extends PApplet {


Pipe pipe;
Bird bird;
public void setup(){
  
  background(0);
  Random rand = new Random();
  int gap = rand.nextInt(60)+90;
  int gapY = rand.nextInt(height-gap);
  pipe = new Pipe(gap,gapY);
  bird = new Bird();
}
public void draw(){
  background(0);
  fill(255);
  stroke(255);
  for(int i = 0;i < 2;i++){
    pipe.update();
    pipe.show();
    if(pipe.x+pipe.w < 0){
      Random rand = new Random();
      int gap = rand.nextInt(60)+90;
      int gapY = rand.nextInt(height-gap);
      pipe = new Pipe(gap,gapY);
    }
  }
  bird.show();
  bird.update();
  bird.fall();
  if(bird.hits(pipe)){
    pipe.x = 0 - 1 - pipe.w;
  }
}
public void keyPressed(){
  if(key == ' '){
    bird.jump();
  }
}
class Bird{
  int x = width/2-width/4;
  float y = height / 2;
  float speed = 0;
  float gravity = 0.6f;
  public void update(){
    speed += gravity;
  }
  public void fall(){
    if(y < height - 10 - speed){
      y += speed;
    }
  }
  public void jump(){
    speed = -10;
  }
  public void show(){
    fill(255,255,0);
    stroke(255,255,0);
    rect(x-10,y-10,20,20);
  }
  public boolean hits(Pipe pipe){
      if(x+10 <=pipe.x+pipe.w && x+10 >= pipe.x){
        if((y-10<=pipe.gapY) || (y+10>=pipe.gapY+pipe.gap)){
          return true;
        }
      }
      return false;
  }
}
class Pipe{
  int gap;
  int gapY;
  int x = width;
  int w = 5;
  Pipe(int gap,int gapY){
    this.gap = gap;
    this.gapY = gapY;
  }
  public void show(){
    rect(x,0,w,gapY);
    rect(x,gapY+gap,w,height-gapY-gap);
  }
  public void update(){
    this.x --;
  }
}
  public void settings() {  size(400,600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "flappy_bird" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
