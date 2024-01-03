import java.util.Random;

public  class Secretaire extends Ecole implements Runnable {
    @Override
    public void run() {
        synchronized (Ecole.class) {
            for (int i = 0; i < 5; i++) {
                Num_seance = Avoir_Num();
                Ecole.class.notifyAll();

                while (Num_seance != -1) {
                    try {
                        Ecole.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    void signature() {
        System.out.println("Signature Secretaire: " + Thread.currentThread().getId());
    }

    @Override
    int Avoir_Num() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    @Override
    String Avoir_Seance_N(int num) {
        return null; // Non utilisé pour le secrétaire
    }
    @Override
    public void Afficher_Num(int num) {
        System.out.println("Numéro de séance (Secretaire): " + num);
    }

    @Override
    public void Afficher_Seance(String seanceType) {
        System.out.println("Séance (Secretaire): " + seanceType);
    }
}

