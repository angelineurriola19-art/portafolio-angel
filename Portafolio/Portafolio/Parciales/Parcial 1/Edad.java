import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;

public class Edad {
    public static void main(String[] args) {
        try {
            String dia = JOptionPane.showInputDialog("¿En qué día nació?");
            String mes = JOptionPane.showInputDialog("¿En qué mes nació?");
            String año = JOptionPane.showInputDialog("¿En qué año nació?");
            
            int D = Integer.parseInt(dia);
            int M = Integer.parseInt(mes);
            int A = Integer.parseInt(año);

            if (D < 1 || D > 31) {
                JOptionPane.showMessageDialog(null, "El día debe estar entre 1 y 31");
                return;
            }
            if (M < 1 || M > 12) {
                JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12");
                return;
            }
            if (A < 1800 || A > 2026) {
                JOptionPane.showMessageDialog(null, "El año debe estar entre 1800 y 2026");
                return;
            }

            String diaA = JOptionPane.showInputDialog("¿Qué día es hoy?");
            String mesA = JOptionPane.showInputDialog("¿Qué mes es hoy?");
            String añoA = JOptionPane.showInputDialog("¿Qué año es hoy?");
            
            int DA = Integer.parseInt(diaA);
            int MA = Integer.parseInt(mesA);
            int AA = Integer.parseInt(añoA);

            LocalDate fechaN = LocalDate.of(A, M, D);
            LocalDate fechaA = LocalDate.of(AA, MA, DA);

            if (fechaA.isBefore(fechaN)) {
                JOptionPane.showMessageDialog(null, "La fecha actual no puede ser antes que la de nacimiento.");
                return;
            }

            Period edad = Period.between(fechaN, fechaA);

            if (edad.getYears() == 0) {

                JOptionPane.showMessageDialog(null,
                    "El bebé tiene " + edad.getMonths() + " meses y " + edad.getDays() + " días.");
            } else {
                JOptionPane.showMessageDialog(null,
                    "La edad es: " + edad.getYears() + " años.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "debe ingresar solo números.");
        }
    }
}
