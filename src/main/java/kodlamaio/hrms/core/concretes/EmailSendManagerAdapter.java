package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.EmailSendService;
import kodlamaio.hrms.fakeEmailService.FakeEmailSendManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSendManagerAdapter implements EmailSendService {


    private FakeEmailSendManager fakeEmailSendManager;

    @Autowired
    public EmailSendManagerAdapter(FakeEmailSendManager fakeEmailSendManager) {
        this.fakeEmailSendManager = fakeEmailSendManager;
    }

    @Override
    public void emailSend(String email) {
        fakeEmailSendManager.emailSend(email);
    }
}
