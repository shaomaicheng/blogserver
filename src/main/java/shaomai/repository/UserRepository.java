package shaomai.repository;

import org.springframework.stereotype.Component;
import shaomai.model.p.User;
import shaomai.model.v.VUser;


@Component
public class UserRepository {

    public VUser convertVO(User user) {
        if (user == null) {
            return null;
        }
        VUser vUser = new VUser();
        vUser.setUserId(user.getId());
        vUser.setNumber(user.getNumber());
        vUser.setEmail(user.getEmail());
        vUser.setCompany(user.getCompany());
        vUser.setLevel(user.getLevel());
        vUser.setName(user.getName());
        vUser.setTitle(user.getTitle());
        vUser.setAvatar(user.getAvatar());
        vUser.setIntroduction(user.getIntroduction());
        return vUser;
    }
}
