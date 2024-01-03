public abstract class Ecole implements Institution {
    static int Num_seance = -1;
    static String Seance_type = "";

    abstract void signature();

    abstract int Avoir_Num();

    abstract String Avoir_Seance_N(int num);
}