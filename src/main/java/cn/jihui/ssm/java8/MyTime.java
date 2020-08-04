package cn.jihui.ssm.java8;


import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class MyTime {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        ZonedDateTime paris = ZonedDateTime.now(ZoneId.of("Europe/Paris")); // 欧洲巴黎 +1 时区
        System.out.println("巴黎时间："+paris);
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
        LocalDateTime time = LocalDateTime.of(2020, 7, 28, 12, 30, 59);
        Duration duration = Duration.between(time, LocalDateTime.now());
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMillis());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toNanos());
        System.out.println(duration.toString());
        System.out.println(duration.getSeconds());


    }
}
