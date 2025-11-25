import javax.swing.JOptionPane;

public class Año {
    public static void main(String[] args) {
        int N = 0;
        boolean ok = false;

        while (!ok) {
            String entrada = JOptionPane.showInputDialog("Cuántos años quiere verificar?");
            if (entrada == null) return;
            try {
                N = Integer.parseInt(entrada);
                if (N >= 1 && N <= 100) ok = true;
                else JOptionPane.showMessageDialog(null, "Número fuera de rango (1-100).");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }
        }

        for (int i = 1; i <= N; i++) {
            int año = -1;
            ok = false;
            while (!ok) {
                String entrada = JOptionPane.showInputDialog("Ingrese el año " + i + ":");
                if (entrada == null) return;
                try {
                    año = Integer.parseInt(entrada);
                    if (año >= 0) ok = true;
                    else JOptionPane.showMessageDialog(null, "El año no puede ser negativo.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                }
            }

            boolean esBisiesto = false;
            if (año % 4 == 0) {
                if (año % 100 == 0) {
                    if (año % 400 == 0) esBisiesto = true;
                } else {
                    esBisiesto = true;
                }
            }

        String mensaje = "El año " + año + " ";
            mensaje += esBisiesto ? "es bisiesto." : "no es bisiesto.";

            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}