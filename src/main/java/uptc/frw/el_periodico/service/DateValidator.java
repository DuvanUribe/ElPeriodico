package uptc.frw.el_periodico.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {
    public static boolean isValidDate(String dateString) {
        // Verificar que la longitud de la cadena sea 8 caracteres
        if (dateString.length() != 8) {
            return false;
        }

        // Verificar que todos los caracteres sean dígitos
        if (!dateString.matches("\\d{8}")) {
            return false;
        }

        // Formato de fecha YYYYMMDD
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        try {
            // Intentar parsear la cadena como una fecha
            LocalDate.parse(dateString, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidHour(String inputHora) {
        if (inputHora == null || inputHora.length() != 6) {
            return false; // El formato debe ser de 6 dígitos
        }

        try {
            int horas = Integer.parseInt(inputHora.substring(0, 2));
            int minutos = Integer.parseInt(inputHora.substring(2, 4));
            int segundos = Integer.parseInt(inputHora.substring(4, 6));

            // Verifica que los valores estén dentro de los rangos válidos
            if (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60 && segundos >= 0 && segundos < 60) {
                return true; // Es una hora válida
            }
        } catch (NumberFormatException e) {
            return false;
            // No se pudo convertir a números enteros
        }
        return false; // No es una hora válida
    }
}
