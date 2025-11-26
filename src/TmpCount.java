public class TmpCount {
    static int count = 0;

    static public int getTmp(){
        return count++;
    }

    static public int returnTmp(){
        return count--;
    }
}
