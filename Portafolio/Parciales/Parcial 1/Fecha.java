import javax.swing.JOptionPane;

public class Fecha {
    public static void main(String[] args) {
        int N = 0;
        boolean ok = false;
        while (!ok) {
            String entrada = JOptionPane.showInputDialog("Cuántas conversiones de fechas quiere hacer?");
            if (entrada == null) return;
            try {
                N = Integer.parseInt(entrada);
                if (N >= 1 && N <= 100) ok = true;
                else JOptionPane.showMessageDialog(null, "Número fuera de rango (1-100).");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            }
        }

        for (int s = 1; s <= N; s++) {
            int[][] fechas = new int[3][3];

            for (int i = 0; i < 3; i++) {
                int dia = pN("Conversión " + s + " - Ingrese el día de la fecha " + (i+1), 1, 31);

                int mes = -1;
                while (mes == -1) {
                    String mesT = JOptionPane.showInputDialog("Conversión " + s + " - Ingrese el mes de la fecha " + (i+1));
                    if (mesT == null) {
                        JOptionPane.showMessageDialog(null, "Cancelado");
                        System.exit(0);
                    }
                    mes = coM(mesT);
                    if (mes == -1) {
                        JOptionPane.showMessageDialog(null, "Mes inválido");
                    }
                }

                int anio = pN("Conversión " + s + " - Ingrese el año de la fecha " + (i+1) + " (1800-2026)", 1800, 2026);

                fechas[i][0] = dia;
                fechas[i][1] = mes;
                fechas[i][2] = anio;

                JOptionPane.showMessageDialog(null,
                        "Fecha ingresada: " + dia + " " + mes + " " + anio);
            }

            int[] min = fechas[0];
            int[] max = fechas[0];

            for (int i = 1; i < 3; i++) {
                if (Menor(fechas[i], min)) min = fechas[i];
                if (Mayor(fechas[i], max)) max = fechas[i];
            }

            JOptionPane.showMessageDialog(null,
                    "Conversión " + s + " - Fecha más baja: " + min[0] + " " + min[1] + " " + min[2] + "\n" +
                    "Conversión " + s + " - Fecha más alta: " + max[0] + " " + max[1] + " " + max[2]);
        }
    }

    public static int pN(String mensaje, int min, int max) {
        int num = -1;
        boolean valido = false;
        while (!valido) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Cancelado");
                    System.exit(0);
                }
                num = Integer.parseInt(input);
                if (num < min || num > max) {
                    JOptionPane.showMessageDialog(null, "Número fuera de rango.");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe escribir un número.");
            }
        }
        return num;
    }

    public static int coM(String mesT) {
        if (mesT == null) return -1;
        mesT = mesT.trim().toLowerCase();
        switch (mesT) {
            case "enero": return 1;
            case "febrero": return 2;
            case "marzo": return 3;
            case "abril": return 4;
            case "mayo": return 5;
            case "junio": return 6;
            case "julio": return 7;
            case "agosto": return 8;
            case "septiembre": return 9;
            case "octubre": return 10;
            case "noviembre": return 11;
            case "diciembre": return 12;
            default: return -1;
        }
    }

    public static boolean Menor(int[] f1, int[] f2) {
        if (f1[2] != f2[2]) return f1[2] < f2[2];
        if (f1[1] != f2[1]) return f1[1] < f2[1];
        return f1[0] < f2[0];
    }

    public static boolean Mayor(int[] f1, int[] f2) {
        if (f1[2] != f2[2]) return f1[2] > f2[2];
        if (f1[1] != f2[1]) return f1[1] > f2[1];
        return f1[0] > f2[0];
    }
}
