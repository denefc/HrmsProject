package kodlamaio.hrms.fakeEmailService;

import org.springframework.stereotype.Service;

@Service
public class FakeEmailSendManager {
    public void emailSend(String email){
        System.out.println(email+"<--- adresine mail gönderildi.");
    }
}
