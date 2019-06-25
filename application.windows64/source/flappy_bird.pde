import java.util.Random;
Pipe pipe;
Bird bird;
void setup(){
  size(400,600);
  background(0);
  Random rand = new Random();
  int gap = rand.nextInt(60)+90;
  int gapY = rand.nextInt(height-gap);
  pipe = new Pipe(gap,gapY);
  bird = new Bird();
}
void draw(){
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
void keyPressed(){
  if(key == ' '){
    bird.jump();
  }
}
