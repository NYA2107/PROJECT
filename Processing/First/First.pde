float angle = 0;
int a = 30;
float initialValue = 0;
void setup(){
  size(500,500);
}

void draw(){
   background(0);
   drawMain(a,initialValue);
   initialValue+=mouseY;  
}

void drawMain(int a,float initialValue){
  translate(250, 250);
  
  for(angle = 0 ; angle <= mouseX ; angle+=a){
    rotate(initialValue+angle);
    stroke(255);
    noFill();
    ellipse(0,0,200,50);
    rotate(-(initialValue+angle));
  }
  
  //for(int asu = 0 ; asu <= 90 ; asu+=90){
  //  int b = 0;
  //  initialValue -= b;
  //  rotate(initialValue);
  //  stroke(255);
  //  noFill();
  //  ellipse(0,0,200,50);
  //  b--;
  //}
}