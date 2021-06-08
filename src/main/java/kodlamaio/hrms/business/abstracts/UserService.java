package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {
    Result add(User user);
    DataResult<User>findByEmail(String email);
    DataResult<List<User>> getAll();
}
