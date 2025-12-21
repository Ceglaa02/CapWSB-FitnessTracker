package pl.wsb.fitnesstracker.user.internal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserDto;
import pl.wsb.fitnesstracker.user.api.UserSimpleDto;

import java.util.List;
import java.util.Optional;

/**
 * Kontroler REST odpowiedzialny za obsługę operacji na użytkownikach.
 * Udostępnia punkty końcowe (endpoints) do pobierania list użytkowników w różnych formatach
 * oraz tworzenia nowych kont w systemie.
 */
@RestController
@RequestMapping("/v1/users")
class UserController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    /**
     * Konstruktor wstrzykujący wymagane zależności.
     *
     * @param userService serwis obsługujący logikę biznesową użytkowników
     * @param userMapper komponent mapujący encje na obiekty DTO
     */
    public UserController(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /**
     * Pobiera listę wszystkich użytkowników w pełnym formacie danych.
     *
     * @return lista obiektów {@link UserDto}
     */
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    /**
     * Pobiera uproszczoną listę wszystkich użytkowników (tylko podstawowe dane).
     * Endpoint przydatny do listowania użytkowników w widokach o ograniczonej przestrzeni.
     *
     * @return lista obiektów {@link UserSimpleDto}
     */
    @GetMapping("/simple")
    public List<UserSimpleDto> getAllSimpleUsers() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toSimpleDto)
                .toList();
    }

    /**
     * Pobiera szczegółowe informacje o konkretnym użytkowniku na podstawie identyfikatora.
     *
     * @param id unikalny identyfikator użytkownika
     * @return {@link Optional} zawierający encję użytkownika, jeśli został znaleziony
     */
    @GetMapping("/get/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}