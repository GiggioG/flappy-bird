class Bird{
  int x = width/2-width/4;
  float y = height / 2;
  float speed = 0;
  float gravity = 0.6;
  void update(){
    speed += gravity;
  }
  void fall(){
    if(y < height - 10 - speed){
      y += speed;
    }
  }
  void jump(){
    speed = -10;
  }
  void show(){
    fill(255,255,0);
    stroke(255,255,0);
    rect(x-10,y-10,20,20);
  }
  boolean hits(Pipe pipe){
      if(x+10 <=pipe.x+pipe.w && x+10 >= pipe.x){
        if((y-10<=pipe.gapY) || (y+10>=pipe.gapY+pipe.gap)){
          return true;
        }
      }
      return false;
  }
}
