package pl.wsb.fitnesstracker.user.internal;

import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserSimpleDto;

/**
 * Komponent odpowiedzialny za mapowanie encji użytkownika na obiekty transferu danych (DTO).
 * Klasa ułatwia konwersję wewnętrznego modelu danych {@link User} na formaty akceptowalne
 * przez warstwę API, dbając o enkapsulację i separację warstw.
 */
@Component
class UserMapper {

    /**
     * Mapuje encję użytkownika na pełny obiekt DTO zawierający wszystkie szczegółowe informacje.
     * Używane zazwyczaj w widokach edycji lub szczegółów profilu.
     *
     * @param user encja użytkownika {@link User}, która ma zostać zmapowana
     * @return obiekt {@link UserDto} zawierający pełne dane użytkownika,
     * takie jak ID, imię, nazwisko, data urodzenia oraz e-mail
     */
    UserDto toDto(User user) {
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthdate(),
                user.getEmail());
    }

    /**
     * Mapuje encję użytkownika na uproszczony obiekt DTO zawierający jedynie podstawowe dane.
     * Idealne do listowania użytkowników lub wyświetlania krótkich podsumowań,
     * gdzie pełne dane (np. e-mail) nie są wymagane.
     *
     * @param user encja użytkownika {@link User}, która ma zostać zmapowana
     * @return obiekt {@link UserSimpleDto} zawierający tylko ID, imię i nazwisko użytkownika
     */
    UserSimpleDto toSimpleDto(User user) {
        return new UserSimpleDto(user.getId(),
                user.getFirstName(),
                user.getLastName());
    }
}