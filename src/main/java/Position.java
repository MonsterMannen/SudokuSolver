public class Position {
    private int y = 0;
    private int x = 0;

    public int getY(){
        return y;
    }

    public int getX(){
        return x;
    }

    public boolean next(){
        x++;
        if(x > 8){
            x = 0;
            y++;
            if(y > 8){
                return false;
            }
        }
        return true;
    }

    public boolean prev(){
        x--;
        if(x < 0){
            x = 8;
            y--;
            if(y < 0){
                return false;
            }
        }
        return true;
    }
}
