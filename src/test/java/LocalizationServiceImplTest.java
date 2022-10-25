import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    @Test
    public void LocalizationService_Russia_SuccessTest() {
        LocalizationServiceImpl localization = new LocalizationServiceImpl();
        String expected = "Добро пожаловать";
        Country country = Country.RUSSIA;
        String argument = localization.locale(country);
        Assertions.assertEquals(expected, argument);
    }

    @Test
    public void LocalizationService_Other_SuccessTest() {
        LocalizationServiceImpl localization = new LocalizationServiceImpl();
        String expected = "Welcome";
        Country country = Country.USA;
        String argument = localization.locale(country);
        Assertions.assertEquals(expected, argument);
    }
}
