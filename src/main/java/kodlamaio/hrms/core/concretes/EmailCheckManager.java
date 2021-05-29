package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.EmailCheckService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class EmailCheckManager implements EmailCheckService {
    //email pattern regex
    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

    @Override
    public boolean emailCheck(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).find();
    }
}
