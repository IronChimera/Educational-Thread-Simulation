public class Main {
    public static void main(String[] args) {
        Thread etudiantThread = new Thread(new Etudiant());
        Thread enseignantThread = new Thread(new Enseignant());
        Thread secretaireThread = new Thread(new Secretaire());

        etudiantThread.start();
        enseignantThread.start();
        secretaireThread.start();
    }

    static int Num_seance = -1;
    static String Seance_type = "";
}