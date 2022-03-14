int WIDTH = 728;
int HEIGHT = 728;
int BLOCKNUM = 50;
int BLOCKX = WIDTH / (BLOCKNUM + 2);
int BLOCKY = HEIGHT / (BLOCKNUM + 2);

Centro [] centros;
Grupos [] grupos;

class Coord {
   int posX;
   int posY;
   Coord( int pX, int pY ) {
      posX = pX;
      posY = pY;
   }
}

class Centro {
  Coord coord;
  int helicop;
  Centro ( int pX, int pY, int h ) {
    coord = new Coord (pX, pY);
    helicop = h;
  } 
}

class Grupos {
  Coord coord;
  int personas;
  int prioridad;
  Grupos ( int pX, int pY, int p, int pr ) {
    coord = new Coord ( pX, pY );
    personas = p;
    prioridad = pr;
  }
}

int isCentro ( int posX, int posY ) {
  for ( int i = 0; i < centros.length; ++i ) {
     if ( centros[i].coord.posX == posX && centros[i].coord.posY == posY ) return 1;
  }
  return 0;
}

int isGrupo ( int posX, int posY ) {
  for ( int i = 0; i < grupos.length; ++i ) {
     if ( grupos[i].coord.posX == posX && grupos[i].coord.posY == posY ) 
       return grupos[i].prioridad;
  }
  return 0;
}

void introCentros () {
  centros = new Centro[5];
  int index = 0;
  centros[index++] = new Centro(49, 47, 1);
  centros[index++] = new Centro(35, 49, 1);
  centros[index++] = new Centro(49, 33, 1);
  centros[index++] = new Centro(46,  0, 1);
  centros[index++] = new Centro( 0,  7, 1);  
}

