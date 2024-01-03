import java.util.Random;

public  class Etudiant extends Ecole implements Runnable {
    @Override
    public void run() {
        synchronized (Ecole.class) {
            for (int i = 0; i < 3; i++) {
                while (Num_seance == -1) {
                    try {
                        Ecole.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                signature();
                Afficher_Num(Num_seance);
                Afficher_Seance(Seance_type);

                // Reset Num_seance to -1
                Num_seance = -1;
                Ecole.class.notifyAll();
            }
        }
    }

    @Override
    void signature() {
        System.out.println("Signature Etudiant: " + Thread.currentThread().getId());
    }

    @Override
    int Avoir_Num() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    @Override
    String Avoir_Seance_N(int num) {
        return null; // Non utilisé pour les étudiants
    }
    @Override
    public void Afficher_Num(int num) {
        System.out.println("Numéro de séance (Etudiant): " + num);
    }

    @Override
    public void Afficher_Seance(String seanceType) {
        System.out.println("Séance (Etudiant): " + seanceType);
    }
}