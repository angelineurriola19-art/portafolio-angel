import javax.swing.JOptionPane;

public class salario {
    public static void main(String[] args) {
        int N = 0;
        boolean ok = false;
        while (!ok) {
            String entrada = JOptionPane.showInputDialog("Ingrese el número de trabajadores:");
            if (entrada == null) return;
            try {
                N = Integer.parseInt(entrada);
                if (N >= 1 && N <= 1000) ok = true;
                else JOptionPane.showMessageDialog(null, "Número fuera de rango (1-1000).");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " ingresar número válido.");
            }
        }

        for (int i = 1; i <= N; i++) {
            double tasa = -1;
            ok = false;
            while (!ok) {
                String entrada = JOptionPane.showInputDialog("Trabajador " + i + ": tasa por hora:");
                if (entrada == null) return;
                try {
                    tasa = Double.parseDouble(entrada);
                    if (tasa >= 0.5 && tasa <= 200) ok = true;
                    else JOptionPane.showMessageDialog(null, "Tasa fuera de rango (0.5 - 200).");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, " ingresar número válido.");
                }
            }

            double horas = -1;
            ok = false;
            while (!ok) {
                String entrada = JOptionPane.showInputDialog("Trabajador " + i + ": horas trabajadas en la semana:");
                if (entrada == null) return;
                try {
                    horas = Double.parseDouble(entrada);
                    if (horas >= 0 && horas <= 100) ok = true;
                    else JOptionPane.showMessageDialog(null, "Horas fuera de rango (0-100).");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
                }
            }

            double salarioB;
            if (horas <= 40) salarioB = horas * tasa;
            else salarioB = 40 * tasa + (horas - 40) * tasa * 1.5;

            double impuesto = (salarioB <= 750) ? 0 : salarioB * 0.10;
            double salarioN = salarioB - impuesto;

            JOptionPane.showMessageDialog(null,
                    "Trabajador " + i + ":\n" +
                    "Salario Bruto: " + String.format("%.2f", salarioB) + " B/.\n" +
                    "Impuesto: " + String.format("%.2f", impuesto) + " B/.\n" +
                    "Salario Neto: " + String.format("%.2f", salarioN) + " B/.");
        }
    }
}