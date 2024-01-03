public  class Enseignant extends Ecole implements Runnable {
    @Override
    public void run() {
        synchronized (Ecole.class) {
            for (int i = 0; i < 5; i++) {
                while (Num_seance == -1) {
                    try {
                        Ecole.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Seance_type = Avoir_Seance_N(Num_seance);

                // Reset Num_seance to -1
                Num_seance = -1;
                Ecole.class.notifyAll();
            }
        }
    }

    @Override
    void signature() {
        System.out.println("Signature Enseignant: " + Thread.currentThread().getId());
    }

    @Override
    int Avoir_Num() {
        return 0; // Non utilisé pour les enseignants
    }

    @Override
    String Avoir_Seance_N(int num) {
        switch (num) {
            case 1:
                return "séance : Cours";
            case 2:
                return "séance : TD";
            case 3:
                return "séance : TP";
            default:
                return "";
        }
    }
    @Override
    public void Afficher_Num(int num) {
        System.out.println("Numéro de séance (Enseignant): " + num);
    }

    @Override
    public void Afficher_Seance(String seanceType) {
        System.out.println("Séance (Enseignant): " + seanceType);
    }
}

