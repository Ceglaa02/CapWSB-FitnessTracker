package pl.wsb.fitnesstracker.user.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;

import java.time.LocalDate;

/**
 * Obiekt transferu danych (DTO) reprezentujący pełne informacje o użytkowniku systemu.
 * Wykorzystywany głównie w operacjach odczytu (GET) oraz tworzenia/edycji użytkownika (POST/PUT).
 * * <p>Rekord zapewnia niemutowalność danych oraz automatyczną implementację metod
 * {@code equals()}, {@code hashCode()} i {@code toString()}.</p>
 *
 * @param id unikalny identyfikator użytkownika; może być {@code null} w przypadku tworzenia nowego rekordu
 * @param firstName imię użytkownika
 * @param lastName nazwisko użytkownika
 * @param birthdate data urodzenia użytkownika, formatowana do formatu ISO (RRRR-MM-DD) podczas serializacji do JSON
 * @param email adres e-mail użytkownika, służący również jako unikalny login w systemie
 */
public record UserDto(
        @Nullable Long id,
        String firstName,
        String lastName,
        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
        String email) {

}