void introGrupos () {
  grupos = new Grupos[100];
  int index = 0;
  grupos[index++] = new Grupos(23,47,2,2);
  grupos[index++] = new Grupos(38,33,5,2);
  grupos[index++] = new Grupos(4,7,3,2);
  grupos[index++] = new Grupos(49,24,10,2);
  grupos[index++] = new Grupos(26,32,8,2);
  grupos[index++] = new Grupos(47,34,3,1);
  grupos[index++] = new Grupos(20,39,12,2);
  grupos[index++] = new Grupos(44,38,7,1);
  grupos[index++] = new Grupos(5,0,5,2);
  grupos[index++] = new Grupos(10,17,6,2);
  grupos[index++] = new Grupos(21,33,9,2);
  grupos[index++] = new Grupos(46,48,3,1);
  grupos[index++] = new Grupos(24,27,9,1);
  grupos[index++] = new Grupos(35,8,3,2);
  grupos[index++] = new Grupos(15,47,3,1);
  grupos[index++] = new Grupos(37,34,1,1);
  grupos[index++] = new Grupos(18,35,5,1);
  grupos[index++] = new Grupos(4,0,10,2);
  grupos[index++] = new Grupos(14,0,10,2);
  grupos[index++] = new Grupos(23,34,12,1);
  grupos[index++] = new Grupos(9,25,9,2);
  grupos[index++] = new Grupos(21,7,9,1);
  grupos[index++] = new Grupos(4,25,10,2);
  grupos[index++] = new Grupos(0,33,7,2);
  grupos[index++] = new Grupos(41,4,6,1);
  grupos[index++] = new Grupos(37,0,10,2);
  grupos[index++] = new Grupos(7,0,8,2);
  grupos[index++] = new Grupos(5,23,6,1);
  grupos[index++] = new Grupos(15,41,9,2);
  grupos[index++] = new Grupos(7,7,4,1);
  grupos[index++] = new Grupos(6,41,1,2);
  grupos[index++] = new Grupos(29,7,2,1);
  grupos[index++] = new Grupos(40,29,12,2);
  grupos[index++] = new Grupos(5,44,2,1);
  grupos[index++] = new Grupos(10,28,9,1);
  grupos[index++] = new Grupos(4,2,5,2);
  grupos[index++] = new Grupos(45,34,7,1);
  grupos[index++] = new Grupos(17,47,9,1);
  grupos[index++] = new Grupos(20,37,8,1);
  grupos[index++] = new Grupos(27,17,5,1);
  grupos[index++] = new Grupos(48,26,8,1);
  grupos[index++] = new Grupos(13,41,9,2);
  grupos[index++] = new Grupos(6,40,12,1);
  grupos[index++] = new Grupos(28,20,8,1);
  grupos[index++] = new Grupos(24,17,1,2);
  grupos[index++] = new Grupos(28,20,4,2);
  grupos[index++] = new Grupos(37,34,3,2);
  grupos[index++] = new Grupos(2,19,6,2);
  grupos[index++] = new Grupos(15,36,4,2);
  grupos[index++] = new Grupos(44,41,12,1);
  grupos[index++] = new Grupos(11,3,9,2);
  grupos[index++] = new Grupos(19,32,4,2);
  grupos[index++] = new Grupos(14,48,1,2);
  grupos[index++] = new Grupos(46,45,8,2);
  grupos[index++] = new Grupos(18,22,7,1);
  grupos[index++] = new Grupos(40,19,10,2);
  grupos[index++] = new Grupos(31,12,2,1);
  grupos[index++] = new Grupos(24,27,11,2);
  grupos[index++] = new Grupos(46,43,8,1);
  grupos[index++] = new Grupos(1,28,1,2);
  grupos[index++] = new Grupos(9,48,9,2);
  grupos[index++] = new Grupos(46,49,6,1);
  grupos[index++] = new Grupos(8,29,3,1);
  grupos[index++] = new Grupos(9,21,12,2);
  grupos[index++] = new Grupos(27,32,5,2);
  grupos[index++] = new Grupos(10,34,1,1);
  grupos[index++] = new Grupos(44,26,10,2);
  grupos[index++] = new Grupos(27,7,2,1);
  grupos[index++] = new Grupos(10,47,8,1);
  grupos[index++] = new Grupos(47,13,6,1);
  grupos[index++] = new Grupos(36,29,3,2);
  grupos[index++] = new Grupos(7,28,1,1);
  grupos[index++] = new Grupos(25,23,1,1);
  grupos[index++] = new Grupos(36,41,11,2);
  grupos[index++] = new Grupos(42,10,9,1);
  grupos[index++] = new Grupos(7,14,12,2);
  grupos[index++] = new Grupos(6,39,6,1);
  grupos[index++] = new Grupos(49,36,7,1);
  grupos[index++] = new Grupos(25,22,7,1);
  grupos[index++] = new Grupos(30,48,5,2);
  grupos[index++] = new Grupos(29,38,6,2);
  grupos[index++] = new Grupos(34,5,4,2);
  grupos[index++] = new Grupos(28,0,11,2);
  grupos[index++] = new Grupos(41,4,7,1);
  grupos[index++] = new Grupos(48,48,4,1);
  grupos[index++] = new Grupos(25,18,2,1);
  grupos[index++] = new Grupos(10,3,3,1);
  grupos[index++] = new Grupos(36,26,12,2);
  grupos[index++] = new Grupos(14,11,1,2);
  grupos[index++] = new Grupos(8,5,1,2);
  grupos[index++] = new Grupos(28,48,3,2);
  grupos[index++] = new Grupos(43,30,2,1);
  grupos[index++] = new Grupos(28,23,4,1);
  grupos[index++] = new Grupos(4,10,10,1);
  grupos[index++] = new Grupos(6,12,8,2);
  grupos[index++] = new Grupos(21,1,5,2);
  grupos[index++] = new Grupos(21,15,12,1);
  grupos[index++] = new Grupos(26,42,10,1);
  grupos[index++] = new Grupos(17,47,1,1);
  grupos[index++] = new Grupos(20,32,2,2);
}

void setup() {
  size(728, 728);
  introCentros();
  introGrupos();
}

void draw() {
  background(0);
  for (int i = -1; i < BLOCKNUM + 2; i ++) {
    for (int j = -1; j < BLOCKNUM + 2; j ++) {
      if ( isCentro ( i-1, j-1 ) == 1 ) {
        fill ( 255, 0, 0 );  
      }
      else {
        int g = isGrupo(i-1, j-1);
        if ( g == 1 ) fill(0, 255, 0);
        else if ( g == 2 ) fill(0, 0, 255);      
        else if (i == 0 || j == 0 || i == BLOCKNUM + 1 || j == BLOCKNUM + 1) {
          fill(0, 0, 0); // white
        } else {
          fill(255, 255, 255); // black
        }
      }
      rect(i * BLOCKX, j * BLOCKY, (i + 1) * BLOCKX, (j + 1) * BLOCKY);     
    }
  }
}
