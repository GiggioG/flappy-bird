class Pipe{
  int gap;
  int gapY;
  int x = width;
  int w = 5;
  Pipe(int gap,int gapY){
    this.gap = gap;
    this.gapY = gapY;
  }
  void show(){
    rect(x,0,w,gapY);
    rect(x,gapY+gap,w,height-gapY-gap);
  }
  void update(){
    this.x --;
  }
}
