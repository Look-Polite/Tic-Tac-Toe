public class moveresult {
    private boolean success = false;
    private int xcord = -1;
    private int ycord = -1;

    public void sucset(boolean tf){
        success = tf;
    }

    public void xset(int num){
        xcord = num;
    }

    public void yset(int num){
        ycord = num;
    }

    public boolean getsuc(){
        return success;
    }

    public int getx(){
        return xcord;
    }

    public int gety(){
        return ycord;
    }
}
