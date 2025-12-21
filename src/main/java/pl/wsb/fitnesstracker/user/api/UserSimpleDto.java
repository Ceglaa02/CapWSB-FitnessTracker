package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;

/**
 * Uproszczony obiekt transferu danych (DTO) reprezentujący podstawowe informacje o użytkowniku.
 * <p>
 * Ten rekord jest przeznaczony do użycia w scenariuszach, gdzie wymagana jest jedynie
 * identyfikacja wizualna użytkownika (np. listy wyboru, nagłówki postów, widoki tabelaryczne),
 * bez konieczności przesyłania wrażliwych danych, takich jak adres e-mail.
 * </p>
 *
 * @param id unikalny identyfikator użytkownika; może być {@code null} w operacjach zapisu
 * @param firstName imię użytkownika
 * @param lastName nazwisko użytkownika
 */
public record UserSimpleDto(@Nullable Long id, String firstName, String lastName) {

}