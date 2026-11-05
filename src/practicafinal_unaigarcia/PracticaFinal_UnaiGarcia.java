package practicafinal_unaigarcia;

import view.View;

/**
 *
 * @author unaig
 */
public class PracticaFinal_UnaiGarcia {

    public static void main(String[] args) throws Exception {
        View v = new View();

        v.cargaArchivos();
        v.runMenu();
        v.save();
    }

}
