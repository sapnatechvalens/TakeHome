

package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UtilClass {
    private static final Faker faker = new Faker();

    public static Map<String, String> generateRandomPatientData() {
        Map<String, String> data = new HashMap<>();
// Generate random data on each test case run
        data.put("mrn", "10" + faker.number().digits(3));
        data.put("firstName", faker.name().firstName());
        data.put("lastName", faker.name().lastName());
        data.put("phone", faker.phoneNumber().subscriberNumber(10));
        Date dobDate = faker.date().birthday(18, 65);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        data.put("dob", sdf.format(dobDate));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String dischargeDate = LocalDateTime.now().plusDays(1).withHour(13).withMinute(45).format(formatter);
        data.put("discharge", dischargeDate);
        data.put("language", "Spanish");
        data.put("timezone", "EST");

        return data;
    }
}
