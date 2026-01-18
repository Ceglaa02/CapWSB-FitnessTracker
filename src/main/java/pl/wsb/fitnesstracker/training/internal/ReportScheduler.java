package pl.wsb.fitnesstracker.training.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.wsb.fitnesstracker.training.api.TrainingRepository;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
class ReportScheduler {

    private final UserService userService;
    private final TrainingRepository trainingRepository;
    private final JavaMailSender emailSender;

//    @Scheduled(cron = "0 0 23 * * SUN")
    @Scheduled(initialDelay = 5000, fixedRate = 60000)
    public void generateAndSendReports() {
        userService.findAllUsers().forEach(user -> {

//            long weeklyCount = trainingRepository
//                    .findAllByUserIdAndStartTimeAfter(user.getId(), LocalDateTime.now().minusWeeks(1))
//                    .size();

            long totalCount = trainingRepository.countByUserId(user.getId());

            log.info("Generowanie raportu dla: {}", user.getEmail());
            log.info("Liczba treningów: " + totalCount);

//            sendEmail(user.getEmail(), "Podsumowanie treningów", "Liczba treningów: " + totalCount);
        });
    }

    private void sendEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("fitness-tracker@wsb.pl");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
            log.info("E-mail wysłany pomyślnie do: {}", to);
        } catch (Exception e) {
            log.error("Nie udało się wysłać e-maila do {}. Powód: {}", to, e.getMessage());
        }
    }
}